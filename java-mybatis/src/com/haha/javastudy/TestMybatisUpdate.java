package com.haha.javastudy;

import com.haha.javastudy.pojo.Category;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatisUpdate {
  public static void main(String[] args) throws IOException {
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession session = sqlSessionFactory.openSession();

    Category c = session.selectOne("getCategory", 3);
    c.setName("lala-one");
    session.update("updateCategory", c);

    listAll(session);

    session.commit();
    session.close();
  }

  public static void listAll(SqlSession session) {
    List<Category> cs = session.selectList("listCategory");
    for (Category c : cs) {
      System.out.println(c.getName());
    }
  }
}
