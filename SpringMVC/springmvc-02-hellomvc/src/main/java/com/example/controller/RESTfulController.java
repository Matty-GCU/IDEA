package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RESTfulController {
    
    /**
     * 无风格：/item?a=1&b=2
     */
    @RequestMapping("/item")
    public String getAPlusB1(int a, int b, Model model) {
        model.addAttribute("result", a + b);
        return "hello";
    }
    
    /**
     * RESTful风格：/item/1/2
     */
    @RequestMapping("/item/{a}/{b}")
    public String getAPlusB2(@PathVariable int a, @PathVariable int b, Model model) {
        model.addAttribute("result", a + b);
        return "hello";
    }
    
    /**
     * （在下面这两个方法中，我已经尽量使各种命名都符合RESTful规范，但这个规范不是重点，重点是在SpringMVC中如何用@RequestMapping注解实现它。）
     * GET /article
     */
    @RequestMapping(path = "/article", method = RequestMethod.GET)
//    @GetMapping("/article")
    public String getArticle(@PathVariable int articleId, Model model) {
        // 这里的方法体仅作示范
        System.out.println("查到一篇文章");
        // 实际上并不存在/WEB-INF/jsp/article.jsp。
        return "article";
    }
    
    /**
     * POST /article
     */
    @RequestMapping(path = "/article", method = RequestMethod.POST)
//    @PostMapping("/article")
    public String addArticle(@PathVariable int articleId, Model model) {
        System.out.println("发布一篇文章");
        return "article";
    }
    
    //此时如果用除了get和post方法之外的其他请求方法访问URL"/article"，会报405错误（注意不是404也不是500）
}
