package email.controller;

import email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailResource {

    @Autowired
    private EmailService emailService;

    @PostMapping("/resetPassword")
    public void resetPassword(@RequestParam(name = "email") String email) {
        String code = emailService.generateVerification(email);
        emailService.sendSimpleMessage(email, "Reset Password", "您的驗證碼為: " + code);
    }

}
