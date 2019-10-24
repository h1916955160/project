import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GabageAlter extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        int id=Integer.parseInt(request.getParameter("gid"));
        GarbageDao garbageDao=new GarbageDao();
        String gname = request.getParameter("gname");
        String gdesc = request.getParameter("gdesc");
        String gpic=request.getParameter("gpic");
        String gtype=request.getParameter("gtype");
        try
        {
            garbageDao.alterGarbage(id,gname,gdesc,gpic,gtype);
            request.getRequestDispatcher("jsp/garbage_list.jsp").forward(request,response);
        }
        catch (Exception e)
        {
            request.getRequestDispatcher("error.jsp").forward(request,response);
            e.printStackTrace();
        }
    }
}
