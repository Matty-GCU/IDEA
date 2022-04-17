package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloControllerTwo {
    
    @RequestMapping("/two")
    public String sayHello(Model model) {
        String result = "Hello SpringMVC!";
        model.addAttribute("result", result);
        return "hello";
    }
    
}
