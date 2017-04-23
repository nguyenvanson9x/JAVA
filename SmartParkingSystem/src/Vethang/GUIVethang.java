package Vethang;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import Hethong.GUIHethong;

import com.toedter.calendar.JDateChooser;

/**
 * Giao diện của chức năng Quản lý vé tháng
 * @author Phạm Thu Trang
 * 
 */
public class GUIVethang extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private final String sql = "select * from quanlyvethang";

	private JTable table;
	private JTextField tfMathe, tfBienxe, tfSearch, tfTien;
	private JDateChooser dateStart, dateEnd;
	@SuppressWarnings("rawtypes")
	private JComboBox cbLoaixe;
	private JButton btnHuy, btnThem, btnSua, btnXoa, btnTim, btnPhoto;
	private Date ngaybd, ngaykt;
	private JLabel lbPhoto, lbMathe, lblGia, lbDateEnd;

	private File file;
	private int giave;
	private String bks, loaixe, ngaybatdau, ngayketthuc, photoPath;

	private DataAccess da = new DataAccess();
	private BussinessVethang bus = new BussinessVethang();

	/**
	 * Hiển thị thông tin vé lên bảng
	 */
	private void showdata() {
		da.LoadData(sql, table);
	}

	/**
	 * Hàm dựng của lớp GUIVethang
	 */
	public GUIVethang() {

		setTitle("Quản lý hệ thống");
		setFrameIcon(new ImageIcon(
				GUIHethong.class.getResource("/Image/settings.png")));
		
		init();
		showdata();
		showButtonUser(true, false);
		tfMathe.setEditable(false);
	}

	/**
	 * Thêm các thành phần của giao diện
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void init() {
		setTitle("Quản lý vé tháng");
		setFrameIcon(new ImageIcon(
				GUIVethang.class.getResource("/Image/script.png")));
		setBounds(0, 0, 1052, 618);

		JPanel pnTitle = new JPanel();
		pnTitle.setBorder(new EmptyBorder(20, 0, 20, 0));
		getContentPane().add(pnTitle, BorderLayout.NORTH);

		JLabel lbTitle = new JLabel("Quản Lý Vé Tháng");
		lbTitle.setForeground(Color.RED);
		lbTitle.setFont(new Font("Tahoma", Font.BOLD, 26));
		pnTitle.add(lbTitle);

		JPanel pnCenter = new JPanel();
		pnCenter.setBorder(new MatteBorder(1, 0, 0, 0, (Color) Color.RED));
		getContentPane().add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(null);

		JPanel pnDanhmuc = new JPanel();
		pnDanhmuc.setBounds(10, 11, 1028, 204);
		pnDanhmuc.setBorder(new TitledBorder(null, "Danh m\u1EE5c th\u1EBB",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnCenter.add(pnDanhmuc);
		pnDanhmuc.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();

		pnDanhmuc.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setFillsViewportHeight(true);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mouseClick();

			}
		});
		scrollPane.setViewportView(table);

		JPanel pnSearch = new JPanel();
		pnSearch.setBorder(new EmptyBorder(0, 0, 0, 15));
		FlowLayout flowLayout = (FlowLayout) pnSearch.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		pnDanhmuc.add(pnSearch, BorderLayout.NORTH);

		tfSearch = new JTextField();
		pnSearch.add(tfSearch);
		tfSearch.setColumns(30);

		btnTim = new JButton("Tìm kiếm");
		btnTim.setIcon(new ImageIcon(GUIVethang.class
				.getResource("/Image/search1.png")));
		btnTim.setHorizontalAlignment(SwingConstants.LEFT);
		pnSearch.add(btnTim);

		JPanel pnInfor = new JPanel();
		pnInfor.setBounds(10, 226, 1028, 269);
		pnInfor.setBorder(new TitledBorder(null, "Th\u00F4ng tin th\u1EBB",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnCenter.add(pnInfor);
		pnInfor.setLayout(null);

		JPanel pnInput = new JPanel();
		pnInput.setBounds(206, 15, 636, 234);
		pnInput.setBorder(new MatteBorder(10, 5, 20, 5, (Color) null));
		pnInfor.add(pnInput);
		pnInput.setLayout(null);

		lbMathe = new JLabel("Mã thẻ");
		lbMathe.setBounds(46, 0, 147, 25);
		lbMathe.setFont(new Font("Tahoma", Font.BOLD, 11));

		pnInput.add(lbMathe);

		tfMathe = new JTextField();
		tfMathe.setBounds(193, 0, 147, 22);
		pnInput.add(tfMathe);
		tfMathe.setColumns(10);

		JLabel lbBienxe = new JLabel("Biển xe");
		lbBienxe.setBounds(46, 72, 147, 25);
		lbBienxe.setFont(new Font("Tahoma", Font.BOLD, 11));
		pnInput.add(lbBienxe);

		tfBienxe = new JTextField();
		tfBienxe.setBounds(193, 72, 147, 22);
		pnInput.add(tfBienxe);
		tfBienxe.setColumns(10);

		JLabel lbLoaixe = new JLabel("Loại xe");
		lbLoaixe.setBounds(46, 36, 147, 25);
		lbLoaixe.setFont(new Font("Tahoma", Font.BOLD, 11));
		pnInput.add(lbLoaixe);

		cbLoaixe = new JComboBox();
		cbLoaixe.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cbLoaixe.setBounds(193, 36, 147, 22);
		cbLoaixe.setModel(new DefaultComboBoxModel(new String[] {
				"Chọn loại xe", "Xe đạp", "Xe máy", "Xe ô tô" }));
		pnInput.add(cbLoaixe);

		JLabel lbDateStart = new JLabel("Ngày bắt đầu");
		lbDateStart.setBounds(46, 108, 147, 25);
		lbDateStart.setFont(new Font("Tahoma", Font.BOLD, 11));
		pnInput.add(lbDateStart);

		dateStart = new JDateChooser();
		dateStart.setDateFormatString("yyyy-MM-dd");
		dateStart.setBounds(193, 108, 147, 22);
		pnInput.add(dateStart);

		lbDateEnd = new JLabel("Ngày kết thúc");
		lbDateEnd.setBounds(46, 144, 147, 25);
		lbDateEnd.setFont(new Font("Tahoma", Font.BOLD, 11));
		pnInput.add(lbDateEnd);

		dateEnd = new JDateChooser();
		dateEnd.setDateFormatString("yyyy-MM-dd");
		dateEnd.setBounds(193, 144, 147, 22);
		pnInput.add(dateEnd);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(5, 0, 0, 0));
		panel_1.setBounds(0, 201, 351, 33);
		pnInput.add(panel_1);

		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon(GUIVethang.class
				.getResource("/Image/add1.png")));
		panel_1.add(btnThem);

		btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon(GUIVethang.class
				.getResource("/Image/sua.png")));
		panel_1.add(btnSua);

		btnHuy = new JButton("Hủy");
		btnHuy.setIcon(new ImageIcon(GUIVethang.class
				.getResource("/Image/close.png")));
		panel_1.add(btnHuy);

		btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon(GUIVethang.class
				.getResource("/Image/del.png")));
		panel_1.add(btnXoa);

		lblGia = new JLabel("Giá vé");
		lblGia.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGia.setBounds(46, 180, 147, 25);
		pnInput.add(lblGia);

		tfTien = new JTextField();
		tfTien.setEditable(false);
		tfTien.setColumns(10);
		tfTien.setBounds(193, 180, 147, 22);
		tfTien.setEditable(false);
		pnInput.add(tfTien);

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(2, 0, 0, 0));
		panel.setBounds(448, 175, 178, 39);
		pnInput.add(panel);

		btnPhoto = new JButton("Chọn ảnh");
		btnPhoto.setIcon(new ImageIcon(GUIVethang.class.getResource("/Image/input.png")));
		btnPhoto.setEnabled(true);
		panel.add(btnPhoto);

		JPanel pnPhoto = new JPanel();
		pnPhoto.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		pnPhoto.setBounds(448, 12, 178, 157);
		pnInput.add(pnPhoto);
		pnPhoto.setLayout(null);

		lbPhoto = new JLabel("");
		lbPhoto.setBounds(0, 0, 180, 160);
		pnPhoto.add(lbPhoto);
		showMathe(false);
		AllActionListener ac = new AllActionListener();
		btnThem.addActionListener(ac);
		btnTim.addActionListener(ac);
		btnXoa.addActionListener(ac);
		btnSua.addActionListener(ac);
		btnHuy.addActionListener(ac);
		btnPhoto.addActionListener(ac);
		Action ab = new Action();
		cbLoaixe.addActionListener(ab);

		cbLoaixe.addPopupMenuListener(new PopupMenuListener() {

			@Override
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {

			}

			@Override
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
				if (cbLoaixe.getSelectedItem().toString().equals("Xe đạp")) {
					tfBienxe.setText("B");
				} else
					tfBienxe.setText("");

			}

			@Override
			public void popupMenuCanceled(PopupMenuEvent e) {

			}
		});
	}

	/**
	 * Hiện thị chi tiết vé khi vé được chọn
	 */
	private void mouseClick() {
		int row = table.getSelectedRow();
		if (row > -1) {
			showButtonUser(false, true);
			showMathe(true);
			bks = table.getModel().getValueAt(row, 1).toString();
			tfBienxe.setText(bks);
			cbLoaixe.setSelectedItem(table.getValueAt(row, 2).toString());
			da.inputDate(dateStart, table.getValueAt(row, 3).toString());
			da.inputDate(dateEnd, table.getValueAt(row, 4).toString());
			tfMathe.setText(table.getValueAt(row, 0).toString());
			tfTien.setText(table.getValueAt(row, 5).toString());

			photoPath = da.getPath(table.getValueAt(row, 0).toString());
			bus.setPicture(lbPhoto, photoPath);
		}

	}

	/**
	 * Ẩn/ Hiện các mục thông tin
	 * @param b Ẩn/ Hiện
	 */
	private void showMathe(Boolean b) {
		lbMathe.setVisible(b);
		tfMathe.setVisible(b);
		lblGia.setVisible(b);
		tfTien.setVisible(b);
		lbDateEnd.setVisible(b);
		dateEnd.setVisible(b);
	}

	/**
	 * Đưa các giá trị trên giao diện về null
	 */
	private void setNull() {
		tfMathe.setText("");
		tfBienxe.setText("");
		dateStart.setDate(null);
		dateEnd.setDate(null);
		tfTien.setText("");
		lbPhoto.setIcon(null);
	}

	/**
	 * Ẩn/ Hiện các nút chức năng
	 * @param them Ẩn/ Hiện nút Thêm
	 * @param other Ẩn/ Hiện các nút còn lại
	 */
	private void showButtonUser(boolean them, boolean other) {
		btnThem.setEnabled(them);
		btnSua.setEnabled(other);
		btnXoa.setEnabled(other);
		btnHuy.setEnabled(other);
	}

	/**
	 * Cho phép chỉnh sửa.
	 * @param b T/F
	 */
	private void showTextfield(boolean b) {
		tfBienxe.setEditable(b);
		cbLoaixe.setEditable(b);
	}

	/**
	 * Đặt ngày hết hạn
	 * @param dateStart Ngày đăng ký
	 * @return Trả về ngày hết hạn
	 */
	private JDateChooser add30Day(JDateChooser dateStart) {
		JDateChooser end = new JDateChooser();
		Date start = dateStart.getDate();
		Calendar c = Calendar.getInstance();
		c.setTime(start);
		c.add(Calendar.DAY_OF_MONTH, 30);
		end.setDate(c.getTime());
		return end;
	}

	/**
	 * @author Admin
	 * Lấy ra giá vé tương ứng với loại xe
	 */
	class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String a = cbLoaixe.getSelectedItem().toString();
			if (a.equals("Xe máy"))
				tfTien.setText(String.valueOf(da.getMoney("Xe máy")));
			else if (a.equals("Xe ô tô"))
				tfTien.setText(String.valueOf(da.getMoney("Xe ô tô")));
			else if (a.equals("Xe đạp")) {
				tfTien.setText(String.valueOf(da.getMoney("Xe đạp")));
				tfBienxe.setText("B");
			}

		}

	}

	/**
	 * @author Admin
	 * Xử lý sự kiện cho các nút chức năng
	 */
	class AllActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String select = e.getActionCommand();

			if (select.equals("Thêm")) {
				Add();
			}

			if (select.equals("Xóa")) {
				Delete();
			}

			if (select.equals("Sửa")) {
				Update();
			}
			if (select.equals("Hủy")) {
				setNull();
				showButtonUser(true, false);
				showMathe(false);
			}

			if (select.equals("Tìm kiếm")) {
				Timkiem();
			}

			if (select.equals("Chọn ảnh")) {
				ChonAnh();
			}
		}

		/**
		 * Thêm vé
		 */
		private void Add() {

			bks = tfBienxe.getText();
			loaixe = cbLoaixe.getSelectedItem().toString();
			try {
				ngaybd = dateStart.getDate();
				ngaybatdau = new SimpleDateFormat("yyyy-MM-dd").format(ngaybd);
				ngaykt = add30Day(dateStart).getDate();
				ngayketthuc = new SimpleDateFormat("yyyy-MM-dd").format(ngaykt);
				giave = da.getMoney(cbLoaixe.getSelectedItem().toString());
				bus.Add(new Customer(0, bks, loaixe, ngaybatdau, ngayketthuc,
						giave, file.getAbsolutePath()));
				showTextfield(true);
				showdata();
				setNull();
				showMathe(false);
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null,
						"Thông tin không được bỏ trống");
			}

		}

		/**
		 * Cập nhật thông tin vé
		 */
		private void Update() {
			int row = table.getSelectedRow();
			try {
				int mathe = Integer.parseInt(table.getValueAt(row, 0)
						.toString());
				bks = tfBienxe.getText();
				loaixe = cbLoaixe.getSelectedItem().toString();
				ngaybd = dateStart.getDate();
				ngaybatdau = new SimpleDateFormat("yyyy-MM-dd").format(ngaybd);
				ngaykt = add30Day(dateStart).getDate();
				ngayketthuc = new SimpleDateFormat("yyyy-MM-dd").format(ngaykt);
				giave = da.getMoney(loaixe);
				if (bks.equals("")) {
					JOptionPane.showMessageDialog(null,
							"Thông tin không được bỏ trống");
				} else if (file == null) {
					bus.Update(new Customer(mathe, bks, loaixe, ngaybatdau,
							ngayketthuc, giave, photoPath));
				} else {
					bus.Update(new Customer(mathe, bks, loaixe, ngaybatdau,
							ngayketthuc, giave, file.getAbsolutePath()));
				}
				showdata();
				setNull();
				showButtonUser(true, false);
				showMathe(false);

			} catch (Exception e) {
			}
		}

		/**
		 * Xóa vé được chọn
		 */
		private void Delete() {
			int row = table.getSelectedRow();
			int mathe = Integer.parseInt(table.getValueAt(row, 0).toString());

			bus.Delete(mathe);
			showdata();
			setNull();
			showButtonUser(true, false);
			showTextfield(true);
			showMathe(false);

		}

		/**
		 * Tìm kiếm thông tin vé
		 */
		private void Timkiem() {
			String search = tfSearch.getText();
			bus.Timkiem(search, table);
			tfSearch.setText("");
		}

		/**
		 * Chọn ảnh
		 */
		private void ChonAnh() {
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter loc = new FileNameExtensionFilter("Image",
					"jpg", "png");
			chooser.setFileFilter(loc);
			chooser.setDialogTitle("Chọn ảnh");
			int choose = chooser.showOpenDialog(null);
			if (choose == JFileChooser.APPROVE_OPTION) {
				file = chooser.getSelectedFile();
				String path = file.getAbsolutePath();
				bus.setPicture(lbPhoto, path);

			}

		}

	}
}
