package connect.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class connect {

	private final String className = "com.mysql.jdbc.Driver";
	private final String url = "jdbc:mysql://localhost:3306/nguyenvanson";
	private final String user = "admin";
	private final String pass = "heartbreaker96";
	private String table = "thannhan";

	private Connection connection;

	public connect() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUser() {
		return user;
	}

	public String getPass() {
		return pass;
	}

	public void myconnect() {
		try {
			Class.forName(className);
			connection = DriverManager.getConnection(url, user, pass);
			// System.out.println("Connect success!");
		} catch (ClassNotFoundException e) {
			// System.out.println("Class not found");
		} catch (SQLException e) {
			// System.out.println("Error connect!");
		}
	}

	public ResultSet getData() {
		ResultSet rs = null;
		String sql = "select * from " + table;
		Statement st;
		try {
			st = connection.createStatement();
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("error select");
		}
		return rs;
	}

	public ResultSet getDataId(String MaNV) {
		ResultSet rs = null;
		String sql = "select * from " + table + " where MaNV = ?";
		PreparedStatement pst = null;
		try {

			pst = connection.prepareStatement(sql);
			pst.setString(1, MaNV);
			rs = pst.executeQuery();
		} catch (SQLException e) {
			System.out.println("error select");
		}
		return rs;
	}

	public void deleteId(String MaNV) {
		String sql = "delete from " + table + " where MaNV = ?";
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement(sql);
			pst.setString(1, MaNV);
			if (pst.executeUpdate() > 0) {
				System.out.println("Delete success");
			} else
				System.out.println("Delete error");
		} catch (SQLException e) {

		}

	}

	public void showData(ResultSet rs) {

		try {
			while (rs.next()) {
				System.out.printf("%-20s %-20s %-5.2f \n", rs.getString(1), rs.getString(2), rs.getDouble(3));
			}
		} catch (SQLException e) {
		}
	}

}
