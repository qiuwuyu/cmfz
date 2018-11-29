package com.baizhi.service;

import com.baizhi.dao.LideshowMapper;
import com.baizhi.entity.Lideshow;

import java.util.List;
import java.util.Map;

public interface LideshowService {
    void deleteByPrimaryKey(String id);

    void insert(Lideshow record);

    void insertSelective(Lideshow record);
    void myInsertSelective(Lideshow record);

    Lideshow selectByPrimaryKey(String id);

    void updateByPrimaryKeySelective(Lideshow record);

    void updateByPrimaryKey(Lideshow record);

    //查询所有 分页
    Map getLideshowAll(int page, int rows);
}
