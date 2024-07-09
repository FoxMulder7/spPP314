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
import java.util.Set;


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

}