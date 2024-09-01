package com.mitanshu.scm.controller;

import com.mitanshu.scm.entities.SignupProvider;
import com.mitanshu.scm.entities.SocialLink;
import com.mitanshu.scm.entities.User;
import com.mitanshu.scm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SignupController {
    @Autowired
    UserService userService;

    @RequestMapping("/signup")
    public String signup(Model model) {
        User user = new User();
//        user.setName("Mitanshu Kumar");
        model.addAttribute("userData", user);
        return "signup";
    }

    @RequestMapping(value = "/do-signup", method = RequestMethod.POST)
    public String doSignup(@ModelAttribute("userData") User user, RedirectAttributes redirectAttributes) {
        user.setId(1l);
        user.setProvider(SignupProvider.GOOGLE);
        List<SocialLink> links = new ArrayList<>();
        links.add(new SocialLink(1l, "Facebook", "https://facebook.com/mitanshu", user));
        links.add(new SocialLink(2l, "Instagram", "https://instagram.com/mitanshu", user));
        user.setLinks(links);
        userService.save(user);
        System.out.println(user);
//        System.out.println();
        redirectAttributes.addFlashAttribute("message", "Registration successful!");

        return "redirect:/signup";
    }
}
