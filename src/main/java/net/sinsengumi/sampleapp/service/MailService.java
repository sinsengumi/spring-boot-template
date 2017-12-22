package net.sinsengumi.sampleapp.service;

import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MailService {

    @Autowired
    MailSender mailSender;
    @Autowired
    @Qualifier("emailTemplateEngine")
    TemplateEngine templateEngine;

    @Async
    public void sendMail(String from, String to, String subject, String text) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(from);
        msg.setTo(to);
        msg.setSubject(subject);
        msg.setText(text);

        try {
            mailSender.send(msg);
            log.info("finished sending mail. from = {}, to = {}, subject = {}", from, to, subject);
        } catch (MailException e) {
            log.error(e.getMessage(), e);
        }
    }

    @Async
    public void sendTemplateMail(String from, String to, String subject, String template, Map<String, Object> params) {
        Context context = new Context(Locale.getDefault(), params);
        String content = templateEngine.process(template, context);

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(from);
        msg.setTo(to);
        msg.setSubject(subject);
        msg.setText(content);

        try {
            mailSender.send(msg);
            log.info("finished sending mail. from = {}, to = {}, subject = {}", from, to, subject);
        } catch (MailException e) {
            log.error(e.getMessage(), e);
        }
    }
}
