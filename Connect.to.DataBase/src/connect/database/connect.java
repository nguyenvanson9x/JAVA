package connect.database;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.CodeSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class connect {

	private final String className = "com.mysql.jdbc.Driver";
	private final String url = "jdbc:mysql://localhost:3306/csdlcongty";
	private final String user = "admin";
	private final String pass = "heartbreaker96";
	private String table = "nhanvien";

	private Connection connection;

	public connect() {
		super();

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

		} catch (ClassNotFoundException e) {

		} catch (SQLException e) {

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

	public void updateId(Object id, Student st) {
		// TODO Auto-generated method stub
		
	}

	public void insert(Student st) {
		// TODO Auto-generated method stub
		
	}
	public void Backupdbtosql() {
	    try {

	        /*NOTE: Getting path to the Jar file being executed*/
	        /*NOTE: YourImplementingClass-> replace with the class executing the code*/
	        CodeSource codeSource = connect.class.getProtectionDomain().getCodeSource();
	        File jarFile = new File(codeSource.getLocation().toURI().getPath());
	        String jarDir = jarFile.getParentFile().getPath();
	        System.out.println(jarDir);

	        /*NOTE: Creating Database Constraints*/
	        String dbName = "smartparkingsystem";
	        String dbUser = "root";
	        String dbPass = "root";

	        /*NOTE: Creating Path Constraints for folder saving*/
	        /*NOTE: Here the backup folder is created for saving inside it*/
	        String folderPath = jarDir + "\\backup";

	        /*NOTE: Creating Folder if it does not exist*/
	        File f1 = new File(folderPath);
	        f1.mkdir();

	        /*NOTE: Creating Path Constraints for backup saving*/
	        /*NOTE: Here the backup is saved in a folder called backup with the name backup.sql*/
	         String savePath = "\"" + jarDir + "\\backup\\" + "backup.sql\"";

	        /*NOTE: Used to create a cmd command*/
	        String executeCmd = "D:\\SET_UP\\xampp\\mysql\\bin\\mysqldump -u " + dbUser + " -p " + dbPass + " --database " + dbName + " -r " + savePath;

	        /*NOTE: Executing the command here*/
	        Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
	        int processComplete = runtimeProcess.waitFor();

	        /*NOTE: processComplete=0 if correctly executed, will contain other values if not*/
	        if (processComplete == 0) {
	            System.out.println("Backup Complete");
	        } else {
	            System.out.println("Backup Failure");
	        }

	    } catch (URISyntaxException | IOException | InterruptedException ex) {
	        JOptionPane.showMessageDialog(null, "Error at Backuprestore" + ex.getMessage());
	    }
	}
	
	public static void main(String[] args) {
		connect conn = new connect();
		conn.myconnect();
		conn.Backupdbtosql();
	}
	

}
