import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class NewsDao {
    public void addNews(String title,String text,String pic,String time,String author)
    {
        DbUtil dbUtil = new DbUtil();
        Connection con = dbUtil.getConnection();
        String sql = "INSERT INTO news(news_title,news_text,news_picture,news_time,news_author) VALUES('"  + title + "','" + text +"','"+ pic + "','" + time +"','" + author + "')";
        try {
            Statement st = con.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteNews(int id)
    {
        DbUtil dbUtil = new DbUtil();
        Connection con = dbUtil.getConnection();
        String sql = "DELETE FROM news where news_id = '"+ id+"'" ;
        try {
            Statement st = con.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void alterNews(int nid,String title,String text,String pic,String time,String author)
    {
        DbUtil dbUtil = new DbUtil();
        Connection con = dbUtil.getConnection();
        String sql = "UPDATE news SET news_title='"+title+"',news_text='"+text+"',news_picture='"+pic+"',news_time='"+time+"',news_author='"+author+"' where news_id='"+nid+"'";
        try {
            Statement st = con.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
