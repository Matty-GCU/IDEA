package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@Controller
public class DownloadController {
    
    @RequestMapping("/toFileDownloadPage")
    public String toFileDownloadPage() {
        return "download";
    }
    
    @RequestMapping("/downloadFile")
    public String downloadFile(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        // 1. 获取要下载的文件的File实例
        String savingDirPath = request.getServletContext().getRealPath("/file");
        File savingDir = new File(savingDirPath);
        File file = Objects.requireNonNull(savingDir.listFiles())[0];
        
        // 2. 设置响应头
        // Clears any data that exists in the buffer as well as the status code, headers.
        // The state of calling getWriter or getOutputStream is also cleared.
        response.reset();
        // Sets a response header with the given name and value.
        // If the header had already been set, the new value overwrites the previous one.
        // The containsHeader method can be used to test for the presence of a header before setting its value.
        response.setHeader("Content-Type", "application/x-msdownload");
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(file.getName(), StandardCharsets.UTF_8));
        response.setCharacterEncoding("UTF-8");
        
        // 3. 文件读写操作
        ServletOutputStream output = response.getOutputStream();
        InputStream input = new FileInputStream(file);
        // 每次最多读写1KB的数据
        byte[] b = new byte[1024];
        // Reads some number of bytes from the input stream and stores them into the buffer array b.
        // The number of bytes actually read is returned as an integer.
        // If no byte is available because the stream is at the end of the file, the value -1 is returned
        while (input.read(b) != -1) {
            output.write(b);
        }
        output.flush();
        output.close();
        return null;
    }
    
}
