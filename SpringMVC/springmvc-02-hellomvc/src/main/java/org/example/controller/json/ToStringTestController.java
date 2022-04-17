package org.example.controller.json;

import org.example.controller.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/json1", produces = "application/json;charset=utf-8")
public class ToStringTestController {
    
    @RequestMapping("/test1")
    @ResponseBody
    public String test1() {
        // 关于@ResponseBody：（简单来说就是返回值不会被当作视图进行解析，而是直接作为返回内容）
        // Annotation that indicates a method return value should be bound to the web response body.
        return "111";
    }
    
    @RequestMapping("/test2")
    @ResponseBody
    public String test2() {
        User user = new User("1", "English Test & 中文测试", 18);
        // 其实我们将user对象直接用toString方法转换成这样的字符串，也是符合JSON格式的
        return user.toString();
    }
    
}