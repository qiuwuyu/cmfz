package com.baizhi.dao;

import com.baizhi.entity.Lideshow;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LideshowMapper {

    int deleteByPrimaryKey(String id);

    int insert(Lideshow record);

    int insertSelective(Lideshow record);

    int myInsertSelective(Lideshow record);

    Lideshow selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Lideshow record);

    int updateByPrimaryKey(Lideshow record);

    //查询所有 分页
    List<Lideshow> getLideshowMapper(@Param("start") int start,@Param("pageSize") int pageSize);
}