package com.alpha.mapstructdemo.events;

import com.alpha.mapstructdemo.services.EmailService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.io.IOException;
import java.util.Map;

@Component
@Slf4j
@RequiredArgsConstructor
public class CustomEventListeners {
    private final EmailService mailSender;
    private final SpringTemplateEngine thymeleafTemplateEngine;

    @Value("classpath:/mail-logo.png")
    Resource resourceFile;

    @EventListener(PostCreatedEvent.class)
    @Async
    public void handlePostCreatedEvent(PostCreatedEvent event) throws InterruptedException {
        var post = event.getPost();
        Thread.sleep(1000);
        log.info("From handlePostCreatedEvent: " + post.toString());

    }

    @EventListener(PostCreatedEvent.class)
    @Async
    public void handlePostUpdatedEvent(PostCreatedEvent event) {
        var post = event.getPost();

        log.info("From handlePostUpdatedEvent: " + post.toString());

    }

    @EventListener(SendMailEvent.class)
    @Async
    public void handleMailSendMailEvent(SendMailEvent event) throws InterruptedException {
        var post = event.getPost();
        String to = "frederick.arthur@turntabl.io";
        String subject = "A thymeleaf template mail";
        Map<String, Object> variables = Map.of(
                "recipientName", "Frederick",
                "text", "You have a new mentorship request!",
                "senderName", "The _DevAssist Team");

        Context thymeleafContext = new Context();
        thymeleafContext.setVariables(variables);
        String htmlBody = thymeleafTemplateEngine.process("template-thymeleaf", thymeleafContext);

        try {
            mailSender.sendMimeMessage(to, subject, htmlBody);

        } catch (MessagingException | IOException e){
            log.error(e.getMessage());
        }

    }
}
