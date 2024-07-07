package net.proselyte.springbootdemo.comtroller;

import net.proselyte.springbootdemo.model.Role;
import net.proselyte.springbootdemo.model.User;
import net.proselyte.springbootdemo.service.RoleService;
import net.proselyte.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;
import java.util.Collections;


@Controller
public class LoginController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public LoginController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping(value = "/login")
    public String showMainPage() {
        return "login";
    }

    @GetMapping("/registration")
    public String create(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        Role defaultRole = roleService.findById(2L);
        modelMap.addAttribute("defaultRole", defaultRole);
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute(value = "user") User user) {
        Collection<Role> defaultRole = Collections.singleton(roleService.findById(2L));
        user.setRoles(defaultRole);
        userService.save(user);

        return "redirect:/login";
    }
}