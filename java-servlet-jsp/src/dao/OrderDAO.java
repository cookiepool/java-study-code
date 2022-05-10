package dao;

import bean.Order;

import java.sql.*;

public class OrderDAO {
  public void insert(Order o) {
    try {
      Class.forName("com.mysql.jdbc.Driver");

      Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cart?characterEncoding=UTF-8",
          "root", "02881902");

      String sql = "insert into order_ values(null,?)";

      PreparedStatement ps = c.prepareStatement(sql);
      ps.setInt(1, o.getUser().getId());
      ps.execute();

      ResultSet rs = ps.getGeneratedKeys();
      if (rs.next()) {
        int id = rs.getInt(1);
        o.setId(id);
      }

      ps.close();
      c.close();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
