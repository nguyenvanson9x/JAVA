package Traxe;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Connect.connect;
import Xe.Xe;

/**
 * Xử lý các vấn đề liên quan đến cơ sở dữ liệu
 * @author Nguyễn Duy Vũ
 * 
 */
public class DataAccessTraXe {
	private connect con = connect.getInstance();
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	private String[] titleCol = { "Số vé", "Biển số", "Loại xe", "Loại vé",
			"Thời gian vào", "Vị trí" };

	// hiển thị dữ liệu lên table
	/**
	 * Đưa dữ liệu từ database lên bảng
	 * @param sql Câu truy vấn SQL
	 * @return Trả về đối tượng DefaultTableModel
	 */
	public DefaultTableModel loadData(String sql) {
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(titleCol);
		rs = getData(sql);
		try {
			ResultSetMetaData rsMD = rs.getMetaData();
			int colNumber = rsMD.getColumnCount();

			String[] arr = new String[colNumber];
			while (rs.next()) {
				for (int i = 0; i < colNumber; i++) {
					if (rs.getString(i + 1).equals("Xe dap"))
						arr[i] = "Xe đạp";
					else if (rs.getString(i + 1).equals("Xe may"))
						arr[i] = "Xe máy";
					else if (rs.getString(i + 1).equals("Xe o to"))
						arr[i] = "Xe ô tô";
					else
						arr[i] = rs.getString(i + 1);
				}
				model.addRow(arr);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return model;
	}

	/**
	 * Lấy dữ liệu từ cơ sở dữ liệu
	 * @param sql Câu truy vấn SQL
	 * @return Trả về đối tượng chứa thông tin 
	 */
	public ResultSet getData(String sql) {

		Statement stmt;

		try {
			stmt = con.getConnection().createStatement();

			rs = stmt.executeQuery(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;

	}

	/**
	 * Đưa trạng thái của xe trong database về T
	 * @param id Số vé
	 * @param table Bảng trong cơ sở dữ liệu
	 * @param trangthai T/N
	 */
	public void updatePaycar(String id, String table, String trangthai) {

		String sqlcommand = "update " + table
				+ " set Trangthai = ? where Sove = ?";

		try {
			pst = con.getConnection().prepareStatement(sqlcommand);
			pst.setString(1, trangthai);
			pst.setInt(2, Integer.parseInt(id));
			pst.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "SQL err");
		}
	}

	/**
	 * Đưa giá trị của BKS trong database về null
	 * @param table Bảng trong cơ sở dữ liệu
	 * @param vitri Vị trí
	 */
	public void updateLocation(String table, String vitri) {

		String sqlcommand = "update " + table + " set BKS = ? where Vitri= ?";

		try {
			pst = con.getConnection().prepareStatement(sqlcommand);
			pst.setString(1, null);
			pst.setString(2, vitri);
			
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "SQL err");
		}

	}

	/**
	 * Thiết lập giá vé 
	 * @param xe Đối tượng xe
	 * @param tab Bảng trong cơ sở dữ liệu
	 */
	public void insertPaycar(Xe xe, String tab) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate fomatTimeOut = LocalDate.parse(xe.getTimeOut(), formatter);
		java.sql.Date timeOut = java.sql.Date.valueOf(fomatTimeOut);
		String sqlCommand = "insert into " + tab + " value( ?, ?, ?)";

		try {
			pst = con.getConnection().prepareStatement(sqlCommand);

			pst.setInt(1, Integer.parseInt(xe.getId()));
			pst.setDate(2, timeOut);
			pst.setInt(3, Integer.parseInt(xe.getMoney()));
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "SQL err");
		}
	}

	/**
	 * @return Trả về tổng số xe
	 */
	public int TongXe() {
		int sum = 0;
		String sql = "select count(*) as 'sum' from nhanxe where nhanxe.Trangthai = 'N'";
		Statement stm;

		try {
			stm = con.getConnection().createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				sum = rs.getInt("sum");
			}
			//rs.close();
			stm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sum;
	}

}
