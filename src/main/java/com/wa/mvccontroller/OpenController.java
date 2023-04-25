package com.wa.mvccontroller;


import com.wa.entity.User;
import com.wa.model.TemplateCr;
import com.wa.repository.UserRepository;
import com.wa.servics.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@Controller
public class OpenController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    MessageService messageService;

    @GetMapping("/regi")
    public String regiReq() {
        return "regi";
    }

    @GetMapping("/login")
    public String loginRequest() {
        return "login";
    }

    @PostMapping("/regi")
    public String regi(Model model, @RequestParam String firstName,
                       @RequestParam String lastName,
                       @RequestParam String mobile,
                       @RequestParam String password,
                       @RequestParam String email) {
        User user = new User(0L, firstName, lastName, mobile, password, email, false, null, null, null);
        if (!validateUserWithMobile(mobile)) {
            model.addAttribute("msg", "Mobile Number is already exists ");
            model.addAttribute("user", user);
            return "regi";
        }
        userRepository.save(user);
        model.addAttribute("msg", "Registration Successfully ");
        return "login";
    }

    @PostMapping("/login")
    public String login(Model model, HttpServletRequest request, @RequestParam String mobile, @RequestParam String password) {
        User user = userRepository.findByMobile(mobile);
        if ((user != null || user.getPassword().equals(password))) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            if (!user.isConfig()) {
                return "configurewa";
            } else {
                model.addAttribute("templates", messageService.templateRetrieve(user));
                return "dashboard";
            }

        }
        model.addAttribute("msg", "Invalid User Details ");
        return "home";
    }

    @PostMapping("/config")
    public String config(Model model, HttpServletRequest request, @RequestParam String phoneId,
                         @RequestParam String key,
                         @RequestParam String wbai) {

        HttpSession session = request.getSession();
        if (session == null || session.getAttribute("user") == null) {
            model.addAttribute("session expire");
            return "home";
        }
        User loggedInUser = (User) session.getAttribute("user");
        User user = userRepository.findByMobile(loggedInUser.getMobile());
        user.setWaKey(key);
        user.setPhoneNumberId(phoneId);
        userRepository.save(user);
        model.addAttribute("templates", messageService.templateRetrieve(user));

        return "dashboard";
    }

    @GetMapping(value = "/testMessage")
    public String sentTestMessage(Model model, HttpServletRequest request, @RequestParam String to) {
        User user = (User) request.getSession().getAttribute("user");
        String returnValue = messageService.sendTestMessage(user, to);
        model.addAttribute("msg", returnValue);
        model.addAttribute("templates", messageService.templateRetrieve(user));

        //sent
        return "dashboard";
    }

    @GetMapping(value = "/textMessage")
    public String sentTextMessage(Model model, HttpServletRequest request, @RequestParam String to, @RequestParam String message) {
        User user = (User) request.getSession().getAttribute("user");
        String returnValue = messageService.sendTextMessage(user, to, message);
        model.addAttribute("msg", returnValue);

        model.addAttribute("templates", messageService.templateRetrieve(user));

        //sent
        return "dashboard";
    }

    @GetMapping(value = "/contactMessage")
    public String sentContactMessage(Model model, HttpServletRequest request, @RequestParam String to) {
        User user = (User) request.getSession().getAttribute("user");
        String returnValue =
                messageService.sendContactsMessage(user, to);
        model.addAttribute("msg", returnValue);
        model.addAttribute("templates", messageService.templateRetrieve(user));

        return "dashboard";
    }


    private boolean validateUserWithMobile(String mobile) {
        List<User> users = userRepository.findAllByMobile(mobile);
        return users.size() == 0;
    }


    @GetMapping("/createTemplate")
    public String landOnTemplateScreen() {

        return "template";
    }

    @PostMapping("/createTemplate")
    public String createTemplate(Model model,
                                 @RequestParam String name,
                                 @RequestParam String lang,
                                 @RequestParam String catagory,
                                 @RequestParam String ht,
                                 @RequestParam String bt,
                                 @RequestParam String ft,
                                 HttpServletRequest request,
                                 @RequestParam(required = false) String hdExp,
                                 @RequestParam(required = false) String[] bdExp,
                                 @RequestParam String btnText,
                                 @RequestParam String btnNumber,
                                 @RequestParam String urlText,
                                 @RequestParam String url) {

        HttpSession session = request.getSession();

        if (session == null || session.getAttribute("user") == null) {
            model.addAttribute("msg", "Session Expired Please Login Again ");
            return "login";
        }
        User user = (User) session.getAttribute("user");
        TemplateCr templateCr = new TemplateCr();
        templateCr.setCategory(catagory);
        templateCr.setBt(bt);
        templateCr.setName(name);
        templateCr.setLanguage(lang);
        templateCr.setHt(ht);
        templateCr.setFt(ft);
        templateCr.setHdExp(hdExp);
        templateCr.setBtnText(btnText);
        templateCr.setBtnNumber(btnNumber);
        templateCr.setUrlText(urlText);
        templateCr.setUrl(url);
        if(bdExp != null && bdExp.length >0)
        templateCr.setBdExp(Arrays.asList(bdExp));
        String returnValue = messageService.createTemplate(user, templateCr);
        model.addAttribute("templates", messageService.templateRetrieve(user));

        model.addAttribute("msg", returnValue);
        //sent
        return "dashboard";
    }


}
