package com.testproject.testproject.Controller;

import com.testproject.testproject.Models.Role;
import com.testproject.testproject.Models.User;
import com.testproject.testproject.Services.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping("/moderator")
@PreAuthorize("hasAnyAuthority('MODERATOR')")
public class ModeratorController {

    final UserService userService;

    public ModeratorController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String ModeratorView(User user, @RequestParam(defaultValue = "") String keyword, Model model) {
        if (keyword == "") {
            Iterable<User> userIterable = userService.findAll();
            model.addAttribute("userlist", userIterable);
        }
        else {
            List<User> userList = userService.findByUsernameContains(keyword);
            model.addAttribute("userlist", userList);
        }
        model.addAttribute("roles", Role.values());
        return "/moderator/moderator";
    }


    @GetMapping("/roleupd/{id}")
    public String ModeratorUpdView(@PathVariable Long id, Model model) {
        model.addAttribute("oneUser", userService.findById(id).orElseThrow());
        model.addAttribute("roles", Role.values());
        return "moderator/moderator-upd";
    }

    @PostMapping("/roleupd/{id}")
    public String ModeratorUpdPost(@RequestParam(name="roles[]", required = false) String[] selectedRoles, @PathVariable Long id, Model model) {

        User oneUser = userService.findById(id).orElseThrow();
        for(var role: selectedRoles) {
            System.out.println(role);
        }
        oneUser.getRoles().clear();
        if (selectedRoles != null) {
            for (String role:
                    selectedRoles) {
                oneUser.getRoles().add(Role.valueOf(role));
            }
        }
        userService.save(oneUser);
        return "redirect:/moderator/";
    }
}
