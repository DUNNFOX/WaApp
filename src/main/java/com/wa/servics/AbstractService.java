package com.wa.servics;

import com.wa.entity.User;
import com.wa.message.*;
import com.wa.webhook.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

public abstract class AbstractService {

    @Autowired
     RestTemplate restTemplate;

    private String phoneNumberId;

    private String authCode;

    private String to;

    private String type;

    private Map<String, Object> parameters = new HashMap<>();


    String BASE_URL = "https://graph.facebook.com/v16.0/";


    public String execute() {
        Message message = new Message();
        if (this.type == "test") {
            message.setTo(to);
            message.setMessagingProduct("whatsapp");
            Template template = new Template();
            template.setName("hello_world");
            Language language = new Language();
            language.setCode("en_US");
            template.setLanguage(language);
            message.setType("template");
            message.setTemplate(template);
        } else if (type == "text") {
            message.setMessagingProduct("whatsapp");
            message.setRecipientType("individual");
            message.setTo(to);
            message.setType("text");
            Text text = new Text();
            text.setPreviewUrl(false);
            text.setBody(parameters.getOrDefault("Message", "Hello Test").toString());
            message.setText(text);

        } else if (type == "media") {

            message.setMessagingProduct("whatsapp");
            message.setRecipientType("individual");
            message.setTo(to);
            message.setType("image");
            Image image = new Image();
        } else if (type == "contacts") {

            message.setMessagingProduct("whatsapp");
            message.setRecipientType("individual");
            message.setTo(to);
            message.setType("contacts");
            List<Contact> contacts = new ArrayList<>();
            List<Addresses> addresses = new ArrayList<>();
            List<Emails> emails = Arrays.asList(new Emails("sssikar@gmail.com", "Home"), new Emails("dev.apexsoft@gmail.com", "Work"));
            Addresses addresses1 = new Addresses();
            addresses1.setCity("Sikar");
            addresses1.setType("Home");
            addresses1.setState("Rajasthan");
            addresses1.setStreet("Adarsh Nagar");
            addresses1.setCountry("India");
            addresses1.setZip("332405");
            addresses1.setCountryCode("91");

            addresses.add(addresses1);
            addresses.add(addresses1);

            Contact contact = new Contact();
            contact.setAddresses(addresses);
            contact.setEmails(emails);
            Name name = new Name();
            name.setFirstName("Sandeep");
            name.setLastName("Sharma");
            name.setMiddleName("Kumar");
            name.setSuffix("Mr.");
            name.setFormattedName("Sandeep Sharma");
            contact.setName(name);
            contacts.add(contact);
            contacts.add(contact);
            message.setContacts(contacts);


        } else if (type == "interactive") {

            message.setMessagingProduct("whatsapp");
            message.setRecipientType("individual");
            message.setTo(to);
            message.setType("interactive");
            Interactive interactive = new Interactive();

        }

        String uri = new StringBuilder(BASE_URL)
                .append(phoneNumberId)
                .append("/")
                .append("messages").toString();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(authCode);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Message> httpEntity = new HttpEntity<>(message, headers);

        System.out.println(httpEntity.toString());
        ResponseEntity<String> result = null;
        try {
            result = restTemplate.postForEntity(uri, httpEntity, String.class);
        } catch (Exception ex) {
            return  ex.getMessage();
        }
        return result.toString();
    }

    public String getPhoneNumberId() {
        return phoneNumberId;
    }

    public void setPhoneNumberId(String phoneNumberId) {
        this.phoneNumberId = phoneNumberId;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getBASE_URL() {
        return BASE_URL;
    }

    public void setBASE_URL(String BASE_URL) {
        this.BASE_URL = BASE_URL;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    public void addProperty(String key, Object value) {
        parameters.put(key, value);
    }

    public void createTemplate(User user){
        Template template = new Template();
        template.setName("test_template");
        template.setLanguage(new Language());
        template.getLanguage().setCode("en_US");
        /*template.setCategory("UTILITY");*/

        List<Component> components = new ArrayList<>();
        Component component = new Component();
        component.setType("BODY");
        component.setText("Testing text ");

        components.add(component);
        template.setComponents(components);







        String uri = new StringBuilder(BASE_URL)
                .append(phoneNumberId)
                .append("/")
                .append("message_templates").toString();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(authCode);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Template> httpEntity = new HttpEntity<>(template, headers);

        System.out.println(httpEntity.toString());
        ResponseEntity<String> result = null;
        try {
            result = restTemplate.postForEntity(uri, httpEntity, String.class);
        } catch (Exception ex) {
ex.printStackTrace();
        }
    }
}
