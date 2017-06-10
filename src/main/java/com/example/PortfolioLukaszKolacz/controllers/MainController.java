package com.example.PortfolioLukaszKolacz.controllers;

import com.example.PortfolioLukaszKolacz.ContactService;
import com.example.PortfolioLukaszKolacz.models.forms.ContactForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * Created by Lukasz Kolacz on 05.06.2017.
 */

@Controller
public class MainController {
    @Autowired
    TemplateEngine templateEngine;
    @Autowired
    ContactService contactService;


    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("emailClass", new ContactForm());
        model.addAttribute("success", false);
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String Form(@ModelAttribute("emailClass") ContactForm contact, Model model) {
        Context context = new Context();
        context.setVariable("name", "Name: " + contact.getName());
        context.setVariable("phonenumber", "Phone number: " + contact.getPhonenumber());
        context.setVariable("message", contact.getMessage());

        String bodyHTML = templateEngine.process("emailTemplate", context);

        contactService.sendEmail(bodyHTML, contact.getEmail());

        model.addAttribute("success", true);
        System.out.println("<!> WYSŁANO MAILA <!> Adres zwrotny: " + contact.getEmail());
        return "index";
    }
}
