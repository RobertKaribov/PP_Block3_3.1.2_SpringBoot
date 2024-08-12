package ru.karibian.springboot.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.karibian.springboot.model.User;
import ru.karibian.springboot.service.UserServices;

@Controller
public class UserController {
    private final UserServices userServices;

    @Autowired
    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping("/")
    public String displayAllUsers(Model model) {
        model.addAttribute("users", userServices.findAllUsers());
        return "index";
    }

    @GetMapping("/show")
    public String displayUserById(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", userServices.findUserById(id));
        return "show";
    }

    @GetMapping("/new")
    public String prepareNewUserForm(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute("user") @Valid User user,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "new";
        userServices.createUser(user);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String prepareEditUserForm(@RequestParam int id, Model model) {
        model.addAttribute("user", userServices.findUserById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") @Valid User user,
                             BindingResult bindingResult, @RequestParam int id) {
        if (bindingResult.hasErrors())
            return "edit";
        userServices.updateUser(id, user);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteUserById(@RequestParam int id) {
        userServices.deleteUserById(id);
        return "redirect:/";
    }
}
