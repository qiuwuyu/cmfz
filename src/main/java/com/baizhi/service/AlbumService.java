package com.baizhi.service;

import com.baizhi.entity.Album;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AlbumService {
    //自己写的
    Map getAlbumAll(@Param("start") int start, @Param("pageSize") int pageSize);
}
