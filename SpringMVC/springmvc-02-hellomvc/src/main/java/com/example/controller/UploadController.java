package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Controller
public class UploadController {
    
    @RequestMapping("/toFileUploadPage")
    public String toFileUploadPage() {
        return "upload";
    }
    
    @PostMapping("/file")
    @ResponseBody
    // 实测这里不加@RequestParam会报java.lang.NullPointerException（500错误），哪怕方法的参数名本身是正确的
    public String saveFile(@RequestParam("myFile") CommonsMultipartFile commonsMultipartFile, HttpServletRequest request) {
        // 保存地址
        System.out.println(request.getContextPath());
        System.out.println(request.getServletContext());
        System.out.println(request.getServletContext().getContextPath());
        System.out.println(request.getServletContext().getRealPath("/file"));
//        String path = request.getServletContext().getRealPath("");
        File realLocalFile = new File(commonsMultipartFile.getOriginalFilename());
        System.out.println(realLocalFile.getAbsolutePath());
        
        
        
        
        return commonsMultipartFile.toString();
    }
}
