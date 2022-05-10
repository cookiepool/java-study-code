import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8"); // 让其支持中文
    String name = req.getParameter("name");
    String password = req.getParameter("password");

    System.out.println("name: " + name);
    System.out.println("password: " + password);

//    String html = null;

    if("admin".equals(name) && "123456".equals(password)) {
//      html = "<h2 style='color:green'>Success!</h2>";
      req.getRequestDispatcher("success.html").forward(req, resp); // 服务端跳转
    } else {
//      html = "<h2 style='color:red'>Fail!</h2>";
//      req.getRequestDispatcher("fail.html").forward(req, resp);
        resp.sendRedirect("fail.html");
    }

//    resp.setContentType("text/html; charset=utf-8"); // 让其支持中文
//    PrintWriter pw = resp.getWriter();
//    pw.println(html);
  }
}
