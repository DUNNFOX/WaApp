package com.wa.servics;


import com.wa.entity.User;
import com.wa.model.TemplateCr;
import com.wa.template.TemplateRetrieve;
import org.springframework.stereotype.Service;

@Service
public interface MessageService {

     String sendTestMessage(User user, String to);

     String sendTextMessage(User user, String to, String message);

     String sendContactsMessage(User user, String to);


     String sendInteractiveMessage(User user, String to);

     TemplateRetrieve templateRetrieve (User user);

     String createTemplate(User user, TemplateCr templateCr);




}
