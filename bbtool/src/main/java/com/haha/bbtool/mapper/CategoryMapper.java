package com.haha.bbtool.mapper;

import com.haha.bbtool.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CategoryMapper {
  @Select("select * from category_")
  List<Category> findAll();
}
