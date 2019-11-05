package servlet;

import user.invitation;
import utils.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "CommentServlet")
public class CommentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        response.getWriter().append("Served at: ").append(request.getContextPath());
        int M_id = (int)request.getSession().getAttribute("M_id");

        String Comment_message = request.getParameter("comment_message");
        Date date = new Date();
        int T_id=Integer.parseInt(request.getParameter("T_id"));
        int U_id =Integer.parseInt(request.getParameter("U_id"));

        List<Object> list = new ArrayList<>();
        list.add(M_id);
        list.add(Comment_message);
        list.add(date);
        list.add(T_id);
        list.add(U_id);

        String sql = "INSERT INTO invitation.message_port VALUE(?,?,?,?,?)";
        boolean flag= false;
        try {
            flag = DBUtil.addUpdateDelete(sql,list.toArray());
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        if(flag)
        {
            response.getWriter().write("<javascript>alert('评论成功')</javascript>");
            response.setCharacterEncoding("UTF-8");
            request.getRequestDispatcher("/jsp/invitation.jsp").forward(request, response);
        }
        else
        {
            response.getWriter().write("<javascript>alert('评论失败')</javascript>");
            response.setCharacterEncoding("UTF-8");
            request.getRequestDispatcher("/jsp/invitation.jsp").forward(request, response);
        }

        /*Connection con;
        PreparedStatement ps;
        ResultSet rs;
        try {
            con = DBUtil.getCon();
            String sql = "INSERT INTO invitation.message_port VALUE(?,?,?,?,?)";
            ps=con.prepareStatement(sql);
            ps.setObject(1,M_id);
            ps.setObject(2,Comment_message);
            ps.setObject(3,date);
            ps.setObject(4,T_id);
            ps.setObject(5,U_id);
            rs=ps.executeQuery();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }*/

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        response.getWriter().append("Served at: ").append(request.getContextPath());
        this.doPost(request,response);
    }
}
