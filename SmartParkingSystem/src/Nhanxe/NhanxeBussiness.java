package Nhanxe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JOptionPane;

import Xe.Xe;

/**
 * Xử lý nghiệp vụ cho chức năng Quản lý nhận xe
 * @author Đặng Khắc Toàn
 *
 */
public class NhanxeBussiness {
	private GUINhanxe guiNhanxe;
	private DataAccessNhanXe dataAccessNhanxe = new DataAccessNhanXe();
	private String isAddOrEdit = "add";

	/**
	 * Hàm dựng của lớp NhanxeBussiness
	 * @param guiNhanxe đối tượng giao diện Nhận xe
	 */
	public NhanxeBussiness(GUINhanxe guiNhanxe) {
		super();
		this.guiNhanxe = guiNhanxe;
		guiNhanxe.addAction(new action());
	}

	/**
	 * Đặt thời gian vào
	 */
	public void setTime() {
		Calendar calendar = Calendar.getInstance();
		Date startDate = new Date(calendar.getTime().getTime());
		SimpleDateFormat smpdate = new SimpleDateFormat("yyyy-MM-dd");
		String value = smpdate.format(startDate);
		guiNhanxe.getTfTime().setText(value);
	}

	/**
	 * Thêm xe
	 * @param i ID
	 */
	private void add(int i) {
		if (isAddOrEdit == "add")
			setTime();
		String s6 = "";
		if (guiNhanxe.getRdbtnNgay().isSelected())
			s6 = "Vé ngày";
		if (guiNhanxe.getRdbtnThang().isSelected())
			s6 = "Vé tháng";
		if (!s6.equals("")) {
			Xe xe = new Xe(guiNhanxe.getTfMaxe().getText(), guiNhanxe
					.getTfBienso().getText(), guiNhanxe.getCbLoaixe()
					.getSelectedItem().toString(), guiNhanxe.getTfTime()
					.getText(), s6, guiNhanxe.getCbLocation().getSelectedItem()
					.toString(), null, null);
			dataAccessNhanxe.insertData(xe, guiNhanxe.getTfTime().getText(),
					null, "N", i);
			dataAccessNhanxe.loadData(guiNhanxe.getTableNhanxe());
		} else
			JOptionPane
					.showMessageDialog(null, "Thông tin không được bỏ trống");

	}

	/**
	 * Xóa thông tin của xe được chọn
	 */
	private void delete() {
		String sove = (String) guiNhanxe.getTableNhanxe().getValueAt(
				guiNhanxe.getTableNhanxe().getSelectedRow(), 0);
		String bks = (String) guiNhanxe.getTableNhanxe().getValueAt(
				guiNhanxe.getTableNhanxe().getSelectedRow(), 1);
		String vitri = (String) guiNhanxe.getTableNhanxe().getValueAt(
				guiNhanxe.getTableNhanxe().getSelectedRow(), 5);

		dataAccessNhanxe.delete(sove, bks, vitri);
		dataAccessNhanxe.loadData(guiNhanxe.getTableNhanxe());
	}

	/**
	 * Xóa các thông tin đã nhập trên giao diện
	 */
	public void clear() {
		guiNhanxe.getTfMaxe().setText("");
		guiNhanxe.getTfBienso().setText("");
		guiNhanxe.getCbLoaixe().setSelectedItem("Chọn loại xe");
		guiNhanxe.getTfTime().setText("");
		guiNhanxe.getCbLocation().setSelectedIndex(0);
		guiNhanxe.getRdbtnNgay().setSelected(false);
		guiNhanxe.getRdbtnThang().setSelected(false);
		guiNhanxe.getButtonGroup().clearSelection();
		guiNhanxe.getTableNhanxe().clearSelection();
	}

	/**
	 * Hiện tổng số xe
	 */
	private void showTongxe() {
		guiNhanxe.getLbTongxe().setText(
				"Tổng số xe: " + dataAccessNhanxe.TongXe());
	}

	/**
	 * @author Admin
	 * Xử lý sự kiện cho các nút chức năng
	 */
	class action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object ob = e.getActionCommand();
			if (ob.equals("Thêm")) {
				add(0);
				clear();
				showTongxe();
				guiNhanxe.showText(false);
			}
			if (ob.equals("Sửa")) {
				isAddOrEdit = "edit";
				String bks = guiNhanxe.getTfBienso().getText();
				String vitri = guiNhanxe.getCbLocation().getSelectedItem()
						.toString();
				if ((!bks.equals("")) && (!vitri.equals("Chọn vị trí"))) { 
					delete();
					add(Integer.parseInt(guiNhanxe.getTfMaxe().getText()));
					clear();
					showTongxe();

					guiNhanxe.showButton(true, false);
					guiNhanxe.showText(false);
					isAddOrEdit = "add";
				} else {
					JOptionPane.showMessageDialog(null, "Thông tin không được bỏ trống");
					clear();
				}

			}
			if (ob.equals("Xóa")) {
				delete();
				clear();
				showTongxe();
				guiNhanxe.showButton(true, false);
				guiNhanxe.showText(false);
				return;
			}
			if (ob.equals("Hủy")) {
				guiNhanxe.showText(false);
				guiNhanxe.showButton(true, false);
				clear();
			}
			if (ob.equals("Trở lại")) {
				dataAccessNhanxe.loadData(guiNhanxe.getTableNhanxe());
				guiNhanxe.getTfsearch().setText("");
			}
			if (ob.equals("Tìm kiếm")) {
				dataAccessNhanxe.search(guiNhanxe.getTableNhanxe(), guiNhanxe
						.getTfsearch().getText());
			}

		}

	}
}
