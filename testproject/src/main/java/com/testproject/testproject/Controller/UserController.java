package com.testproject.testproject.Controller;

import com.testproject.testproject.Models.Planet;
import com.testproject.testproject.Models.Role;
import com.testproject.testproject.Models.User;
import com.testproject.testproject.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class UserController {
    final UserService userService;


    public UserController(UserService userService)  {
        this.userService = userService;
    }
    @GetMapping("/")
    public String userView(User user, @RequestParam(defaultValue = "") String keyword, Model model) {

        if (keyword == "") {
            Iterable<User> userIterable = userService.findAll();
            model.addAttribute("userlist", userIterable);

        }
        else {
            List<User> userList = userService.findByUsernameContains(keyword);
            model.addAttribute("userlist", userList);
        }
        return "/user/user";
    }

    @GetMapping("/add")
    public String addUserView(  User user) {
        return "user/user-add";
    }

    @PostMapping("/add")
    public String addUser(@Valid User user, BindingResult bindingResult) {
        if(user.getUsername().equals("Nigger"))
            bindingResult.addError(new FieldError("user", "name",
                "Недопустимое выражение!"));
        if(bindingResult.hasErrors())
            return "user/user-add";
        userService.save(user);
        return "redirect:/user/";
    }

    @GetMapping("/user-info/{id}")
    public String detailUser(
            @PathVariable Long id,
            Model model
    )
    {
        User userObj = userService.findById(id).orElseThrow();
        model.addAttribute("oneUser", userObj);
        return "user/user-info";
    }

    @GetMapping("/user-info/{id}/del")
    public String deluser(@PathVariable Long id) {
        User userObj = userService.findById(id).orElseThrow();
        userService.delete(userObj);
        return "redirect:/user/";
    }


    @GetMapping("/user-info/{id}/upd")
    public String updUser(@PathVariable Long id, Model model)
    {
        model.addAttribute("user", userService.findById(id).orElseThrow());
        return "user/user-upd";
    }

    @PostMapping("/user-info/{id}/upd" )
    public String updPlanetPost(@Valid User user, Model model, BindingResult bindingResult, String[] roles)
     {
         if(user.getUsername().equals("Nigger"))
                bindingResult.addError(new FieldError("user", "name",
                        "Недопустимое выражение!"));
         if(bindingResult.hasErrors())
                return "user/user-upd";

         User updUser = userService.findById(user.getUID()).orElseThrow();

         updUser.getRoles().clear();
         if(roles !=null) {
             for (String role : roles) {
                user.getRoles().add(Role.valueOf(role));
             }
         }



         model.addAttribute("roles", Role.values());

         updUser.setLogin(user.getLogin());
         updUser.setEmail(user.getEmail());
         updUser.setUsername(user.getUsername());
         updUser.setSurname(user.getSurname());
         updUser.setPassword(user.getPassword());
         updUser.setDateOfTheBirth(user.getDateOfTheBirth());
         userService.save(user);
            return "redirect:/user/";
    }

}
