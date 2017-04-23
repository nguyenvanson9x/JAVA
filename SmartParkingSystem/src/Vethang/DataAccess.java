package Vethang;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Connect.connect;
import Xe.Convert;

import com.toedter.calendar.JDateChooser;

/**
 * Xử lý các vấn đề liên quan đến cơ sở dữ liệu
 * @author Phạm Thu Trang
 * 
 */
public class DataAccess {
	private connect conn = connect.getInstance();
	private ResultSet rs = null;
	private PreparedStatement pstt = null;
	private String[] titleCol = { "Mã thẻ", "Biển số", "Loại xe",
			"Ngày bắt đầu", "Ngày kết thúc", "Tiền" };

	/**
	 * Hàm dựng của lớp DataAccess
	 */
	public DataAccess() {
	}

	/**
	 * Đưa dữ liêu từ database lên bảng
	 * @param sql Câu truy vấn SQL
	 * @param table Bảng chứa dữ liệu
	 */
	public void LoadData(String sql, JTable table) {
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(titleCol);
		try {
			pstt = conn.getConnection().prepareStatement(sql);
			rs = pstt.executeQuery();
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
			pstt.close();
			table.setModel(model);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Can't load data");
		}

	}

	/**
	 * Thêm vé tháng
	 * @param cus Đối tượng Vé
	 */
	public void insertCustomer(Customer cus) {
		String Loaixe_Gui = cus.getLoaixe();
		String loaixe = Convert.GUI_To_DB(Loaixe_Gui);
		String sqlInsert = "INSERT INTO quanlyvethang( BKS, Loaixe, Ngaybatdau, Ngayketthuc, Tien,Photo) "
				+ "VALUES (?, ?, ?, ?, ?,?)";

		try {
			pstt = conn.getConnection().prepareStatement(sqlInsert);

			pstt.setString(1, cus.getBKS());
			pstt.setString(2, loaixe);
			pstt.setString(3, cus.getTimeStart());
			pstt.setString(4, cus.getTimeEnd());
			pstt.setInt(5, cus.getGiave());
			pstt.setString(6, cus.getPhoto());
			pstt.execute();
			pstt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Xóa vé được chọn
	 * @param mathe Mã thẻ 
	 */
	public void deleteCustomer(int mathe) {
		String sqlDelete = "delete from quanlyvethang where Mathe =  ?";
		PreparedStatement pstt = null;
		try {
			pstt = conn.getConnection().prepareStatement(sqlDelete);
			pstt.setInt(1, mathe);

			int choose = JOptionPane.showConfirmDialog(null,
					"Bạn muốn xóa thông tin này ?", "Thông báo", 2);
			if (choose == JOptionPane.YES_OPTION) {
				pstt.executeUpdate();
			}
			pstt.close();
		} catch (SQLException e) {

		}

	}

	/**
	 * Chỉnh sửa thông tin vé
	 * @param cus Đối tượng vé
	 */
	public void updateCustomer(Customer cus) {
		String loaixe = Convert.GUI_To_DB(cus.getLoaixe());
		String sqlupdate = "UPDATE quanlyvethang SET BKS = ?, Loaixe = ?, Ngaybatdau = ?, Ngayketthuc = ?, Tien = ? ,Photo =? WHERE Mathe = ?";
		try {

			pstt = conn.getConnection().prepareStatement(sqlupdate);

			pstt.setString(1, cus.getBKS());
			pstt.setString(2, loaixe);
			pstt.setString(3, cus.getTimeStart());
			pstt.setString(4, cus.getTimeEnd());
			pstt.setInt(5, cus.getGiave());
			pstt.setString(6, cus.getPhoto());
			pstt.setInt(7, cus.getMathe());
			pstt.executeUpdate();

			pstt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Hiển thị thời gian lên giao diện
	 * @param dateChooser Thời gian
	 * @param dateInput Thời gian
	 */
	public void inputDate(JDateChooser dateChooser, String dateInput) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = formatter.parse(dateInput);
			dateChooser.setDate(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Lấy giá vé từ cơ sở dữ liệu
	 * @param type Loại xe
	 * @return Trả về giá vé
	 */
	public int getMoney(String type) {
		String loaixe = Convert.GUI_To_DB(type);
		int money = 0;
		String sql = "select loaixe.Tien_Vethang from loaixe where loaixe.Loaixe = ?";
		try {
			pstt = conn.getConnection().prepareStatement(sql);
			pstt.setString(1, loaixe);
			rs = pstt.executeQuery();

			while (rs.next()) {
				money = rs.getInt("Tien_Vethang");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return money;
	}

	/**
	 * Lấy ra đường dẫn của tệp Ảnh
	 * @param Mathe Mã thẻ
	 * @return Trả về đương dẫn của tệp Ảnh
	 */
	public String getPath(String Mathe) {
		String path = null;
		String sql = "select quanlyvethang.Photo from quanlyvethang where Mathe = "
				+ Mathe;
		Statement stm = null;
		try {
			stm = conn.getConnection().createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				path = rs.getString("Photo");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
}
