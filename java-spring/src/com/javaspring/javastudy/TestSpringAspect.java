package com.javaspring.javastudy;

import com.javaspring.javastudy.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringAspect {
  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});

    ProductService p = (ProductService) context.getBean("productservice");

    p.doSomeService();
  }
}
