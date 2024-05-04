package email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public String generateVerification(String email) {
        int code = (int) ((Math.random() * 900000) + 100000);
        restTemplate().getForEntity("http://localhost:8080/saveVerification?email=" + email + "&code=" + code, String.class);
        return String.valueOf(code);
    }

    public void sendSimpleMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }
}
