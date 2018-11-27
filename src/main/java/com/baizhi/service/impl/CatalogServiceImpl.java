package com.baizhi.service.impl;

import com.baizhi.dao.CatalogDao;
import com.baizhi.entity.Catalog;
import com.baizhi.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CatalogServiceImpl implements CatalogService {
    @Autowired
    private CatalogDao catalogDao;

    @Override
    public Map getCatalogAll() {
        Map map = new HashMap();
        List<Catalog> catalogList = catalogDao.getCatalogAll();
        for (Catalog c:catalogList) {
            System.out.println(c);
        }
        map.put("catalogAll",catalogList);
        return map;
    }
}
