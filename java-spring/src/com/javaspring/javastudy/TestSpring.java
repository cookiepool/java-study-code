package com.javaspring.javastudy;

import com.javaspring.javastudy.pojo.Category;
import com.javaspring.javastudy.pojo.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});

//    Category c = (Category) context.getBean("category");
    Product p = (Product) context.getBean("product");

    System.out.println(p.getName());
    System.out.println(p.getCategory().getName());
  }
}
