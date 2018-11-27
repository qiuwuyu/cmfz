package com.baizhi.entity;

import lombok.Data;

import java.util.List;

@Data
public class Catalog {
    private String id;
    private String title;
    private String iconCls;
    private String parentId;
    private String url;
    private List<Catalog> catalogList;
}
