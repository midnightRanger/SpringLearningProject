package com.testproject.testproject.Controller;

import com.testproject.testproject.Models.User;
import com.testproject.testproject.Services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller
public class UserController {
    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/add")
    public String addUserView(User user) {
        return "user/user-add";
    }

    @PostMapping("/user/add")
    public String addUser(@Valid User user, BindingResult bindingResult) {

        if(user.getName().equals("Nigger"))
            bindingResult.addError(new FieldError("user", "name",
                "Недопустимое выражение!"));
        if(bindingResult.hasErrors())
            return "user/user-add";
        userService.save(user);
        return "redirect:/user/add/";
    }


}
