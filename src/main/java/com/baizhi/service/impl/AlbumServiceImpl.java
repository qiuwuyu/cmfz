package com.baizhi.service.impl;

import com.baizhi.dao.AlbumMapper;
import com.baizhi.entity.Album;
import com.baizhi.entity.Lideshow;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private  AlbumMapper albumMapper;

    @Override
    public Map getAlbumAll(int page, int rows) {
        int start=(page-1)*rows;
        Map map=new HashMap();
        List<Album> list = albumMapper.getAlbumAll(start,rows);
        //存入map中，两个key是固定的，不能随意写
        map.put("rows", list);
        map.put("total", 10);
        return map;
    }
}
