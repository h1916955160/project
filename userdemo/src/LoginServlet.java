import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
        response.setContentType("text/html;charset=gbk");
        //PrintWriter out=response.getWriter();
        Admin admin=new Admin();
        admin.setLoginName(request.getParameter("loginName"));
        admin.setLoginPass(request.getParameter("loginPass"));
        String loginName=admin.getLoginName();
        AdminDao adminDao=new AdminDao();
        if(adminDao.validate(admin))
        {
            request.getSession().setAttribute("loginName",loginName);
            request.getRequestDispatcher("system.jsp").forward(request,response);
        }
        else
        {
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }

    }
}
