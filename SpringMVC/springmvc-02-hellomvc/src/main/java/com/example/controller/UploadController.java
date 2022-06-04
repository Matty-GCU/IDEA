package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {
    
    @RequestMapping("/toFileUploadPage")
    public String toFileUploadPage() {
        return "upload";
    }
    
    /**
     * @RequestParam("file")：将name="file"的input控件得到的文件封装成CommonsMultipartFile对象
     * 实测这里不加@RequestParam会报java.lang.NullPointerException（500错误），哪怕方法的参数名本身是正确的
     */
    @PostMapping("/file")
    @ResponseBody
    public String saveFile(@RequestParam("myFile") CommonsMultipartFile commonsMultipartFile, HttpServletRequest request) {
        // 已上传文件的保存地址，即该文件在服务器端的文件系统中的真实地址
        // Gets the real path corresponding to the given virtual path.
        // For example, if path is equal to /index.html,
        // this method will return the absolute file path on the server's filesystem to which a request of the form http://<host>:<port>/<contextPath>/index.html would be mapped,
        // where <contextPath> corresponds to the context path of this ServletContext.
        String savingDirPath = request.getServletContext().getRealPath("/file");
        File savingDir = new File(savingDirPath);
        if (! savingDir.exists()) {
            savingDir.mkdir();
        }
        String fileName = commonsMultipartFile.getOriginalFilename();
        try {
            commonsMultipartFile.transferTo(new File(savingDirPath + "/" + fileName));
            return "文件已成功保存到服务器端文件系统的" + savingDirPath + "目录下！文件名仍为" + fileName + "！";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "文件保存失败";
    }
}
