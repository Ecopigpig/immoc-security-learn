package com.imooc.web.controller;

import com.imooc.web.dto.FileInfo;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;

/**
 * @program: immoc-security-learn
 * @description: 文件控制器
 * @author: linxinting
 * @create: 2020-11-25 14:52
 **/
@RestController
@RequestMapping("/file")
public class FileController {

    private String folder = "D:\\software\\lxt-projects\\immoc-security-learn\\imooc-security-demo\\src\\main\\java\\com\\imooc\\web\\controller";
    @PostMapping
    public FileInfo upload(MultipartFile file) throws IOException {
        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());
        File localFile = new File(folder,System.currentTimeMillis()+".txt");
        //把上传的文件写到指定文件夹中
        file.transferTo(localFile);
        return new FileInfo(localFile.getAbsolutePath());
    }

    @GetMapping("/{id}")
    public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response){
        try (InputStream inputStream = new FileInputStream(new File(folder,id+".txt"));
             OutputStream outputStream = response.getOutputStream();){
            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition","attachment;filename=test.txt");
            //把文件的输入流写到文件的输出流里面去
            IOUtils.copy(inputStream,outputStream);
            outputStream.flush();
        }catch (Exception e){

        }
    }
}
