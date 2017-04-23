package Sodo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Connect.connect;

/**
 * Xử lý các vấn đề liên quan đến cơ sở dữ liệu
 * @author Đặng Khắc Toàn
 */
public class DataAccessSodo {
	private connect conn = connect.getInstance();
	private static ResultSet rs = null;
	private Statement st = null;

	/**
	 * Lấy ra vị trí trong bãi đã có xe để
	 * @return Đối tượng chứa thông tin về vị trí của Xe
	 */
	public ResultSet setGara() {
		String sql = "select Vitri from sodo where BKS is not null";
		try {
			st = conn.getConnection().createStatement();
			rs = st.executeQuery(sql);
		} catch (SQLException e) {

		}
		return rs;
	}

	/**
	 * Tìm kiếm vị trí của xe trong bãi
	 * @param s Biển số
	 * @return Đối tượng chưa thông tin về vị trí của Xe
	 */
	public ResultSet search(String s) {
		String sql = "select Vitri from sodo where BKS like '" + s + "'";
		try {
			st = conn.getConnection().createStatement();
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
		}
		return rs;
	}

	/**
	 * Hiện thị thông tin chi tiết của xe ở trong bãi
	 * @param vitri Vị trí của xe
	 */
	public void viewInfo(String vitri) {
		String sql = "select nhanxe.Sove, nhanxe.BKS, xe.Loaixe, nhanxe.Loaive, nhanxe.Thoigianvao, nhanxe.Vitri "
				+ "from nhanxe, xe, sodo "
				+ "where (nhanxe.Trangthai = 'N') "
				+ "and (nhanxe.BKS = xe.BKS) and (nhanxe.BKS = sodo.BKS) and (sodo.Vitri like '"
				+ vitri + "')";
		try {
			st = conn.getConnection().createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				JOptionPane.showMessageDialog(
						null,
						"Số vé: " + rs.getString("nhanxe.Sove") + "\n"
								+ "BKS: " + rs.getString("nhanxe.BKS") + "\n"
								+ "Loại vé: " + rs.getString("nhanxe.Loaive")
								+ "\n" + "Loại xe: "
								+ rs.getString("xe.Loaixe") + "\n"
								+ "Thời gian vào: "
								+ rs.getString("nhanxe.Thoigianvao"),
						"Infomation", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (SQLException e) {

		}

	}
}
