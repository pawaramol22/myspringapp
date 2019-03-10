package com.pawar.backend.service;

import com.pawar.web.domain.frontend.Feedback;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;


public abstract class AbstractEmailService implements EmailService {

    @Value("${default.to.address}")
    private String defaultToAddress;

    protected SimpleMailMessage prepareSimpleMessage(Feedback feedback) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(this.defaultToAddress);
        message.setFrom(feedback.getEmail());
        message.setSubject("[MySpringApp]: Feedback received from " + feedback.getFirstName() + " " + feedback.getLastName());
        message.setText(feedback.getMessage());
        return message;
    }

    @Override
    public void sendFeedback(Feedback feedback) {
        this.sendGenericMessage(this.prepareSimpleMessage(feedback));
    }
}
