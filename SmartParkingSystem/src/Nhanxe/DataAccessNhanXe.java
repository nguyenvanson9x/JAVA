package Nhanxe;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Connect.connect;
import Xe.Convert;
import Xe.Xe;

/**
 * Xử lý các vấn đề liên quan đến cơ sở dữ liệu
 * @author Đặng Khắc Toàn
 *
 */
public class DataAccessNhanXe {
	private connect conn = connect.getInstance();
	public static ResultSet rs = null;
	public PreparedStatement pst = null;
	private String[] titleCol = { "Số vé", "Biển số", "Loại xe", "Loại vé",
			"Thời gian vào", "Vị trí" };

	// show dữ liệu lên table
	/**
	 * Đưa dữ liệu từ database lên bảng
	 * @param table Bảng để hiện thông tin về xe
	 */
	public void loadData(JTable table) {

		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(titleCol);
		String sql = "select nhanxe.Sove, nhanxe.BKS, xe.Loaixe, nhanxe.Loaive, nhanxe.Thoigianvao, nhanxe.Vitri "
				+ "from nhanxe, xe "
				+ "where (nhanxe.Trangthai = 'N') "
				+ "and (nhanxe.BKS = xe.BKS)";

		try {
			pst = conn.getConnection().prepareStatement(sql);
			rs = pst.executeQuery();
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
			pst.close();
			table.setModel(model);

			table.getColumnModel().getColumn(0).setPreferredWidth(50);
			table.getColumnModel().getColumn(1).setPreferredWidth(80);
			table.getColumnModel().getColumn(2).setPreferredWidth(70);
			table.getColumnModel().getColumn(4).setPreferredWidth(90);
			table.getColumnModel().getColumn(5).setPreferredWidth(65);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Can't load data");
		}

	}

	/**
	 * Lấy ra vị trí của xe
	 * @param s Tên vị trí
	 * @return Đối tượng chưa thông tin về vị trí của xe
	 */
	public ResultSet location(String s) {
		String sql = "SELECT Vitri FROM sodo WHERE BKS IS NULL and Vitri like '"
				+ s + "%'";
		Statement st;
		try {
			st = conn.getConnection().createStatement();
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block

		}
		return rs;
	}

	/**
	 * Thêm thông tin xe gửi
	 * @param xe Đối tượng Xe
	 * @param timeIn Thời gian vào
	 * @param timeOut Thời gian ra
	 * @param status Trạng thái (Nhận hoặc Trả)
	 * @param addOrEdit Là Thêm hoặc Sửa
	 */
	public void insertData(Xe xe, String timeIn, String timeOut, String status,
			int addOrEdit) {
		String loaixe_gui = xe.getType();
		String loaixe = Convert.GUI_To_DB(loaixe_gui);
		if (xe.getLiscensePlate().equals("")
				| xe.getLocation().equals("Chọn vị trí") | status.equals("")) {
			JOptionPane
					.showMessageDialog(null, "Thông tin không được bỏ trống");
		} else {

			try {
				String sqlcommand = "select * from xe where BKS = ?";
				pst = conn.getConnection().prepareStatement(sqlcommand);
				pst.setString(1, xe.getLiscensePlate());
				rs = pst.executeQuery();
				if (rs.next()) {
					String sqlcommand2 = "insert into nhanxe values(?,?,?,?,?,?)";
					pst = conn.getConnection().prepareStatement(sqlcommand2);
					pst.setInt(1, addOrEdit);
					pst.setString(2, xe.getLiscensePlate());
					pst.setString(3, xe.getTypeOfTicket());
					pst.setString(4, timeIn);
					pst.setString(5, xe.getLocation());
					pst.setString(6, status);
					pst.executeUpdate();
					pst.close();

					String sqlcommand3 = "update sodo set BKS = ? where Vitri = ?";
					pst = conn.getConnection().prepareStatement(sqlcommand3);
					pst.setString(1, xe.getLiscensePlate());
					pst.setString(2, xe.getLocation());
					pst.executeUpdate();
					pst.close();

					String sqlcommand1 = "update xe set Loaixe = ? where BKS = ?";
					pst = conn.getConnection().prepareStatement(sqlcommand1);
					pst.setString(1, loaixe);
					pst.setString(2, xe.getLiscensePlate());
					pst.executeUpdate();
					pst.close();
				} else {
					String sqlcommand1 = "insert into xe values(?,?)";
					pst = conn.getConnection().prepareStatement(sqlcommand1);
					pst.setString(1, xe.getLiscensePlate());
					pst.setString(2, loaixe);
					pst.executeUpdate();
					pst.close();

					String sqlcommand2 = "insert into nhanxe values(?,?,?,?,?,?)";
					pst = conn.getConnection().prepareStatement(sqlcommand2);
					pst.setInt(1, addOrEdit);
					pst.setString(2, xe.getLiscensePlate());
					pst.setString(3, xe.getTypeOfTicket());
					pst.setString(4, timeIn);
					pst.setString(5, xe.getLocation());
					pst.setString(6, status);
					pst.executeUpdate();
					pst.close();

					String sqlcommand3 = "update sodo set BKS = ? where Vitri = ?";
					pst = conn.getConnection().prepareStatement(sqlcommand3);
					pst.setString(1, xe.getLiscensePlate());
					pst.setString(2, xe.getLocation());
					pst.executeUpdate();
					pst.close();
				}

			} catch (SQLException e) {

			}
		}

	}

