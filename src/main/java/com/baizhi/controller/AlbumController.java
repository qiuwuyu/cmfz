    package com.baizhi.controller;

import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @RequestMapping("getAlbumAll") public @ResponseBody
    Map getAlbumAll(int page, int rows){
        return albumService.getAlbumAll(page,rows);
    }
}
