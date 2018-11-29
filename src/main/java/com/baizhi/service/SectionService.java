package com.baizhi.service;


import com.baizhi.entity.Section;

public interface SectionService {
    int deleteByPrimaryKey(String id);

    int insert(Section record);

    void insertSelective(Section section);

    Section selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Section record);

    int updateByPrimaryKey(Section record);
}
