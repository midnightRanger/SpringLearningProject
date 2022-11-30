package com.testproject.testproject.Controller;

import com.testproject.testproject.Models.Role;
import com.testproject.testproject.Models.User;
import com.testproject.testproject.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Collections;

@Controller
public class RegistrationController {

    @Autowired
    private PasswordEncoder passwordEncoder;
    final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    private String regView(User user) {
        return "regis";
    }

    @PostMapping("/registration")
    private String reg(@Valid User user, BindingResult bindingResult, Model model) {
        User userFromDb = userService.findByUsername(user.getUsername());
        if(userFromDb != null) {
            model.addAttribute("message", "Пользователь с таким логином уже существует");
            return "/regis";
        }
        if(user.getUsername().equals("Nigger"))
            bindingResult.addError(new FieldError("user", "name",
                    "Недопустимое выражение!"));

        if(bindingResult.hasErrors())
            return"/regis";

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
        return "redirect:/login";
    }
}
