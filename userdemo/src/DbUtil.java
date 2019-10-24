import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DbUtil {

	ResourceBundle bundle = ResourceBundle.getBundle("jdbc");

	private String dbUrl = bundle.getString("dbUrl");
	private String dbUser = bundle.getString("dbUser");
	private String dbPassword = bundle.getString("dbPassword");
	private String driver = "com.mysql.jdbc.Driver";

	private Connection connection = null;

	public Connection getConnection(){
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			System.out.println("数据库连接成功");
		} catch (Exception e) {
			System.out.println("数据库连接失败");
			e.printStackTrace();
		}
		return connection;
	}
	
	public void closeCon(){
		if(connection != null)
			try {
				connection.close();
				System.out.println("数据库已关闭");
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
