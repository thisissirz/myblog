package com.whgc.controller.adminController;

import com.whgc.bean.User;
import com.whgc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @GetMapping({"/login", "/admin/login"})
    public String login(HttpSession session) {
        session.removeAttribute("user");
        return "admin/login";
    }

    @PostMapping("/admin/indexs")
    public String loginAfter(String username, String password, Model model, HttpSession session) {
        if (username == null || password == null || "".equals(username) || "".equals(password)) {
            model.addAttribute("msg", "账号密码不能为空，请重新尝试！");
            return "/admin/login";
        }
        User user = userService.getUser(username, password);
        if (user == null) {
            model.addAttribute("msg", "账号密码有误，请重新尝试！");
            return "/admin/login";
        }
        session.setAttribute("user", user);
        return "redirect:/admin/home";
    }

    @GetMapping("/admin/home")
    public String home() {
        return "admin/home";
    }

    @GetMapping("/admin/logOut")
    public String logOut(HttpSession session) {
        session.removeAttribute("user");
        return "admin/home";
    }

}
