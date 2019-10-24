import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GarbageDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        GarbageDao garbageDao=new GarbageDao();
        int id=Integer.parseInt(request.getParameter("garbage_id"));
        try
        {
            garbageDao.deleteGarbage(id);
            request.getRequestDispatcher("jsp/garbage_list.jsp").forward(request, response);
        }
        catch (Exception e)
        {
            request.getRequestDispatcher("error.jsp").forward(request, response);
            e.printStackTrace();
        }
    }
}
