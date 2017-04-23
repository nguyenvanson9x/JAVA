package Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 * Tạo đối tượng để kết nối Java với Database
 * @author Nguyễn Văn Sơn
 *
 */
public class connect {

	private static final String className = "com.mysql.jdbc.Driver";
	private static String host, port, db_name, user, pass;
	private static Connection connection = null;
	private static connect instance = null;

	/**
	 * Tạo ra đối tượng kiểu Connection
	 */
	private connect() {

		String url = "jdbc:mysql://" + host + ":" + port + "/" + db_name
				+ "?useUnicode=true&characterEcoding=utf-8";
		try {
			Class.forName(className);
			connection = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Miss Library");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error connect");
		}
	}

	/**
	 * Lấy ra thể hiện của đối tượng connect
	 * @return Trả lại thể hiện của đối tượng connect
	 */
	public static connect getInstance() {

		try {
			if (instance == null || instance.getConnection().isClosed()) {

				instance = new connect();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return instance;
	}

	/**
	 * Kiểm tra xem kết nối có thành công hay không
	 * @return Trả lại giá trị True/False để kiểm tra xem đối tượng kiểu Connection có được tạo không
	 */
	public static boolean checkConnect() {
		String url = "jdbc:mysql://" + host + ":" + port + "/" + db_name
				+ "?useUnicode=true&characterEcoding=utf-8";
		try {
			Class.forName(className);
			connection = DriverManager.getConnection(url, user, pass);
			return true;
		} catch (ClassNotFoundException | SQLException e) {
			return false;
		}

	}

	/**
	 * Đặt giá trị cho biến user
	 * @param user Tên đăng nhập vào database
	 */
	public static void setUser(String user) {
		connect.user = user;
	}

	/**
	 * Đặt giá trị cho biến pass
	 * @param pass Mật khẩu đăng nhập vào database
	 */
	public static void setPass(String pass) {
		connect.pass = pass;
	}

	/**
	 * Đặt giá trị cho biến host
	 * @param host Tên máy chủ kết nối của database
	 */
	public static void setHost(String host) {
		connect.host = host;
	}

	/**
	 * Đặt giá trị cho biến port
	 * @param port Cổng kết nối vào database
	 */
	public static void setPort(String port) {
		connect.port = port;
	}

	/**
	 * Đặt giá trị cho biến db_name
	 * @param db_name Tên của database
	 */
	public static void setDbName(String db_name) {
		connect.db_name = db_name;
	}

	/**
	 *  Lấy ra đối tượng để kết nối vào database
	 * @return Trả về đối tượng kiểu Connection
	 */
	public Connection getConnection() {
		return connection;
	}
}
