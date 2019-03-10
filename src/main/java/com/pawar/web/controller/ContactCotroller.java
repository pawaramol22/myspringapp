package com.pawar.web.controller;


import com.pawar.backend.service.EmailService;
import com.pawar.web.domain.frontend.Feedback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ContactCotroller {

    public static final String FEEDBACK_MODEL_KEY = "feedback";
    public static final String CONTACT_US_VIEW = "contact/contact";

    private static final Logger LOG = LoggerFactory.getLogger(ContactCotroller.class);

    @Autowired
    private EmailService emailService;

    @RequestMapping(value="/contact", method=RequestMethod.GET)
    public String contactGet(ModelMap model){
        Feedback feedback = new Feedback();
        model.addAttribute(FEEDBACK_MODEL_KEY, feedback);
        return CONTACT_US_VIEW;
    }

    @RequestMapping(value="/contact", method=RequestMethod.POST)
    public String contactPost(@ModelAttribute(FEEDBACK_MODEL_KEY) Feedback feedback){
        emailService.sendFeedback(feedback);
        return CONTACT_US_VIEW;
    }
}
