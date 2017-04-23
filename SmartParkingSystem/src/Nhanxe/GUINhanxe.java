package Nhanxe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.UIManager;

/**
 * Giao diện của chức năng Quản lý nhận xe
 * @author Đặng Khắc Toàn
 *
 */
public class GUINhanxe extends JInternalFrame {
	private static final long serialVersionUID = 1L;

	private JTextField tfMaxe, tfBienso, tfTime, tfsearch;

	private JTable tableNhanxe;

	private JLabel lnSum, lblThoiGianVao, lblMaXe;

	@SuppressWarnings("rawtypes")
	private static JComboBox cbLoaixe;

	private final ButtonGroup buttonGroup = new ButtonGroup();

	private JRadioButton rdbtnThang, rdbtnNgay;

	private JButton btnThem, btnChinhsua, btnXoa, btnSearch, btnHome, btCancel;

	@SuppressWarnings("rawtypes")
	private JComboBox cbLocation;

	private DataAccessNhanXe da = new DataAccessNhanXe();

	/**
	 * Hàm dựng của lớp GUINhanxe
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public GUINhanxe() {

		setTitle("Quản lý nhận xe\r\n");
		setFrameIcon(new ImageIcon(
				GUINhanxe.class.getResource("/Image/shopping-cart-remove.png")));
		setBounds(0, 0, 1052, 618);

		JPanel pnBorder = new JPanel();
		getContentPane().add(pnBorder, BorderLayout.CENTER);
		pnBorder.setLayout(new BorderLayout(0, 0));

		JPanel pnTitle = new JPanel();
		pnBorder.add(pnTitle, BorderLayout.NORTH);
		pnTitle.setBorder(new EmptyBorder(20, 0, 20, 0));

		JLabel lbTitle = new JLabel("Quản Lý Nhận Xe");
		lbTitle.setForeground(Color.RED);
		lbTitle.setFont(new Font("Tahoma", Font.BOLD, 26));
		pnTitle.add(lbTitle);

		JPanel pnCenter = new JPanel();
		pnCenter.setBorder(new MatteBorder(1, 0, 0, 0, (Color) Color.RED));
		pnBorder.add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(null);

		JPanel pnProcess = new JPanel();
		pnProcess.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh s\u00E1ch xe", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnProcess.setBounds(10, 11, 684, 484);
		pnCenter.add(pnProcess);
		pnProcess.setLayout(new BorderLayout(0, 0));

		JPanel pnSearch = new JPanel();
		pnProcess.add(pnSearch, BorderLayout.NORTH);
		pnSearch.setLayout(new GridLayout(1, 2, 0, 0));

		JPanel pnInput = new JPanel();
		pnInput.setBorder(new EmptyBorder(15, 10, 40, 0));
		pnSearch.add(pnInput);
		pnInput.setLayout(new BoxLayout(pnInput, BoxLayout.X_AXIS));

		tfsearch = new JTextField();
		pnInput.add(tfsearch);
		tfsearch.setColumns(10);

		JPanel pnTool = new JPanel();
		pnTool.setBorder(new EmptyBorder(15, 30, 40, 30));
		pnSearch.add(pnTool);
		pnTool.setLayout(new GridLayout(1, 2, 30, 20));

		btnSearch = new JButton("Tìm kiếm");
		btnSearch.setIcon(new ImageIcon(GUINhanxe.class
				.getResource("/Image/search1.png")));
		pnTool.add(btnSearch);

		btnHome = new JButton("Trở lại");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHome.setIcon(new ImageIcon(GUINhanxe.class
				.getResource("/Image/input.png")));
		pnTool.add(btnHome);

		JScrollPane scrollPane = new JScrollPane();
		pnProcess.add(scrollPane, BorderLayout.CENTER);

		tableNhanxe = new JTable();

		tableNhanxe.setFont(new Font("Tahoma", Font.BOLD, 11));
		tableNhanxe.setFillsViewportHeight(true);
		scrollPane.setViewportView(tableNhanxe);

		lnSum = new JLabel();
		lnSum.setFont(new Font("Tahoma", Font.BOLD, 12));
		pnProcess.add(lnSum, BorderLayout.SOUTH);

		JPanel pnInfor = new JPanel();
		pnInfor.setBorder(new TitledBorder(null, "Th\u00F4ng tin xe",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnInfor.setBounds(734, 11, 304, 484);
		pnCenter.add(pnInfor);
		pnInfor.setLayout(new GridLayout(7, 1, 0, 0));

		JPanel pnID = new JPanel();
		pnID.setBorder(new EmptyBorder(20, 10, 15, 10));
		pnInfor.add(pnID);
		pnID.setLayout(new GridLayout(0, 2, 0, 0));

		lblMaXe = new JLabel("Số vé");
		pnID.add(lblMaXe);

		tfMaxe = new JTextField();
		tfMaxe.setEditable(false);
		tfMaxe.setEnabled(false);
		pnID.add(tfMaxe);
		tfMaxe.setColumns(10);

		JPanel pnTypeCar = new JPanel();
		pnTypeCar.setBorder(new EmptyBorder(20, 10, 15, 10));
		pnInfor.add(pnTypeCar);
		pnTypeCar.setLayout(new GridLayout(1, 0, 0, 0));
		JLabel lblLoaiXe = new JLabel("Loại xe");
		pnTypeCar.add(lblLoaiXe);

		cbLoaixe = new JComboBox();
		cbLoaixe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				cbLocation.setModel(new DefaultComboBoxModel(setLocation()));
			}
		});

		cbLoaixe.setModel(new DefaultComboBoxModel(new String[] {
				"Chọn loại xe", "Xe đạp", "Xe máy", "Xe ô tô" }));
		pnTypeCar.add(cbLoaixe);

		cbLoaixe.addPopupMenuListener(new PopupMenuListener() {

			@Override
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {

			}

			@Override
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
				if (cbLoaixe.getSelectedItem().toString().equals("Xe đạp")) {
					tfBienso.setText("");
				}

			}

			@Override
			public void popupMenuCanceled(PopupMenuEvent e) {

			}
		});

		JPanel pnBien = new JPanel();
		pnBien.setBorder(new EmptyBorder(20, 10, 15, 10));
		pnInfor.add(pnBien);
		pnBien.setLayout(new GridLayout(1, 0, 0, 0));

		JLabel lblBienSo = new JLabel("Biển số");
		pnBien.add(lblBienSo);

		tfBienso = new JTextField();
		pnBien.add(tfBienso);
		tfBienso.setColumns(10);
		JPanel pnVitri = new JPanel();
		pnVitri.setBorder(new EmptyBorder(20, 10, 15, 10));
		pnInfor.add(pnVitri);
		pnVitri.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel pnTypeTicket = new JPanel();
		pnTypeTicket.setBorder(new EmptyBorder(20, 10, 15, 10));
		pnInfor.add(pnTypeTicket);
		pnTypeTicket.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblLoaiVe = new JLabel("Loại vé");
		pnTypeTicket.add(lblLoaiVe);

		JPanel pnRadio = new JPanel();
		pnTypeTicket.add(pnRadio);
		pnRadio.setLayout(new GridLayout(0, 2, 0, 0));

		rdbtnThang = new JRadioButton("Tháng");
		rdbtnThang.setHorizontalAlignment(SwingConstants.LEFT);
		buttonGroup.add(rdbtnThang);
		pnRadio.add(rdbtnThang);

		rdbtnNgay = new JRadioButton("Ngày");
		rdbtnNgay.setHorizontalAlignment(SwingConstants.LEFT);
		buttonGroup.add(rdbtnNgay);
		pnRadio.add(rdbtnNgay);

		JPanel pnTime = new JPanel();
		pnTime.setBorder(new EmptyBorder(20, 10, 15, 10));
		pnInfor.add(pnTime);
		pnTime.setLayout(new GridLayout(0, 2, 0, 0));

		lblThoiGianVao = new JLabel("Thời gian vào");
		pnTime.add(lblThoiGianVao);

		tfTime = new JTextField();
		tfTime.setEditable(false);
		tfTime.setEnabled(false);
		pnTime.add(tfTime);
		tfTime.setColumns(10);

		JLabel lbVitri = new JLabel("Vị trí");
		pnVitri.add(lbVitri);

		cbLocation = new JComboBox();
		cbLocation.setModel(new DefaultComboBoxModel(
				new String[] { "Chọn vị trí" }));

		cbLocation.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (cbLoaixe.getSelectedItem().toString().equals("Xe đạp")) {
					tfBienso.setText(cbLocation.getSelectedItem().toString());
				}

			}
		});
		JPanel pnButton = new JPanel();
		pnButton.setBorder(new EmptyBorder(10, 15, 0, 15));
		pnInfor.add(pnButton);
		pnButton.setLayout(new GridLayout(2, 2, 40, 5));

		btnThem = new JButton("Thêm");
		btnThem.setHorizontalAlignment(SwingConstants.LEFT);
		btnThem.setIcon(new ImageIcon(GUINhanxe.class
				.getResource("/Image/add1.png")));
		pnButton.add(btnThem);

		btnXoa = new JButton("Xóa");
		btnXoa.setEnabled(false);
		btnXoa.setHorizontalAlignment(SwingConstants.LEFT);
		btnXoa.setIcon(new ImageIcon(GUINhanxe.class
				.getResource("/Image/close2.png")));
		pnButton.add(btnXoa);

		btnChinhsua = new JButton("Sửa");
		btnChinhsua.setEnabled(false);
		btnChinhsua.setHorizontalAlignment(SwingConstants.LEFT);
		btnChinhsua.setIcon(new ImageIcon(GUINhanxe.class
				.getResource("/Image/sua.png")));
		pnButton.add(btnChinhsua);

		btCancel = new JButton("Hủy");
		btCancel.setHorizontalAlignment(SwingConstants.LEFT);
		btCancel.setIcon(new ImageIcon(GUINhanxe.class
				.getResource("/Image/close.png")));
		btCancel.setEnabled(false);
		pnButton.add(btCancel);

		showText(false);

		tableNhanxe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int row = tableNhanxe.getSelectedRow();
				if (row > -1) {
					btCancel.setEnabled(true);
					btnThem.setEnabled(false);
					btnXoa.setEnabled(true);
					btnChinhsua.setEnabled(true);
					tfMaxe.setEnabled(true);
					showToEdit();
					showText(true);
				}

			}
		});
		pnVitri.add(cbLocation);
		showData();
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getCbLocation() {
		return cbLocation;
	}

	@SuppressWarnings("rawtypes")
	public void setCbLocation(JComboBox cbLocation) {
		this.cbLocation = cbLocation;
	}

	/**
	 * Thêm sự kiện cho các nút chức năng
	 * @param e Đối số
	 */
	public void addAction(ActionListener e) {
		btnThem.addActionListener(e);
		btnChinhsua.addActionListener(e);
		btnHome.addActionListener(e);
		btnSearch.addActionListener(e);
		btCancel.addActionListener(e);
		btnXoa.addActionListener(e);
	}

