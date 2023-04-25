package com.wa.mvccontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {


    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/wa")
    public String wa() {
        return "index";
    }
}
