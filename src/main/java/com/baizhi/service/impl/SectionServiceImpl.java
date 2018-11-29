package com.baizhi.service.impl;

import com.baizhi.dao.SectionMapper;
import com.baizhi.entity.Section;
import com.baizhi.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SectionServiceImpl implements SectionService {
    @Autowired
    private SectionMapper sectionMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return 0;
    }

    @Override
    public int insert(Section record) {
        return 0;
    }

    @Override
    public void insertSelective(Section section) {
        sectionMapper.insertSelective(section);
    }

    @Override
    public Section selectByPrimaryKey(String id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Section record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Section record) {
        return 0;
    }
}
