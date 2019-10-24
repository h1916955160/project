import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class GarbageDao {

    public void addGarbage(String gname,String gdesc,String gpic,String gtype)
    {
        DbUtil dbUtil = new DbUtil();
        Connection con = dbUtil.getConnection();
        String sql = "INSERT INTO garbage(garbage_name,garbage_content,garbage_picture,garbage_type) VALUES('"  + gname + "','" + gdesc +"','"+ gpic + "','" + gtype + "')";
        try {
            Statement st = con.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteGarbage(int id)
    {
        DbUtil dbUtil = new DbUtil();
        Connection con = dbUtil.getConnection();
        String sql = "DELETE FROM garbage where garbage_id = '"+ id+"'" ;
        try {
            Statement st = con.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void alterGarbage(int gid,String gname,String gdesc,String gpic,String gtype)
    {
        DbUtil dbUtil = new DbUtil();
        Connection con = dbUtil.getConnection();
        String sql = "UPDATE garbage SET garbage_name='"+gname+"',garbage_content='"+gdesc+"',garbage_picture='"+gpic+"',garbage_type='"+gtype+"' where garbage_id='"+gid+"'";
        try {
            Statement st = con.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
