package Hethong;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import Xe.Convert;

/**
 * Giao diện của chức năng Hệ thống
 * @author Nguyễn Văn Sơn
 *
 */
public class GUIHethong extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTable tableUser;

	private JTextField tfID, tfName, tfUsername, tfGiahientai, tfGiadieuchinh,
			tfSearch;

	private JButton btnThaydoi, btnHoantac, btnThem, btnCapnhat, btnXoa,
			btnHuy, btnSaoLuu, btnPhuchoi, btnSearch;

	@SuppressWarnings("rawtypes")
	private JComboBox cbType, cbLoaixe, cbLoaive;

	private JPasswordField passwordField;

	private DataAccessHethong process = new DataAccessHethong();

	private BussinessHethong b = new BussinessHethong();

	private String username;

	private final String sql = "select * from TAIKHOAN";

	/**
	 * Hàm dựng của lớp GUIHethong
	 */
	public GUIHethong() {

		setTitle("Quản lý hệ thống");
		setFrameIcon(new ImageIcon(
				GUIHethong.class.getResource("/Image/settings.png")));
		setBounds(0, 0, 1052, 618);
		init();
		showdata();
		showButtonUser(true, false);
		tfID.setEditable(false);
	}

	/**
	 * Truyền dữ liệu từ Database lên bảng
	 */
	private void showdata() {
		process.LoadData(sql, tableUser);
	}

	/**
	 * Thêm các thành phần giao diện
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void init() {
		JPanel pnTitle = new JPanel();
		pnTitle.setBorder(new EmptyBorder(20, 0, 20, 0));
		getContentPane().add(pnTitle, BorderLayout.NORTH);

		JLabel lbTitle = new JLabel("Quản Lý Hệ Thống");
		lbTitle.setForeground(Color.RED);
		lbTitle.setFont(new Font("Tahoma", Font.BOLD, 26));
		pnTitle.add(lbTitle);

		JPanel pnCenter = new JPanel();
		pnCenter.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(255,
				0, 0)));
		getContentPane().add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(null);

		JPanel pnUser = new JPanel();
		pnUser.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"),
				"Th\u00F4ng tin t\u00E0i kho\u1EA3n", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		pnUser.setBounds(10, 11, 684, 484);
		pnCenter.add(pnUser);
		pnUser.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 294, 664, 170);
		pnUser.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);

		tableUser = new JTable();
		tableUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mouseClick();
			}
		});

		tableUser.setFillsViewportHeight(true);

		scrollPane.setViewportView(tableUser);

		JPanel pnSearch = new JPanel();
		panel_1.add(pnSearch, BorderLayout.NORTH);
		pnSearch.setBorder(new EmptyBorder(5, 0, 0, 8));
		FlowLayout flowLayout = (FlowLayout) pnSearch.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);

		tfSearch = new JTextField();
		tfSearch.setLocation(355, 12);
		tfSearch.setHorizontalAlignment(SwingConstants.CENTER);
		pnSearch.add(tfSearch);
		tfSearch.setColumns(23);

		btnSearch = new JButton("Tìm kiếm");
		btnSearch.setIcon(new ImageIcon(GUIHethong.class
				.getResource("/Image/search1.png")));
		btnSearch.setHorizontalAlignment(SwingConstants.LEFT);
		pnSearch.add(btnSearch);

		JPanel pnInfor = new JPanel();
		pnInfor.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnInfor.setBounds(10, 28, 664, 255);
		pnUser.add(pnInfor);
		pnInfor.setLayout(new BorderLayout(0, 0));

		JPanel pnButton = new JPanel();
		pnButton.setBorder(new EmptyBorder(10, 0, 5, 0));
		pnInfor.add(pnButton, BorderLayout.SOUTH);

		btnThem = new JButton("Thêm");
		btnThem.setHorizontalAlignment(SwingConstants.LEFT);
		btnThem.setIcon(new ImageIcon(GUIHethong.class
				.getResource("/Image/add1.png")));
		pnButton.add(btnThem);

		btnCapnhat = new JButton("Cập nhật");
		btnCapnhat.setHorizontalAlignment(SwingConstants.LEFT);
		btnCapnhat.setIcon(new ImageIcon(GUIHethong.class
				.getResource("/Image/login2.png")));
		pnButton.add(btnCapnhat);

		btnXoa = new JButton("Xóa");
		btnXoa.setHorizontalAlignment(SwingConstants.LEFT);
		btnXoa.setIcon(new ImageIcon(GUIHethong.class
				.getResource("/Image/del.png")));
		pnButton.add(btnXoa);

		btnHuy = new JButton("Hủy");
		btnHuy.setHorizontalAlignment(SwingConstants.LEFT);
		btnHuy.setIcon(new ImageIcon(GUIHethong.class
				.getResource("/Image/close.png")));
		pnButton.add(btnHuy);

		JPanel pnUP = new JPanel();
		pnUP.setLocation(0, 42);
		pnInfor.add(pnUP, BorderLayout.CENTER);
		pnUP.setLayout(null);

		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblId.setBounds(150, 11, 120, 25);
		pnUP.add(lblId);

		JLabel lbName = new JLabel("Full Name");
		lbName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbName.setBounds(150, 134, 120, 25);
		pnUP.add(lbName);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsername.setBounds(150, 52, 120, 25);
		pnUP.add(lblUsername);

		JLabel lbPassword = new JLabel("Password");
		lbPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbPassword.setBounds(150, 93, 120, 25);
		pnUP.add(lbPassword);

		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblType.setBounds(150, 175, 120, 25);
		pnUP.add(lblType);

		tfID = new JTextField();
		tfID.setBounds(291, 11, 209, 25);
		pnUP.add(tfID);
		tfID.setColumns(10);

		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(291, 134, 209, 25);
		pnUP.add(tfName);

		tfUsername = new JTextField();
		tfUsername.setColumns(10);
		tfUsername.setBounds(291, 52, 209, 25);
		pnUP.add(tfUsername);

		passwordField = new JPasswordField();
		passwordField.setBounds(291, 93, 209, 25);
		pnUP.add(passwordField);

		cbType = new JComboBox();
		cbType.setModel(new DefaultComboBoxModel(new String[] { "Quản lý",
				"Nhân viên" }));
		cbType.setBounds(291, 175, 100, 25);
		pnUP.add(cbType);

		JPanel pnTicket = new JPanel();
		pnTicket.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"),
				"\u0110i\u1EC1u ch\u1EC9nh gi\u00E1 v\u00E9",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnTicket.setBounds(734, 11, 304, 289);
		pnCenter.add(pnTicket);
		pnTicket.setLayout(null);

		JPanel btn = new JPanel();
		btn.setBounds(32, 243, 247, 35);
		btn.setBorder(new EmptyBorder(0, 0, 20, 0));
		pnTicket.add(btn);

		btnThaydoi = new JButton("Thay đổi");
		btnThaydoi.setHorizontalAlignment(SwingConstants.LEFT);
		btnThaydoi.setIcon(new ImageIcon(GUIHethong.class
				.getResource("/Image/login2.png")));
		btn.add(btnThaydoi);

		btnHoantac = new JButton("Hoàn tác");
		btnHoantac.setHorizontalAlignment(SwingConstants.LEFT);
		btnHoantac.setIcon(new ImageIcon(GUIHethong.class
				.getResource("/Image/close.png")));
		btn.add(btnHoantac);

		JPanel pnType = new JPanel();
		pnType.setBounds(32, 43, 258, 192);
		pnTicket.add(pnType);
		pnType.setLayout(null);

		JLabel lbLoaiXe = new JLabel("Loại xe");
		lbLoaiXe.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbLoaiXe.setBounds(10, 61, 90, 25);
		pnType.add(lbLoaiXe);

		JLabel lbMucgia = new JLabel("Giá hiện tại");
		lbMucgia.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbMucgia.setBounds(10, 104, 90, 25);
		pnType.add(lbMucgia);

		cbLoaixe = new JComboBox();
		cbLoaixe.addPopupMenuListener(new PopupMenuListener() {

			public void popupMenuWillBecomeVisible(PopupMenuEvent arg0) {
			}

			public void popupMenuWillBecomeInvisible(PopupMenuEvent arg0) {
				if (cbLoaive.getSelectedItem().toString() != "Chọn loại vé")
					showTicket();
			}

			public void popupMenuCanceled(PopupMenuEvent arg0) {
			}
		});
		cbLoaixe.setModel(new DefaultComboBoxModel(new String[] {
				"Chọn loại xe", "Xe đạp", "Xe máy", "Xe ô tô" }));
		cbLoaixe.setBounds(110, 61, 127, 25);
		pnType.add(cbLoaixe);

		tfGiahientai = new JTextField();
		tfGiahientai.setEditable(false);
		tfGiahientai.setBounds(110, 104, 127, 25);
		pnType.add(tfGiahientai);
		tfGiahientai.setColumns(10);

		JLabel lblGDC = new JLabel("Giá điều chỉnh");
		lblGDC.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGDC.setBounds(10, 147, 90, 25);
		pnType.add(lblGDC);

		tfGiadieuchinh = new JTextField();
		tfGiadieuchinh.setColumns(10);
		tfGiadieuchinh.setBounds(110, 147, 127, 25);
		pnType.add(tfGiadieuchinh);

		JLabel lblLoaive = new JLabel("Loại vé");
		lblLoaive.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLoaive.setBounds(10, 18, 46, 25);
		pnType.add(lblLoaive);

		cbLoaive = new JComboBox();
		cbLoaive.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent e) {
			}

			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
				showTicket();
			}

			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
			}
		});
		cbLoaive.setBounds(110, 18, 127, 25);
		pnType.add(cbLoaive);
		cbLoaive.setModel(new DefaultComboBoxModel(new String[] {
				"Chọn loại vé", "Vé ngày", "Vé tháng" }));

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"),
				"Sao l\u01B0u - Ph\u1EE5c h\u1ED3i", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel.setBounds(734, 421, 304, 74);
		pnCenter.add(panel);
		panel.setLayout(null);

		btnSaoLuu = new JButton("Sao lưu");
		btnSaoLuu.setBounds(15, 34, 107, 33);
		btnSaoLuu.setIcon(new ImageIcon(GUIHethong.class
				.getResource("/Image/backup.png")));
		btnSaoLuu.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(btnSaoLuu);

		btnPhuchoi = new JButton("Phục hồi");
		btnPhuchoi.setBounds(187, 34, 102, 33);
		btnPhuchoi.setIcon(new ImageIcon(GUIHethong.class
				.getResource("/Image/phuchoi.png")));
		btnPhuchoi.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(btnPhuchoi);
		action ac = new action();
		btnThem.addActionListener(ac);
		btnCapnhat.addActionListener(ac);
		btnXoa.addActionListener(ac);
		btnHuy.addActionListener(ac);

		btnThaydoi.addActionListener(ac);
		btnHoantac.addActionListener(ac);

		btnSearch.addActionListener(ac);
		btnSaoLuu.addActionListener(ac);
		btnPhuchoi.addActionListener(ac);
	}

	/**
	 * Hiện thông tin của tài khoản được chọn lên bảng
	 */
	private void mouseClick() {

		int row = tableUser.getSelectedRow();
		if (row > -1) {
			username = tableUser.getModel().getValueAt(row, 1).toString();
			tfUsername.setText(username);
			passwordField.setText(tableUser.getValueAt(row, 2).toString());
			tfName.setText(tableUser.getValueAt(row, 3).toString());
			tfID.setText(tableUser.getValueAt(row, 0).toString());
			cbType.setSelectedItem(tableUser.getValueAt(row, 4).toString());

			showButtonUser(false, true);
		}

	}

	/**
	 * Đưa giá vé từ Database lên bảng
	 */
	private void showTicket() {
		String Loaixe_GUI = cbLoaixe.getSelectedItem().toString();
		String Loaixe = Convert.GUI_To_DB(Loaixe_GUI);

		String Loaive = cbLoaive.getSelectedItem().toString();
		b.showTicket(Loaixe, Loaive, tfGiahientai);
	}

	/**
	 * Đưa các giá trị trong ô về rỗng
	 */
	private void setNull() {
		tfID.setText("");
		tfName.setText("");
		tfUsername.setText("");
		passwordField.setText("");
	}

	/**
	 * Ẩn/Hiện các nút chức năng
	 * @param them Ẩn/ Hiện nút Thêm
	 * @param other Ẩn/ Hiện các nút còn lại
	 */
	private void showButtonUser(boolean them, boolean other) {
		btnThem.setEnabled(them);
		btnCapnhat.setEnabled(other);
		btnXoa.setEnabled(other);
		btnHuy.setEnabled(other);
	}

	/**
	 * Cho phép chỉnh sửa thông tin tài khoản
	 * @param b True/ False
	 */
	private void showTextfield(boolean b) {
		tfName.setEditable(b);
		tfUsername.setEditable(b);
		passwordField.setEditable(b);
		cbType.setEnabled(b);
	}

	/**
	 * Xử lý sự kiện cho các nút chức năng
	 * @author Admin
	 *
	 */
	class action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String select = e.getActionCommand();

			if (select.equals("Thêm")) {
				Them();
			}

			if (select.equals("Cập nhật")) {
				Capnhat();
			}

			if (select.equals("Xóa")) {
				Xoa();
			}

			if (select.equals("Hủy")) {
				Huy();
			}

			if (select.equals("Thay đổi")) {
				b.Thaydoi(cbLoaixe, cbLoaive, tfGiadieuchinh, tfGiahientai);
			}

			if (select.equals("Hoàn tác")) {
				Hoantac();
			}

			if (select.equals("Tìm kiếm")) {
				Timkiem();
			}

			if (select.equals("Sao lưu")) {
				JOptionPane.showMessageDialog(null,
						"Tính năng đang được phát triển");
			}

			if (select.equals("Phục hồi")) {
				JOptionPane.showMessageDialog(null,
						"Tính năng đang được phát triển");
			}
		}

		
		/**
		 * Thêm tài khoản mới
		 */
		private void Them() {
			String user = tfUsername.getText();
			String pass = String.valueOf(passwordField.getPassword());
			String ten = tfName.getText();
			String chucvu = Convert.GUI_To_DB(cbType.getSelectedItem()
					.toString());
			b.Them(new HethongUser(0, user, pass, ten, chucvu));
			showTextfield(true);
			showdata();
			setNull();
		}

		/**
		 * Cập nhật thông tin tài khoản
		 */
		private void Capnhat() {
			int row = tableUser.getSelectedRow();
			try {
				int id = Integer.parseInt(tableUser.getValueAt(row, 0)
						.toString());
				String user = tfUsername.getText();
				String pass = String.valueOf(passwordField.getPassword());
				String ten = tfName.getText();
				String chucvu = Convert.GUI_To_DB(cbType.getSelectedItem()
						.toString());

				b.Capnhat(new HethongUser(id, user, pass, ten, chucvu));
				showdata();
				setNull();
				showButtonUser(true, false);

			} catch (Exception e) {
			}
		}

		/**
		 * Xóa tài khoản
		 */
		private void Xoa() {
			int row = tableUser.getSelectedRow();
			int id = Integer.parseInt(tableUser.getValueAt(row, 0).toString());

			b.Xoa(id);
			showdata();
			setNull();
			showButtonUser(true, false);
			showTextfield(true);
		}

		/**
		 * Hủy bỏ tác vụ
		 */
		private void Huy() {
			setNull();
			showTextfield(true);
			tfID.setEditable(false);
			showButtonUser(true, false);
		}

		/**
		 * Hủy bỏ tác vụ hiện tại
		 */
		private void Hoantac() {
			tfGiadieuchinh.setText("");
		}

		/**
		 * Tìm kiếm thông tin tài khoản
		 */
		private void Timkiem() {
			String search = tfSearch.getText();
			b.Timkiem(search, tableUser);
			tfSearch.setText("");
		}

	}
}
