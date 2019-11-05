package dao;
import user.Message_port;
import user.invitation;
import user.user_reg;
import user.garbage;
import utils.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class UserDaoImpl implements UserDao {
    @Override
    public user_reg login(user_reg user) {

        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        try {
            con=DBUtil.user_getCon();//1:获取数据库的连接
            //2:书写sql语句
            String sql="select * from user where user_id=? and user_pwd=? ";
            ps=con.prepareStatement(sql);//3：预编译
            //4：设置值
            ps.setString(1, String.valueOf(user.getAcount()));
            ps.setString(2, String.valueOf(user.getPassward()));
            rs=ps.executeQuery();//5:执行sql语句
            user_reg users;
            if(rs.next()){
                users=new user_reg();
                //从数据库中获取值设置到实体类的setter方法中
                users.setAcount(rs.getInt("user_id"));
                users.setPassward(rs.getInt("user_pwd"));
                users.setName(rs.getString("user_na"));
                users.setSex(rs.getString("user_xb"));
                users.setAddr(rs.getString("user_addr"));
                users.setEmail(rs.getString("user_em"));

                return users;
            }else{
                return null;
            }

        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public boolean register(user_reg user) throws SQLException, ClassNotFoundException {

        String sql="insert into user values(?,?,?,?,?,?)";
        List<Object> list=new ArrayList<Object>();
        list.add(user.getAcount());
        list.add(user.getPassward());
        list.add(user.getName());
        list.add(user.getSex());
        list.add(user.getAddr());
        list.add(user.getEmail());

        boolean flag= DBUtil.addUpdateDelete(sql,list.toArray());
        if(flag)
        {
            return true;
        }
        else
        {
            return false;
        }

    }
    @Override
    public boolean update(user_reg user1,user_reg user2) throws SQLException, ClassNotFoundException{
        String sql ="UPDATE user SET user_pwd=?, user_em=?,user_addr=? WHERE user_pwd=? AND user_em=?";
        List<Object> list=new ArrayList<Object>();
        list.add(user2.getPassward());
        list.add(user2.getEmail());
        list.add(user2.getAddr());
        list.add(user1.getPassward());
        list.add(user1.getEmail());

        boolean flag= DBUtil.addUpdateDelete(sql,list.toArray());
        if(flag)
        {
            return true;
        }
        else
        {
            return false;
        }

    }
    @Override
    public List<garbage> search(String user_addr)
    {

        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        try {
            con=DBUtil.getCon();//1:获取数据库的连接
            //2:书写sql语句
            String ss=user_addr;
            String sql="SELECT * FROM db_garbage_system.garbage WHERE garbage_name LIKE '%"+ss+"%'";
            ps=con.prepareStatement(sql);

            rs=ps.executeQuery();//5:执行sql语句
            List<garbage> list = new ArrayList<garbage>();
            //List user_list =new ArrayList();
            garbage gbg;

            while(rs.next()){
                gbg=new garbage();
                //从数据库中获取值设置到实体类的setter方法中
                //users.setAcount(rs.getInt("user_id"));
                gbg.setGarbage_id(rs.getInt("garbage_id"));
                gbg.setGarbage_name(rs.getString("garbage_name"));
                gbg.setGarbage_content(rs.getString("garbage_content"));
                gbg.setGarbage_type(rs.getString("garbage_type"));
                //user_list.add(users);
                list.add(gbg);
            }
            if (rs.next())
            {
                return null;
            }
            return list;
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<invitation> post_invitation(int user_id)
    {
        ArrayList<invitation> invitationArrayList = new ArrayList<>();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        try {
            //链接数据库
            con = DBUtil.getCon();
            //MySQL语句
            String sql = "SELECT * FROM invitation.post_t where user_id != ? order by invitation.post_t.T_time desc  ";

            ps=con.prepareStatement(sql);//预编译
            ps.setObject(1,user_id);
            rs=ps.executeQuery();//执行

            invitation inv ;

            while(rs.next())
            {
                inv = new invitation();
                inv.setUser_id(rs.getInt("user_id"));
                inv.setPost_topic(rs.getString("T_topic"));
                inv.setPost_content(rs.getString("T_content"));
                inv.setPost_time(rs.getString("T_time"));
                inv.setPost_id(rs.getInt("T_id"));

                invitationArrayList.add(inv);

            }
            if(rs.next())
            {
                return null;
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return invitationArrayList;
    }

    public ArrayList<Message_port> port_Message(int t_id,int u_id)
    {
        ArrayList<Message_port> message_list= new ArrayList<>();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        try {
            //链接数据库
            con = DBUtil.getCon();
            //MySQL语句
            String sql = "SELECT * FROM invitation.message_port WHERE T_id = ? and U_id =? order by invitation.message_port.M_time  ";
            ps=con.prepareStatement(sql);//预编译
            ps.setObject(1,t_id);
            ps.setObject(2,u_id);
            rs=ps.executeQuery();//执行语句

            Message_port msg ;

            while(rs.next())
            {
                msg = new Message_port();
                msg.setMessage_port_id(rs.getInt("M_id"));
                msg.setMessage_content(rs.getString("M_content"));
                msg.setMessage_time(rs.getString("M_time"));
                msg.setUser_id(rs.getInt("U_id"));
                msg.setPost_id(rs.getInt("T_id"));
                message_list.add(msg);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return message_list;
    }
}
