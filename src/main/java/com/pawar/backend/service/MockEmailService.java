package com.pawar.backend.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;


public class MockEmailService extends AbstractEmailService {

    private static final Logger LOG = LoggerFactory.getLogger(MockEmailService.class);

    @Override
    public void sendGenericMessage(SimpleMailMessage message){
        LOG.debug("Sending mock email...");
        LOG.debug(message.toString());
        LOG.debug("Mock email sent..");
    }
}
