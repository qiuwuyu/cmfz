package com.baizhi.controller;

import com.baizhi.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/catalog")
public class CatalogController {
    @Autowired
    private CatalogService catalogService;

    @RequestMapping("getCatalog")
    private @ResponseBody Map getCatalog(){
         return catalogService.getCatalogAll();
    }
}
