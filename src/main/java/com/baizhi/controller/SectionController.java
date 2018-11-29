package com.baizhi.controller;

import com.baizhi.entity.Section;
import com.baizhi.service.SectionService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RequestMapping("/SectionController")
@Controller
public class SectionController {
    @Autowired
    private SectionService sectionService;

    @RequestMapping("/addChapter")
    public void addChapter(String title, int id, MultipartFile chapter, HttpServletRequest request){
        //获取文件大小
        long size = chapter.getSize();
        double v = size / 1024.0 / 1024.0;
        System.out.println(v);
        //获取存储服务器文件的绝对路径  若不存在则创建一个文件夹
        String realPath = request.getSession().getServletContext().getRealPath("/");//当前项目路径（webapp）
        File file = new File(realPath+"/upload");
        if(!file.exists()){
            file.mkdir();
        }

        //解决文件重名
        //获取后缀
        String extension = FilenameUtils.getExtension(chapter.getOriginalFilename());
        String uuid = UUID.randomUUID().toString();
        String newName = uuid+"."+extension;
        try {
            chapter.transferTo(new File(file.getAbsolutePath(),newName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