	/**
	 * Đưa thông tin về xe lên bảng
	 */
	public void showData() {
		DataAccessNhanXe dataNhanxe = new DataAccessNhanXe();
		dataNhanxe.loadData(tableNhanxe);
		lnSum.setText("Tổng số xe: " + da.TongXe());
	}

	/**
	 * Hiện thông tin chi tiết của xe để chỉnh sửa
	 */
	public void showToEdit() {
		int row = tableNhanxe.getSelectedRow();
		tfMaxe.setText(tableNhanxe.getValueAt(row, 0).toString());
		tfBienso.setText(tableNhanxe.getValueAt(row, 1).toString());
		cbLoaixe.setSelectedItem(tableNhanxe.getValueAt(row, 2).toString());
		tfTime.setText(tableNhanxe.getValueAt(row, 4).toString());
		cbLocation.setSelectedItem(tableNhanxe.getValueAt(row, 5));
		if ((tableNhanxe.getValueAt(tableNhanxe.getSelectedRow(), 3))
				.equals("Vé tháng")) {
			buttonGroup.setSelected(rdbtnThang.getModel(), true);
		} else if ((tableNhanxe.getValueAt(row, 3)).equals("Vé ngày")) {
			buttonGroup.setSelected(rdbtnNgay.getModel(), true);
		}
		tfTime.setEnabled(true);
	}

