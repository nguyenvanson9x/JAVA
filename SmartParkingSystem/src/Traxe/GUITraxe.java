package Traxe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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

import com.toedter.calendar.JDateChooser;

import Xe.Convert;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;

/**
 * Giao diện của chức năng Quản lý trả xe
 * @author Nguyễn Duy Vũ
 * 
 */
public class GUITraxe extends JInternalFrame {
	private static final long serialVersionUID = 1L;

	private JTextField tfMaxe, tfBienso, tfVitri, tfLoaixe, tfTimeIn, tfMoney,
			tfLoaiVe, tfsearch;

	private JTable tableTraxe;

	private JLabel lnSum;

	private JButton btnTraxe, btnHuy, btnSearch, btnHome, btnThanhtien;

	private JDateChooser TimeOut;

	private DataAccessTraXe con = new DataAccessTraXe();

	private TraxeProcess pro = new TraxeProcess();

	/**
	 * Hàm dựng của lớp GUITraxe
	 */
	public GUITraxe() {

		setTitle("Quản lý trả xe");
		setFrameIcon(new ImageIcon(
				GUITraxe.class.getResource("/Image/shopping-cart-add.png")));
		setBounds(0, 0, 1052, 618);

		JPanel pnBorder = new JPanel();
		getContentPane().add(pnBorder, BorderLayout.CENTER);
		pnBorder.setLayout(new BorderLayout(0, 0));

		JPanel pnTitle = new JPanel();
		pnBorder.add(pnTitle, BorderLayout.NORTH);
		pnTitle.setBorder(new EmptyBorder(20, 0, 20, 0));

		JLabel lblQunLNhn = new JLabel("Quản Lý Trả Xe");
		lblQunLNhn.setForeground(Color.RED);
		lblQunLNhn.setFont(new Font("Tahoma", Font.BOLD, 26));
		pnTitle.add(lblQunLNhn);

		JPanel pnCenter = new JPanel();
		pnCenter.setBorder(new MatteBorder(1, 0, 0, 0, (Color) Color.RED));
		pnBorder.add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(null);

		JPanel pnProcess = new JPanel();
		pnProcess.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh s\u00E1ch xe", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnProcess.setBounds(10, 11, 684, 484);
		pnCenter.add(pnProcess);
		pnProcess.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		pnProcess.add(scrollPane, BorderLayout.CENTER);

		tableTraxe = new JTable();
		tableTraxe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showData();
				tfMoney.setText("");
			}
		});
		tableTraxe.setFont(new Font("Tahoma", Font.BOLD, 11));
		tableTraxe.setFillsViewportHeight(true);
		scrollPane.setViewportView(tableTraxe);

		lnSum = new JLabel();
		lnSum.setFont(new Font("Tahoma", Font.BOLD, 12));
		pnProcess.add(lnSum, BorderLayout.SOUTH);

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
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pro.search(tableTraxe, tfsearch.getText());
				setSizeColumn();

			}
		});
		btnSearch.setIcon(new ImageIcon(GUITraxe.class
				.getResource("/Image/search1.png")));
		pnTool.add(btnSearch);

		btnHome = new JButton("Trở lại");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pro.home(tableTraxe, tfsearch);
				pro.huy(tableTraxe, tfMaxe, tfMoney, tfBienso, tfLoaixe,
						tfTimeIn, tfLoaiVe, tfVitri, TimeOut);
				setSizeColumn();
			}
		});
		btnHome.setIcon(new ImageIcon(GUITraxe.class
				.getResource("/Image/input.png")));
		pnTool.add(btnHome);

		JPanel pnInfor = new JPanel();
		pnInfor.setBorder(new TitledBorder(null, "Thông tin xe",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnInfor.setBounds(734, 11, 304, 484);
		pnCenter.add(pnInfor);
		pnInfor.setLayout(new GridLayout(9, 1, 0, 0));

		JPanel pnID = new JPanel();
		pnID.setBorder(new EmptyBorder(20, 10, 0, 10));
		pnInfor.add(pnID);
		pnID.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lbSove = new JLabel("Số vé");
		pnID.add(lbSove);

		tfMaxe = new JTextField();
		tfMaxe.setEditable(false);
		pnID.add(tfMaxe);
		tfMaxe.setColumns(10);

		JPanel pnBien = new JPanel();
		pnBien.setBorder(new EmptyBorder(20, 10, 0, 10));
		pnInfor.add(pnBien);
		pnBien.setLayout(new GridLayout(1, 0, 0, 0));

		JLabel lbBienso = new JLabel("Biển số");
		pnBien.add(lbBienso);

		tfBienso = new JTextField();
		tfBienso.setEditable(false);
		pnBien.add(tfBienso);
		tfBienso.setColumns(10);

		JPanel pnTypeCar = new JPanel();
		pnTypeCar.setBorder(new EmptyBorder(20, 10, 0, 10));
		pnInfor.add(pnTypeCar);
		pnTypeCar.setLayout(new GridLayout(1, 0, 0, 0));

		JLabel lbLoaixe = new JLabel("Loại xe");
		pnTypeCar.add(lbLoaixe);

		tfLoaixe = new JTextField();
		tfLoaixe.setEditable(false);
		pnTypeCar.add(tfLoaixe);
		tfLoaixe.setColumns(10);

		JPanel pnTimeIn = new JPanel();
		pnTimeIn.setBorder(new EmptyBorder(20, 10, 0, 10));
		pnInfor.add(pnTimeIn);
		pnTimeIn.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lbTimeIn = new JLabel("Thời gian vào");
		pnTimeIn.add(lbTimeIn);

		tfTimeIn = new JTextField();
		tfTimeIn.setEditable(false);
		tfTimeIn.setColumns(10);
		pnTimeIn.add(tfTimeIn);

		JPanel pnTimeOut = new JPanel();
		pnTimeOut.setBorder(new EmptyBorder(20, 10, 0, 10));
		pnInfor.add(pnTimeOut);
		pnTimeOut.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lnTimeOut = new JLabel("Thời gian ra");
		pnTimeOut.add(lnTimeOut);

		TimeOut = new JDateChooser();
		TimeOut.setDateFormatString("yyyy-MM-dd");
		pnTimeOut.add(TimeOut);

		JPanel pnVitri = new JPanel();
		pnVitri.setBorder(new EmptyBorder(20, 10, 0, 10));
		pnInfor.add(pnVitri);
		pnVitri.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lbVitri = new JLabel("Vị trí");
		pnVitri.add(lbVitri);

		tfVitri = new JTextField();
		tfVitri.setEditable(false);
		pnVitri.add(tfVitri);
		tfVitri.setColumns(10);

		JPanel pnTypeTicket = new JPanel();
		pnTypeTicket.setBorder(new EmptyBorder(20, 10, 0, 10));
		pnInfor.add(pnTypeTicket);
		pnTypeTicket.setLayout(new GridLayout(1, 2, 0, 0));

		JLabel lblLoiV = new JLabel("Loại vé");
		pnTypeTicket.add(lblLoiV);

		tfLoaiVe = new JTextField();
		tfLoaiVe.setEditable(false);
		pnTypeTicket.add(tfLoaiVe);
		tfLoaiVe.setColumns(10);

		JPanel pnMoney = new JPanel();
		pnMoney.setBorder(new EmptyBorder(20, 10, 0, 10));
		pnInfor.add(pnMoney);

		btnThanhtien = new JButton("Thành tiền");
		btnThanhtien.setBounds(10, 20, 85, 30);
		btnThanhtien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (TimeOut.getDate() == null) {
					JOptionPane.showMessageDialog(null,
							"Xin vui lòng chọn thời gian ra để tính tiền");
				} else
					setMoney();
			}
		});
		pnMoney.setLayout(null);
		pnMoney.add(btnThanhtien);

		tfMoney = new JTextField();
		tfMoney.setBounds(146, 20, 136, 30);
		tfMoney.setEditable(false);
		pnMoney.add(tfMoney);
		tfMoney.setColumns(10);

		JPanel pnButton = new JPanel();
		pnButton.setBorder(new EmptyBorder(20, 10, 0, 10));
		pnInfor.add(pnButton);
		pnButton.setLayout(new GridLayout(1, 2, 10, 10));

		btnTraxe = new JButton("Trả xe");
		btnTraxe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tfLoaiVe.getText().equals("")
						&& tfLoaixe.getText().equals("")
						&& tfMaxe.getText().equals("")
						&& tfTimeIn.getText().equals("")
						&& tfVitri.getText().equals("")
						&& tfMoney.getText().equals("")
						&& TimeOut.getDate() == null) {
					JOptionPane.showMessageDialog(null,
							"Xin vui lòng chọn xe để trả ");
				} else {
					if (TimeOut.getDate() == null) {
						JOptionPane.showMessageDialog(null,
								"Xin vui lòng chọn thời gian ra");
					} else {
						if (tfMoney.getText().equals("")) {
							JOptionPane.showMessageDialog(null,
									"Xin vui lòng tính tiền");
						} else {
							Date time = (Date) TimeOut.getDate();
							SimpleDateFormat formatter = new SimpleDateFormat(
									"yyyy-MM-dd");
							String timeOut = formatter.format(time);
							pro.traxe(tableTraxe, tfMaxe.getText(),
									tfBienso.getText(), tfLoaixe.getText(),
									tfLoaiVe.getText(), tfTimeIn.getText(),
									timeOut, tfVitri.getText(),
									tfMoney.getText());
							pro.huy(tableTraxe, tfMaxe, tfMoney, tfBienso,
									tfLoaixe, tfTimeIn, tfLoaiVe, tfVitri,
									TimeOut);
							setSizeColumn();
						}
					}
				}
				showTongxe();
			}
		});
		btnTraxe.setHorizontalAlignment(SwingConstants.LEFT);
		btnTraxe.setIcon(new ImageIcon(GUITraxe.class
				.getResource("/Image/shopping-cart-add.png")));
		pnButton.add(btnTraxe);

		btnHuy = new JButton("Hủy");
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pro.huy(tableTraxe, tfMaxe, tfMoney, tfBienso, tfLoaixe,
						tfTimeIn, tfLoaiVe, tfVitri, TimeOut);
				setSizeColumn();
			}
		});
		btnHuy.setHorizontalAlignment(SwingConstants.LEFT);
		btnHuy.setIcon(new ImageIcon(GUITraxe.class
				.getResource("/Image/close1.png")));
		pnButton.add(btnHuy);
		tableTraxe
				.setModel(con
						.loadData("select nhanxe.Sove, nhanxe.BKS, xe.Loaixe, nhanxe.Loaive, nhanxe.Thoigianvao, nhanxe.Vitri from nhanxe, xe where (nhanxe.Trangthai = 'N') and (nhanxe.BKS = xe.BKS)"));
		setSizeColumn();

		showTongxe();
	}

	/**
	 * Đặt kích thước của bảng
	 */
	private void setSizeColumn() {
		tableTraxe.getColumnModel().getColumn(0).setPreferredWidth(50);
		tableTraxe.getColumnModel().getColumn(1).setPreferredWidth(80);
		tableTraxe.getColumnModel().getColumn(2).setPreferredWidth(70);
		tableTraxe.getColumnModel().getColumn(4).setPreferredWidth(90);
		tableTraxe.getColumnModel().getColumn(5).setPreferredWidth(65);
	}

	/**
	 * Hiện tổng số xe
	 */
	private void showTongxe() {
		lnSum.setText("Tổng số xe: " + con.TongXe());
	}

	/**
	 * Đưa ra giá vé
	 */
	private void setMoney() {
		if (TimeOut != null) {
			if (tfLoaiVe.getText().equals("Vé ngày")) {
				ResultSet rs1 = con
						.getData("select loaixe.Tien from nhanxe, loaixe,xe where (nhanxe.Sove = '"
								+ tfMaxe.getText()
								+ "') and (nhanxe.BKS = xe.BKS) and (xe.Loaixe = loaixe.Loaixe)");
				try {
					DateTimeFormatter formatter = DateTimeFormatter
							.ofPattern("yyyy-MM-dd");
					SimpleDateFormat fomat = new SimpleDateFormat("yyyy-MM-dd");
					String timeOut = fomat.format(TimeOut.getDate());
					LocalDate fomatTimeInt = LocalDate.parse(
							tfTimeIn.getText(), formatter);
					LocalDate fomatTimeOut = LocalDate
							.parse(timeOut, formatter);
					if (rs1.next()) {
						int tien = rs1.getInt("Tien");

						if (fomatTimeOut.compareTo(fomatTimeInt) > 0) {
							tfMoney.setText(String.valueOf(tien * 2));
						} else
							tfMoney.setText(String.valueOf(tien));

					}
				} catch (NumberFormatException | SQLException e1) {
					e1.printStackTrace();
				}
			} else
				tfMoney.setText("0");
		}
	}

	/**
	 * Đưa thông tin về xe từ database lên bảng
	 */
	private void showData() {
		int a = tableTraxe.getSelectedRow();
		if (a > -1) {
			String maxe = tableTraxe.getValueAt(a, 0).toString();
			String sql = "select  * from nhanxe,xe where Sove='" + maxe
					+ "' and nhanxe.BKS=xe.BKS";
			tfMaxe.setText(maxe);
			ResultSet rs = con.getData(sql);

			try {
				while (rs.next()) {
					String bks = rs.getString("BKS");
					String loaixe_db = rs.getString("Loaixe");
					String loaixe = Convert.DB_To_GUI(loaixe_db);
					String tgVao = rs.getString("Thoigianvao");
					String loaive = rs.getString("LoaiVe");
					String vitri = rs.getString("Vitri");
					tfBienso.setText(bks);
					tfLoaixe.setText(loaixe);
					tfTimeIn.setText(tgVao);
					tfLoaiVe.setText(loaive);
					tfVitri.setText(vitri);
					TimeOut.setDate(null);

				}
				rs.close();
			} catch (SQLException e) {
			}
		}
		showTongxe();
	}
}
