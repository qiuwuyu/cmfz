package com.baizhi.controller;


import com.baizhi.entity.Lideshow;
import com.baizhi.service.LideshowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/lideshow")
public class LideshowController {
    @Autowired
    private LideshowService lideshowService;

    //构建数据表格
    @RequestMapping("/getLideshowAll")
    public @ResponseBody Map getListshowAll(int page, int rows){
        //int start,int rows
        /*int start = 1;
        int rows = 2;*/
        System.out.println("hjkhasdfkljasjklfjsda");

        return lideshowService.getLideshowAll(page,rows);
    }
    //构建数据表格===END===

    //添加轮播图
    @RequestMapping("addLideshow")
    public @ResponseBody  boolean addLideshow(HttpServletRequest request,Lideshow lideshow,MultipartFile pic) throws IOException {
        //文件上传
        //获取文件名
        String fileName = pic.getOriginalFilename();
        //获取新文件名
        String newFileName = new Date().getTime()+"_"+fileName;
        System.out.println("~~~~~~~文件名~~~~~~~~~~"+newFileName);
        //获取绝对路径
        String req = request.getRealPath("/img/shouye");
        //将文件上传到服务器
        pic.transferTo(new File(req+"\\"+newFileName));
        //将路径赋值给auction对象
        try {
            lideshow.setImgpath("/img/shouye/"+newFileName);
            lideshow.setId(UUID.randomUUID().toString());
            lideshowService.myInsertSelective(lideshow);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    //添加轮播图===END===

    //删除轮播图
    @RequestMapping("deleteLideshow")
    public @ResponseBody boolean deleteLideshow(String delRow){
        //删除库文件
        try {
            System.out.println("get delRow value is " + delRow);
            lideshowService.deleteByPrimaryKey(delRow);
            return true;
        }catch (Exception e){
            return false;
        }

    }
    //删除轮播图===END===

    //修改轮播图状态
    @RequestMapping("updeteLideshow")
    public @ResponseBody boolean updeteLideshow(Lideshow lideshow){
        try {
            lideshowService.updateByPrimaryKey(lideshow);
            return true;
        }catch (Exception e){
            return  false;
        }
    }
}
