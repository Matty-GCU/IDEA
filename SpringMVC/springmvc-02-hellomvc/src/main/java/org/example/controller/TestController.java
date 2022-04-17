package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试Spring MVC中不使用视图解析器的转发和重定向
 */
@Controller
public class TestController {
    
    @RequestMapping("/forward1")
    public String testForward1(Model model) {
        String result = "通过转发，访问/index.jsp，地址栏无变化";
        model.addAttribute("message", result);
        // 这种写法只有当ViewResolver不存在时才生效
        return "/index.jsp";
    }
    
    @RequestMapping("/forward2")
    public String testForward2(Model model) {
        String result = "通过转发，访问/index.jsp，地址栏无变化";
        model.addAttribute("message", result);
        // 这种写法可以无视ViewResolver
        return "forward:/index.jsp";
    }
    
    @RequestMapping("/redirect")
    public String testRedirect(Model model) {
        String result = "（可以无视ViewResolver）通过重定向，访问/index.jsp，地址有变化！";
        model.addAttribute("message", result);
        // 这种写法可以无视ViewResolver
        return "redirect:/index.jsp";
    }
}
