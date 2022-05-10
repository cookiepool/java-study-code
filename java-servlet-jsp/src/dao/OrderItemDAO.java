package dao;

import bean.OrderItem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderItemDAO {
  public void insert(OrderItem oi) {
    try {
      Class.forName("com.mysql.jdbc.Driver");

      Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cart?characterEncoding=UTF-8",
          "root", "02881902");

      String sql = "insert into order_item values(null,?,?,?)";

      PreparedStatement ps = c.prepareStatement(sql);
      ps.setInt(1, oi.getProduct().getId());
      ps.setInt(2, oi.getNum());
      ps.setInt(3, oi.getOrder().getId());

      ps.execute();
      ps.close();
      c.close();

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
