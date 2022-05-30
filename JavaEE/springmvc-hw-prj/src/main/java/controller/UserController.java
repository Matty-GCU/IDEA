package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.User;

@RequestMapping("/user")
@Controller
public class UserController {
    
    @RequestMapping("/toLogin")
    public String toLogin(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }
    
    @RequestMapping("/login")
    public String login(User user, Model model) {
        if ("admin".equals(user.getUserName()) && "111".equals(user.getPswd())) {
            System.out.println(11111111);
            System.out.println(11111111);
            System.out.println(11111111);
            System.out.println(111111111);
            return "forward:/books";
        }
        else {
            return toLogin(model);
        }
    }
}
