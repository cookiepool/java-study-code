package servlet;

import bean.User;
import dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserLoginServlet extends HttpServlet {
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException
  {

    String name = request.getParameter("name");
    String password = request.getParameter("password");

    User user = new UserDAO().getUser(name, password);

    if (null != user) {
      request.getSession().setAttribute("user", user);
      response.sendRedirect("/listProduct");
    } else {
      response.sendRedirect("/login.jsp");
    }
  }
}
