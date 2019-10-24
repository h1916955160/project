import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {
    public void deleteUser(int id)
    {
        DbUtil dbUtil = new DbUtil();
        Connection con = dbUtil.getConnection();
        String sql = "DELETE FROM users where user_id = '"+ id+"'" ;
        try {
            Statement st = con.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addUser()
    {

    }
}
