package controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.User;
import validator.UserValidator;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/user")
@Controller
public class UserController {
    
    @Autowired
    UserValidator userValidator;
    
    @RequestMapping("/toLogin")
    public String toLogin(Model model) {
        // form-backing object
        model.addAttribute("user", new User());
        return "login";
    }
    
    @RequestMapping("/login")
    public String login(User user, Model model, HttpServletRequest request, BindingResult result) {
        userValidator.validate(user, result);
        if (result.hasErrors()) {
            model.addAttribute("errorMsg", "数据输入格式错误，请重新输入");
            return toLogin(model);
        }
        if ("admin".equals(user.getUserName()) && "111".equals(user.getPswd())) {
            System.out.println("登录成功！在该用户的专属session中记录登录状态。");
            request.getSession(true).setAttribute("isLogin", true);
            return "redirect:/books";
        }
        else {
            return toLogin(model);
        }
    }
}
