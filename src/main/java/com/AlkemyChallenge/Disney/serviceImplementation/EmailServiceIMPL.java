package com.AlkemyChallenge.Disney.serviceImplementation;

import com.AlkemyChallenge.Disney.service.EmailService;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class EmailServiceIMPL  implements EmailService{

@Value("${alkemy.disney.email.sender}")
private String emailSender;
@Value("${alkemy.disney.email.enable}")
private boolean enable;
@Value("${EMAIL_API_KEY}")
private String apikey;
    
    @Override
    public void sendWelcomeEmailTo(String to) {
        if (!enable) {
            return;
        }
        
        Email fromEmail= new Email(emailSender);
        Email toEmail= new Email(to);
        Content content=new Content(
                "text/html",
                "<html >\n" +
"\n" +
"<body>\n" +
"    <style>\n" +
"        body{\n" +
"    display: flex;\n" +
"    flex-direction: column;\n" +
"    justify-content: center;\n" +
"    align-items: center;\n" +
"    text-align: center;\n" +
"}\n" +
".alkemy_logo{\n" +
"width: 50%;\n" +
"}\n" +
".disney{\n" +
"    width: 20%;\n" +
"}\n" +
"    </style>\n" +
"    <img class=\"alkemy_logo\" src=\"https://www.alkemy.org/static/media/alkemyLogo.2daef856.svg\"   alt=\"\">\n" +
"    <h1>Bienvenido a Alkemy Disney App</h1>\n" +
"    <p>Ya podes utilizar tu cuenta</p>\n" +
"    <img class=\"disney\" src=\"https://1000marcas.net/wp-content/uploads/2020/01/Walt-Disney-logo.png\" alt=\"\">\n" +
"\n" +
"   \n" +
"</body>\n" +
"</html>"
        );
        String subject="Alkemy Disney app";
        Mail mail=new Mail(fromEmail, subject, toEmail, content);
        SendGrid sg=new SendGrid(apikey);
        Request request=new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response=sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException e) {
            System.out.println("Error tryind to send the email");
        }
        
    }
    
}
