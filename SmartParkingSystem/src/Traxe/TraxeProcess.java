package Traxe;


import javax.swing.JTable;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import Xe.Xe;

/**
 * Xử lý nghiệp vụ cho chức năng Trả xe
 * @author Nguyễn Duy Vũ
 * 
 */
public class TraxeProcess {

	private DataAccessTraXe conn = new DataAccessTraXe();


	// dùng để insert dữ liệu vào bảng và set lại trạng thái ở bảng nhận xe
	/**
	 * Trả xe
	 * @param table Bảng chứa thông tin xe
	 * @param id Số vé
	 * @param bks Biển kiểm soát
	 * @param loaixe Loại xe
	 * @param loaive Loại vé 
	 * @param timein Thời gian vào
	 * @param timeout Thời gian ra 
	 * @param vitri Vị trí
	 * @param money Giá vé
	 */
	public void traxe(JTable table, String id, String bks, String loaixe, String loaive, String timein, String timeout,
			String vitri, String money) {
		
			Xe xe = new Xe(id, null, null, null, null, null, timeout, money);
			conn.insertPaycar(xe, "traxe");
			conn.updatePaycar(id,  "nhanxe", "T");
			conn.updateLocation("sodo", vitri);
		table.setModel(conn.loadData(
				"SELECT nhanxe.Sove, nhanxe.BKS, xe.Loaixe, nhanxe.Loaive, nhanxe.Thoigianvao, nhanxe.Vitri FROM nhanxe, xe WHERE (nhanxe.Trangthai = 'N') and (nhanxe.BKS = xe.BKS)"));
	}

	/**
	 * Tìm kiếm thông tin xe
	 * @param table Bảng chứa thông tin xe
	 * @param search Giá trị cần tìm
	 */
	public void search(JTable table, String search) {
		String sql = "SELECT nhanxe.Sove, nhanxe.BKS, xe.Loaixe, nhanxe.Loaive, nhanxe.Thoigianvao, nhanxe.Vitri FROM nhanxe,xe WHERE (nhanxe.Trangthai = 'N') and (nhanxe.BKS = xe.BKS) GROUP BY nhanxe.Sove, nhanxe.BKS, xe.Loaixe, nhanxe.Loaive, nhanxe.Thoigianvao, nhanxe.Vitri HAVING  (nhanxe.Sove like '%"
				+ search + "%') or (nhanxe.BKS like '%" + search + "%')  or (nhanxe.Thoigianvao like '%" + search
				+ "%' )or (xe.Loaixe like '%" + search + "%') or (nhanxe.ViTri like '%" + search
				+ "%') or (nhanxe.Loaive like '%" + search + "%')";
		table.setModel(conn.loadData(sql));

	}

	/**
	 * Hiện lại danh sách xe
	 * @param table Bảng chứa thông tin về xe
	 * @param tfText Dữ liệu cần tìm
	 */
	public void home(JTable table, JTextField tfText) {
		tfText.setText("");
		table.setModel(conn.loadData(
				"select nhanxe.Sove, nhanxe.BKS, xe.Loaixe, nhanxe.Loaive, nhanxe.Thoigianvao, nhanxe.Vitri from nhanxe, xe where (nhanxe.Trangthai = 'N') and (nhanxe.BKS = xe.BKS)"));
	}

	/**
	 * Hủy tác vụ
	 * @param table Bảng chứa thông tin xe
	 * @param tfMaxe Số vé
	 * @param tfMoney Giá vé
	 * @param tfBienso Biển kiểm soát
	 * @param tfLoaixe Loại xe
	 * @param tfTimeIn Thời gian vào
	 * @param tfLoaiVe Loại vé
	 * @param tfVitri Vị trí
	 * @param TimeOut Thời gian ra
	 */
	public void huy(JTable table, JTextField tfMaxe, JTextField tfMoney, JTextField tfBienso, JTextField tfLoaixe,
			JTextField tfTimeIn, JTextField tfLoaiVe, JTextField tfVitri, JDateChooser TimeOut) {
		tfMaxe.setText("");
		tfMoney.setText("");
		tfBienso.setText("");
		tfLoaixe.setText("");
		tfTimeIn.setText("");
		tfLoaiVe.setText("");
		tfVitri.setText("");
		TimeOut.setDate(null);
		table.setModel(conn.loadData(
				"select nhanxe.Sove, nhanxe.BKS, xe.Loaixe, nhanxe.Loaive, nhanxe.Thoigianvao, nhanxe.Vitri from nhanxe, xe where (nhanxe.Trangthai = 'N') and (nhanxe.BKS = xe.BKS)"));
	}
}
