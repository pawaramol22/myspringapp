package com.pawar.backend.service;

import com.pawar.web.domain.frontend.Feedback;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

    void sendFeedback(Feedback feedback);

    void sendGenericMessage(SimpleMailMessage message);
}
