package Hethong;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Xe.Convert;

/**
 * Xử lý nghiệp vụ cho phần Hệ thống
 * @author Nguyễn Văn Sơn
 *
 */
public class BussinessHethong {
	private DataAccessHethong process;

	/**
	 * Hàm dựng của lớp BussinessHethong
	 */
	public BussinessHethong() {
		process = new DataAccessHethong();
	}

	/**
	 * Thay đổi giá vé
	 * @param cbLoaixe Chọn loại xe
	 * @param cbLoaive Chọn loại vé
	 * @param tfGiadieuchinh Giá mới 
	 * @param tfGiahientai Giá cũ
	 */
	@SuppressWarnings("rawtypes")
	public void Thaydoi(JComboBox cbLoaixe,JComboBox cbLoaive, JTextField tfGiadieuchinh, JTextField tfGiahientai) {
		String loaixe_GUI = cbLoaixe.getSelectedItem().toString();
		String loaixe = Convert.GUI_To_DB(loaixe_GUI);
		String loaive = cbLoaive.getSelectedItem().toString();
		if (loaixe.equals("Chọn loại xe")) {
			JOptionPane.showMessageDialog(null, "Hãy chọn một loại xe");
		} else {
			int money;
			try {
				if (tfGiadieuchinh.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Bạn chưa nhập giá mới");
				} else if (Integer.parseInt(tfGiadieuchinh.getText()) > 0) {

					money = Integer.parseInt(tfGiadieuchinh.getText());
					if(loaive.equals("Vé ngày"))
						process.updateTicket(loaixe, money,"Tien");
					else
						process.updateTicket(loaixe, money,"Tien_Vethang");
					String temp = tfGiadieuchinh.getText();
					tfGiadieuchinh.setText("");
					tfGiahientai.setText(temp);
				} else {
					JOptionPane.showMessageDialog(null, "Giá tiền không hợp lệ");
					tfGiadieuchinh.setText("");
				}
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "Chỉ được nhập số");
				tfGiadieuchinh.setText("");
			}
		}
	}

	/**
	 * Thêm tài khoản vào hệ thống
	 * @param user đối tượng Người dùng
	 */
	public void Them(HethongUser user) {

		if (user.getUsername().equals("") | user.getPassword().equals("") | user.getTen().equals("")) {
			JOptionPane.showMessageDialog(null, "Thông tin không được bỏ trống");
		} else {
			process.insertHT(user);
		}
	}

	/**
	 * Cập nhật thông tin tài khoản
	 * @param user đối tượng Người dùng
	 */
	public void Capnhat(HethongUser user) {
		int id = user.getId();
		if (id > 0 && id != 1) {
			process.updateHT(user);
		}
	}

	/**
	 * Xóa bỏ tài khoản có mã là id
	 * @param id ID của tài khoản
	 */
	public void Xoa(int id) {
		if (id > 0)
			process.deleteHT(id);
	}

	/**
	 * Tìm kiếm thông tin tài khoản
	 * @param search Giá trị cần tìm
	 * @param tableUser Bảng chứa thông tin tài khoản
	 */
	public void Timkiem(String search, JTable tableUser) {
		String sql = "select * from TAIKHOAN";
		String sqlSearch = "select * from taikhoan where USERNAME = '" + search + "'";
		if (search.equals("")) {
			process.LoadData(sql, tableUser);
		} else {
			process.LoadData(sqlSearch, tableUser);
		}
	}

	/**
	 * Hiện giá vé lên giao diện
	 * @param Loaixe Tên loại xe
	 * @param Loaive Tên loại vé
	 * @param tfGiahientai Giá hiện tại
	 */
	public void showTicket(String Loaixe, String Loaive, JTextField tfGiahientai) {
		String sqlMoney = "select loaixe.Tien,loaixe.Tien_Vethang from loaixe where loaixe.Loaixe = '" + Loaixe + "'";
		if (Loaive.equals("Vé ngày")) {
			process.showMoney(sqlMoney, "Tien", tfGiahientai);
		} else
			process.showMoney(sqlMoney, "Tien_Vethang", tfGiahientai);

	}
}
