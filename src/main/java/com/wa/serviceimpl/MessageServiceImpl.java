package com.wa.serviceimpl;

import com.wa.entity.User;
import com.wa.model.TemplateCr;
import com.wa.servics.AbstractService;
import com.wa.servics.MessageService;
import com.wa.template.Button;
import com.wa.template.Example;
import com.wa.template.Template;
import com.wa.template.TemplateRetrieve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class MessageServiceImpl extends AbstractService implements MessageService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public String sendTestMessage(User user, String to) {
        setAuthCode(user.getWaKey());
        setPhoneNumberId(user.getPhoneNumberId());
        setTo(to);
        setType("test");

        execute();
        createTemplate(user);
        return null;
    }

    @Override
    public String sendTextMessage(User user, String to, String message) {
        setAuthCode(user.getWaKey());
        setPhoneNumberId(user.getPhoneNumberId());
        setTo(to);
        addProperty("Message", message);
        setType("text");
        createTemplate(user);
        return execute();

    }

    @Override
    public String sendContactsMessage(User user, String to) {
        setAuthCode(user.getWaKey());
        setPhoneNumberId(user.getPhoneNumberId());
        setTo(to);
        setType("contacts");
        return execute();
    }

    @Override
    public String sendInteractiveMessage(User user, String to) {
        setAuthCode(user.getWaKey());
        setPhoneNumberId(user.getPhoneNumberId());
        setTo(to);
        setType("interactive");
        return execute();
    }

    @Override
    public TemplateRetrieve templateRetrieve(User user) {
        String url = new StringBuilder(getBASE_URL()).append(user.getWbai()).append("/").append("message_templates")
                .append("?")
                .append("access_token")
                .append("=")
                .append(user.getWaKey())
                .toString();
        return restTemplate.getForEntity(url, TemplateRetrieve.class).getBody();
    }

    @Override
    public String createTemplate(User user, TemplateCr templateCr) {
        String url = new StringBuilder(getBASE_URL()).append(user.getWbai()).append("/").append("message_templates")
                .toString();
        Template template = new Template();
        template.setName(templateCr.getName());
        template.setCategory(templateCr.getCategory());
        template.setLanguage(templateCr.getLanguage());
        List<com.wa.template.Component> components = new ArrayList<>();
        com.wa.template.Component component = new com.wa.template.Component();
        if (!(templateCr.getHt() == null || templateCr.getHt().isBlank() || templateCr.getHt().isEmpty())) {
            component.setType("HEADER");
            component.setFormat("TEXT");
            component.setText(templateCr.getHt());
            Example example = new Example();
            List<String> hdex = Arrays.asList(templateCr.getHdExp());
            example.setHeaderText(hdex);
            component.setExample(example);
            components.add(component);
        }
        com.wa.template.Component body = new com.wa.template.Component();
        body.setType("BODY");
        body.setText(templateCr.getBt());
        List<List<String>> bdyExp = Arrays.asList(templateCr.getBdExp());
        Example bdExp = new Example();
        bdExp.setBodyText(bdyExp);
        body.setExample(bdExp);
        components.add(body);
        if (!(templateCr.getBt() == null || templateCr.getBt().isBlank() || templateCr.getBt().isEmpty())) {
            com.wa.template.Component footer = new com.wa.template.Component();
            footer.setType("FOOTER");
            footer.setText(templateCr.getFt());
            components.add(footer);
        }
        com.wa.template.Component btn = new com.wa.template.Component();
        btn.setType("BUTTONS");
        List<Button> buttons = new ArrayList<>();
        if (templateCr.getBtnText() != null && !templateCr.getBtnText().isBlank()) {
            Button cButton = new Button();
            cButton.setType("PHONE_NUMBER");
            cButton.setText(templateCr.getBtnText());
            cButton.setPhoneNumber(templateCr.getBtnNumber());
            buttons.add(cButton);
        }
        if (templateCr.getUrl() != null && !templateCr.getUrl().isEmpty()) {
            Button urlButton = new Button();
            urlButton.setType("URL");
            urlButton.setText(templateCr.getUrlText());
            urlButton.setUrl(templateCr.getUrl());
            buttons.add(urlButton);
        }
        btn.setButtons(buttons);
        components.add(btn);
        template.setComponents(components);
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(user.getWaKey());
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Template> httpEntity = new HttpEntity<>(template, headers);
        System.out.println(template.toString());
        ResponseEntity<String> result = null;
        try {
            result = restTemplate.postForEntity(url, httpEntity, String.class);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return result.toString();
    }
}
