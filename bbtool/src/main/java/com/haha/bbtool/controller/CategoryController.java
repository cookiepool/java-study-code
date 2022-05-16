package com.haha.bbtool.controller;

import com.haha.bbtool.mapper.CategoryMapper;
import com.haha.bbtool.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
  CategoryMapper categoryMapper;

  @Autowired
  public CategoryController(CategoryMapper categoryMapper) {
    this.categoryMapper = categoryMapper;
  }

  @RequestMapping("/listCategory")
  public String listCategory() {
//    return "Hello SpringBoot Mybatis, haha lala!!!";
    List<Category> cs = categoryMapper.findAll();

    String str = "";
    for(Category c : cs) {
      str += c.getName();
    }

    return str;
  }
}
