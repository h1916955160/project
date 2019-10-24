import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.valueOf(request.getParameter("user_id"));
        UserDao userDao=new UserDao();
        try {
            userDao.deleteUser(id);
            request.getRequestDispatcher("jsp/member_list.jsp").forward(request,response);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            request.getRequestDispatcher("error.jsp").forward(request,response);
        }
    }
}
