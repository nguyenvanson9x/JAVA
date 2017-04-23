package Vethang;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *  Xử lý nghiệp vụ cho phần Quản lý vé tháng
 * @author Phạm Thu Trang
 *
 */
public class BussinessVethang {

	private DataAccess da = new DataAccess();

	/**
	 * Thêm vé tháng
	 * @param cus Đối tượng Vé
	 */
	public void Add(Customer cus) {
		if (cus.getLoaixe().equals("Xe đạp")) {
			if (cus.getTimeStart().equals("") | cus.getTimeEnd().equals("")) {
				JOptionPane.showMessageDialog(null,
						"Thông tin không được bỏ trống");
			} else {
				da.insertCustomer(cus);
			}
		} else if (cus.getBKS().equals("") | cus.getLoaixe().equals("")
				| cus.getTimeStart().equals("") | cus.getTimeEnd().equals("")) {
			JOptionPane
					.showMessageDialog(null, "Thông tin không được bỏ trống");
		} else {
			da.insertCustomer(cus);
		}
	}

	/**
	 * Cập nhật thông tin vé
	 * @param cus Đối tượng vé
	 */
	public void Update(Customer cus) {
			da.updateCustomer(cus);
	}

	/**
	 * Xóa vé được chọn
	 * @param mathe Mã thẻ
	 */
	public void Delete(int mathe) {
		if (mathe > 0)
			da.deleteCustomer(mathe);
	}

	/**
	 * Tìm kiếm thông tin của vé tháng
	 * @param search Giá trị cần tìm
	 * @param tableCus Bảng chứa thông tin vé
	 */
	public void Timkiem(String search, JTable tableCus) {
		String sql = "select * from quanlyvethang";
		String sqlSearch = "select * from quanlyvethang where (BKS like '%"
				+ search + "%') or (Mathe = '" + search + "')";
		if (search.equals("")) {
			da.LoadData(sql, tableCus);
		} else {
			da.LoadData(sqlSearch, tableCus);
		}
	}

	/**
	 * Đặt ảnh cho vé
	 * @param label Đối tượng để hiển thị ảnh
 	 * @param filename Đường dẫn tới tệp ảnh
	 */
	public void setPicture(JLabel label, String filename) {
		try {
			BufferedImage image = ImageIO.read(new File(filename));
			int x = label.getSize().width;
			int y = label.getSize().height;
			int ix;
			try {
				ix = image.getWidth();
				int iy = image.getHeight();
				int dx = 0;
				int dy = 0;
				if (x / y > ix / iy) {
					dy = y;
					dx = dy * ix / iy;
				} else {
					dx = x;
					dy = dx * iy / ix;
				}
				ImageIcon icon = new ImageIcon(image.getScaledInstance(x, y,
						Image.SCALE_SMOOTH));
				label.setIcon(icon);
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Sai định dạng ảnh");
			}
		} catch (IOException e) {

		}
	}
}
