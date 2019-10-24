import com.mysql.jdbc.PreparedStatement;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;

public class CheckServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String pass = request.getParameter("password");
        AdminDao adminDao=new AdminDao();
            if(adminDao.isExists(username)==0)
            {
                adminDao.addUser(username,pass);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
            else {
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
        this.doGet(request,response);
    }
}
