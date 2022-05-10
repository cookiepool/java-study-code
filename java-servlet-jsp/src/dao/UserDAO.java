package dao;

import bean.User;

import java.sql.*;

public class UserDAO {
  public static void main(String[] args) {
    System.out.println();
  }

  public User getUser(String name, String password) {
    User result = null;

    try {
      Class.forName("com.mysql.jdbc.Driver");

      Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cart?characterEncoding=UTF-8",
          "root", "02881902");

      String sql = "select * from user where name = ? and password = ?";

      PreparedStatement ps = c.prepareStatement(sql);

      ps.setString(1, name);
      ps.setString(2, password);
      ResultSet rs = ps.executeQuery();

      if(rs.next()) {
        result = new User();
        result.setId(rs.getInt(1));
        result.setName(name);
        result.setPassword(password);
      }

      ps.close();
      c.close();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return result;
  }
}
