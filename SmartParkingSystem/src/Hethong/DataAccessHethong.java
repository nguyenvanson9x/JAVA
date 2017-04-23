package Hethong;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Connect.connect;

/**
 * Xử lý các vấn đề liên quan đến cơ sở dữ liệu
 * @author Nguyễn Văn Sơn
 *
 */
public class DataAccessHethong {
	private connect conn = connect.getInstance();
	private ResultSet rs = null;
	private PreparedStatement pst = null;
	private String[] titleCol = { "ID", "Username", "Password", "Full Name",
			"Type" };

	// show dữ liệu lên table
	/**
	 * Đưa dữ liệu lên bảng trên giao diện
	 * @param sql câu truy vấn sql
	 * @param table bảng để load thông tin
	 */
	public void LoadData(String sql, JTable table) {
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(titleCol);
		try {
			pst = conn.getConnection().prepareStatement(sql);
			rs = pst.executeQuery();
			ResultSetMetaData rsMD = rs.getMetaData();
			int colNumber = rsMD.getColumnCount();

			String[] arr = new String[colNumber];
			while (rs.next()) {
				for (int i = 0; i < colNumber; i++) {
					if (rs.getString(i + 1).equals("Nhan vien"))
						arr[i] = "Nhân viên";
					else if (rs.getString(i + 1).equals("Quan ly"))
						arr[i] = "Quản lý";
					else
						arr[i] = rs.getString(i + 1);
				}
				model.addRow(arr);
			}
			pst.close();

			table.setModel(model);
			table.getColumnModel().getColumn(0).setPreferredWidth(30);
			table.getColumnModel().getColumn(4).setPreferredWidth(60);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Can't load data");
		}

	}

	// thêm người dùng
	/**
	 * Thêm tài khoản
	 * @param u Đối tượng Người dùng
	 */
	public void insertHT(HethongUser u) {
		String user = u.getUsername();
		String pass = u.getPassword();
		String ten = u.getTen();
		String chucvu = u.getChucvu();
		String sqlInsert = String.format(
				"INSERT INTO taikhoan (USERNAME, PASSWORD, TEN, ID, CHUCVU) "
						+ "VALUES ('%s', '%s', '%s', %s, '%s')", user, pass,
				ten, null, chucvu);
		try {
			pst = conn.getConnection().prepareStatement(sqlInsert);
			pst.execute();
			pst.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "USERNAME đã tồn tại");
		}
	}

	// xóa người dùng
	/**
	 * Xóa tài khoản
	 * @param id ID của tài khoản
	 */
	public void deleteHT(int id) {
		String sqlDelete = "delete from taikhoan where ID = ?";
		try {
			pst = conn.getConnection().prepareStatement(sqlDelete);
			pst.setInt(1, id);
			if (id == 1) {
				JOptionPane.showMessageDialog(null,
						"Bạn không thể xóa tài khoản này");
			} else {
				int choose = JOptionPane.showConfirmDialog(null,
						"Bạn muốn xóa tài khoản này ?", "Thông báo", 2);
				if (choose == JOptionPane.YES_OPTION) {
					pst.executeUpdate();
				}
			}
			pst.close();
		} catch (SQLException e) {

		}

	}

	// cập nhật người dùng
	/**
	 * Chỉnh sửa thông tin của Tài khoản
	 * @param u Tài khoản được chọn
	 */
	public void updateHT(HethongUser u) {
		String user = u.getUsername();
		String pass = u.getPassword();
		String ten = u.getTen();
		int id = u.getId();
		String chucvu = u.getChucvu();
		String sqlupdate = "UPDATE taikhoan SET USERNAME = ?, PASSWORD = ?, TEN = ?, CHUCVU = ? WHERE ID = ?";

		try {
			pst = conn.getConnection().prepareStatement(sqlupdate);
			pst.setString(1, user);
			pst.setString(2, pass);
			pst.setString(3, ten);
			pst.setString(4, chucvu);
			pst.setInt(5, id);

			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "USERNAME đã tồn tại");
		}
	}

	// cập nhật giá vé
	/**
	 * Điều chỉnh giá vé
	 * @param loaixe Tên loại xe
	 * @param money  Giá mới
	 * @param type Loại vé ngày hoặc vé tháng
	 */
	public void updateTicket(String loaixe, int money, String type) {
		String sqlupdateTicket = "UPDATE loaixe SET " + type
				+ "= ? WHERE Loaixe = ?";
		try {
			pst = conn.getConnection().prepareStatement(sqlupdateTicket);
			pst.setInt(1, money);
			pst.setString(2, loaixe);
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error");
		}
	}

	// hiển thị giá tiền lên textfield
	/**
	 * Hiện giá vé lên giao diện
	 * @param sql Câu truy vấn SQL
	 * @param a Vé ngày hoặc vé tháng
	 * @param tfMoney Vị trí hiện giá vé
	 */
	public void showMoney(String sql, String a, JTextField tfMoney) {
		try {
			pst = conn.getConnection().prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				String money = rs.getString(a);
				tfMoney.setText(money);

			}
			pst.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Can't load data");
		}
	}

}