	public String[] setLocation() {
		DataAccessNhanXe dataAccessNhanxe = new DataAccessNhanXe();
		ArrayList<String> location = new ArrayList<>();
		location.add("Chọn vị trí");
		int i = 1;
		if (tableNhanxe.getSelectedRow() > -1) {
			location.add(tableNhanxe
					.getValueAt(tableNhanxe.getSelectedRow(), 5).toString());
			i++;
		}
		String arrModel[] = null;
		ResultSet rs = null;
		try {
			if (cbLoaixe.getSelectedItem().equals("Xe máy"))
				rs = dataAccessNhanxe.location("M");
			if (cbLoaixe.getSelectedItem().equals("Xe ô tô"))
				rs = dataAccessNhanxe.location("C");
			if (cbLoaixe.getSelectedItem().equals("Xe đạp"))
				rs = dataAccessNhanxe.location("B");
			try {
				while (rs.next()) {
					location.add(rs.getString("Vitri"));
					i++;
				}
			} catch (NullPointerException e) {
				// JOptionPane.showMessageDialog(null, "Hãy chọn một loại xe");
			}

			arrModel = new String[i];
			for (int count = 0; count < i; count++) {
				arrModel[count] = location.get(count);
			}
		} catch (SQLException e) {

		}
		return arrModel;
	}