	/**
	 * Xóa thông tin của xe
	 * @param sove Số vé
	 * @param bks Biển kiểm soát
	 * @param vt Vị trí
	 */
	public void delete(String sove, String bks, String vt) {

		try {
			String sql1 = "delete from nhanxe where (BKS = ?) and (Sove = ?)";
			pst = conn.getConnection().prepareStatement(sql1);
			pst.setString(1, bks);
			pst.setString(2, sove);
			pst.executeUpdate();
			pst.close();

			String sql3 = "update sodo set BKS = ? where Vitri = ?";
			pst = conn.getConnection().prepareStatement(sql3);
			pst.setString(1, null);
			pst.setString(2, vt);
			pst.executeUpdate();
			pst.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block

		}

	}

	/**
	 * Tìm kiếm thông tin của xe
	 * @param table Bảng chứa thông tin của xe
	 * @param s Giá trị muốn tìm kiếm
	 */
	public void search(JTable table, String s) {
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(titleCol);
		String sqlcommand = "select nhanxe.Sove, nhanxe.BKS, xe.Loaixe, nhanxe.Loaive, nhanxe.Thoigianvao, nhanxe.Vitri from nhanxe, xe where (nhanxe.BKS = xe.BKS) and (nhanxe.Sove like '%"
				+ s
				+ "%' or nhanxe.BKS like '%"
				+ s
				+ "%' or nhanxe.Loaive like '%"
				+ s
				+ "%' or nhanxe.Thoigianvao like '%"
				+ s
				+ "%' or nhanxe.Vitri like '%"
				+ s
				+ "%' or xe.Loaixe like '%"
				+ s + "%') and (nhanxe.Trangthai = 'N')";
		try {
			pst = conn.getConnection().prepareStatement(sqlcommand);
			rs = pst.executeQuery();
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

			pst.close();
			table.setModel(model);

			table.getColumnModel().getColumn(0).setPreferredWidth(50);
			table.getColumnModel().getColumn(1).setPreferredWidth(80);
			table.getColumnModel().getColumn(2).setPreferredWidth(70);
			table.getColumnModel().getColumn(4).setPreferredWidth(90);
			table.getColumnModel().getColumn(5).setPreferredWidth(65);
		} catch (SQLException e) {

		}
	}

	/**
	 * @return Trả lại Tổng số xe
	 */
	public int TongXe() {
		int sum = 0;
		String sql = "select count(*) as 'sum' from nhanxe where nhanxe.Trangthai = 'N'";
		Statement stm;
		try {
			stm = conn.getConnection().createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				sum = rs.getInt("sum");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sum;
	}
}
