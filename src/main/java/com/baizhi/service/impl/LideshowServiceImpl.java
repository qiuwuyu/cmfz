package com.baizhi.service.impl;

import com.baizhi.dao.LideshowMapper;
import com.baizhi.entity.Lideshow;
import com.baizhi.service.LideshowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class LideshowServiceImpl implements LideshowService {
    @Autowired
    private LideshowMapper lideshowMapper;

    @Override
    public void deleteByPrimaryKey(String id) {
        lideshowMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void insert(Lideshow record) {
        lideshowMapper.insert(record);
    }

    @Override
    public void insertSelective(Lideshow record) {
        lideshowMapper.insertSelective(record);
    }
    @Override
    public void myInsertSelective(Lideshow record) {
        lideshowMapper.myInsertSelective(record);
    }

    @Override
    public Lideshow selectByPrimaryKey(String id) {

        return null;
    }

    @Override
    public void updateByPrimaryKeySelective(Lideshow record) {

    }

    @Override
    public void updateByPrimaryKey(Lideshow record) {
        lideshowMapper.updateByPrimaryKey(record);
    }

    @Override
    public Map getLideshowAll(int page, int rows) {
        int start=(page-1)*rows;
        Map map=new HashMap();
        List<Lideshow> list = lideshowMapper.getLideshowMapper(start,rows);
        //存入map中，两个key是固定的，不能随意写
        map.put("rows", list);
        map.put("total", 10);
        return map;
    }
}