	/**
	 * Ẩn hiện các thành phần giao diện
	 * @param b Ẩn/ Hiện
	 */
	public void showText(boolean b) {
		lblMaXe.setVisible(b);
		lblThoiGianVao.setVisible(b);
		tfMaxe.setVisible(b);
		tfTime.setVisible(b);
	}

	/**
	 * Ẩn/ Hiện các nút chức năng
	 * @param them Ẩn/ Hiện nút Thêm
	 * @param other Ẩn/ Hiện các nút khác
	 */

	public void showButton(boolean them, boolean other) {
		getTfTime().setEnabled(false);
		getBtCancel().setEnabled(false);
		getBtnThem().setEnabled(true);
		getBtnChinhsua().setEnabled(false);
		getBtnXoa().setEnabled(false);
		getTfMaxe().setEnabled(false);
	}

	/**
	 * @return Lấy ra nút Hủy
	 */
	public JButton getBtCancel() {
		return btCancel;
	}

	public void setBtCancel(JButton btCancel) {
		this.btCancel = btCancel;
	}

	public JTextField getTfMaxe() {
		return tfMaxe;
	}

	public void setTfMaxe(JTextField tfMaxe) {
		this.tfMaxe = tfMaxe;
	}

	public JTextField getTfBienso() {
		return tfBienso;
	}

	public void setTfBienso(JTextField tfBienso) {
		this.tfBienso = tfBienso;
	}

	public JTextField getTfTime() {
		return tfTime;
	}

	public void setTfTime(JTextField tfTime) {
		this.tfTime = tfTime;
	}

	public JTable getTableNhanxe() {
		return tableNhanxe;
	}

	public void setTableNhanxe(JTable tableNhanxe) {
		this.tableNhanxe = tableNhanxe;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getCbLoaixe() {
		return cbLoaixe;
	}

	@SuppressWarnings({ "rawtypes", "static-access" })
	public void setCbLoaixe(JComboBox cbLoaixe) {
		this.cbLoaixe = cbLoaixe;
	}

	/**
	 * @return Lấy ra nút Thêm
	 */
	public JButton getBtnThem() {
		return btnThem;
	}

	public JRadioButton getRdbtnThang() {
		return rdbtnThang;
	}

	public void setRdbtnThang(JRadioButton rdbtnThang) {
		this.rdbtnThang = rdbtnThang;
	}

	public JRadioButton getRdbtnNgay() {
		return rdbtnNgay;
	}

	public void setRdbtnNgay(JRadioButton rdbtnNgay) {
		this.rdbtnNgay = rdbtnNgay;
	}

	public void setBtnThem(JButton btnThem) {
		this.btnThem = btnThem;
	}

	/**
	 * @return Lấy ra nút Sửa
	 */
	public JButton getBtnChinhsua() {
		return btnChinhsua;
	}

	public void setBtnChinhsua(JButton btnChinhsua) {
		this.btnChinhsua = btnChinhsua;
	}

	/**
	 * @return Lấy ra nút Xóa
	 */
	public JButton getBtnXoa() {
		return btnXoa;
	}

	public void setBtnXoa(JButton btnXoa) {
		this.btnXoa = btnXoa;
	}

	public JTextField getTfsearch() {
		return tfsearch;
	}

	public void setTfsearch(JTextField tfsearch) {
		this.tfsearch = tfsearch;
	}

	/**
	 * @return Lấy ra nút Tìm kiêm
	 */
	public JButton getBtnSearch() {
		return btnSearch;
	}

	public void setBtnSearch(JButton btnSearch) {
		this.btnSearch = btnSearch;
	}

	/**
	 * @return Lấy ra nút Trở lại
	 */
	public JButton getBtnHome() {
		return btnHome;
	}

	public void setBtnHome(JButton btnHome) {
		this.btnHome = btnHome;
	}

	public ButtonGroup getButtonGroup() {
		return buttonGroup;
	}

	public JLabel getLbTongxe() {
		return lnSum;
	}

}
