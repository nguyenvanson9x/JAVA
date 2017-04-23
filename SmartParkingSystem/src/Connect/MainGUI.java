package Connect;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultDesktopManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EtchedBorder;

import Hethong.GUIHethong;
import Nhanxe.GUINhanxe;
import Nhanxe.NhanxeBussiness;
import Sodo.GUISodo;
import Thongke.GUIThongke;
import Traxe.GUITraxe;
import Trogiup.GUITrogiup;
import Vethang.GUIVethang;

/**
 * Giao diện chính của chương trình SmartParkingSystem
 * @author Nguyễn Văn Sơn
 *
 */
public class MainGUI extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JButton btnHeThong, btnQuanLyNhan, btnQuanLyTra, btnTicket, btnMap,
			btnThongKe, btnTroGiup, btnDangXuat, btnThoat;

	@SuppressWarnings("rawtypes")
	private JComboBox cbChooseGraphic;
	private JLabel lbLogo;

	private String a = "com.jtattoo.plaf.mint.MintLookAndFeel";

	private GUINhanxe nhanxe;
	private GUIHethong taikhoan;
	private GUITraxe traxe;
	private GUIThongke thongke;
	private GUITrogiup trogiup;
	private GUISodo sodo;
	private GUIVethang vethang;

	/**
	 * @return Lấy ra tên của giao diện
	 */
	public String getA() {
		return a;
	}

	/**
	 * @param a Đặt tên cho giao diện
	 */
	public void setA(String a) {
		this.a = a;
	}

	/**
	 * Hàm dựng của lớp MainGUI
	 */
	
	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public MainGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				MainGUI.class.getResource("/Image/shield-cross.png")));
		setFont(new Font("Arial", Font.BOLD, 16));
		setForeground(Color.BLACK);
		setTitle("Smart Parking System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 1340, 700);
		contentPane = new JPanel();
		setContentPane(contentPane);
		setLocationRelativeTo(null);

		JPanel pnInfor = new JPanel();

		JPanel pnButton = new JPanel();
		pnButton.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

		JPanel pnDesk = new JPanel();

		JLabel lblVersion = new JLabel("Version 1.5");
		lblVersion.setFont(new Font("Tahoma", Font.BOLD, 11));

		cbChooseGraphic = new JComboBox();
		cbChooseGraphic.setModel(new DefaultComboBoxModel(new String[] {
				"Lựa chọn giao diện", "HiFi", "Luna", "Mint", "Noire",
				"Graphite" }));

		cbChooseGraphic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String b = cbChooseGraphic.getSelectedItem().toString();

				if (b.equals("Luna")) {
					setA("com.jtattoo.plaf.luna.LunaLookAndFeel");
					cbChooseGraphic.setSelectedItem("Luna");
				} else if (b.equals("HiFi")) {
					setA("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
					cbChooseGraphic.setSelectedItem("HiFi");
				} else if (b.equals("Mint")) {
					setA("com.jtattoo.plaf.mint.MintLookAndFeel");
					cbChooseGraphic.setSelectedItem("Mint");
				} else if (b.equals("Noire")) {
					setA("com.jtattoo.plaf.noire.NoireLookAndFeel");
					cbChooseGraphic.setSelectedItem("Noire");
				} else if (b.equals("Graphite")) {
					setA("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
					cbChooseGraphic.setSelectedItem("Graphite");
				} else {
					setA("com.jtattoo.plaf.mint.MintLookAndFeel");
					cbChooseGraphic.setSelectedItem("Lựa chọn giao diện");
				}
				MainGUI.this.dispose();
				setSwing(getA());
				MainGUI.this.setVisible(true);

			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(pnButton, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
						.addComponent(pnInfor, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(20)
							.addComponent(lblVersion, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 647, Short.MAX_VALUE)
							.addComponent(cbChooseGraphic, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
							.addGap(47))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(pnDesk, GroupLayout.DEFAULT_SIZE, 1052, Short.MAX_VALUE)
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(pnInfor, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(pnButton, GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE))
						.addComponent(pnDesk, GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVersion, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbChooseGraphic, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		pnInfor.setLayout(new GridLayout(0, 1, 0, 0));

		lbLogo = new JLabel("");
		lbLogo.setIcon(new ImageIcon(MainGUI.class
				.getResource("/Image/logo.png")));
		pnInfor.add(lbLogo);
		pnDesk.setLayout(new BorderLayout(0, 0));

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);

		desktopPane.setDesktopManager(new NoDragDesktopManager());
		pnDesk.add(desktopPane, BorderLayout.CENTER);

		nhanxe = new GUINhanxe();
		traxe = new GUITraxe();
		taikhoan = new GUIHethong();
		sodo = new GUISodo();
		vethang = new GUIVethang();
		thongke = new GUIThongke();
		trogiup = new GUITrogiup();
		trogiup.setBounds(0, 0, 1065, 625);

		nhanxe.putClientProperty("dragMode", "fixed");
		desktopPane.add(nhanxe);
		nhanxe.show();
		NhanxeBussiness nhanxeBussiness = new NhanxeBussiness(nhanxe);

		desktopPane.add(traxe);
		desktopPane.add(taikhoan);
		desktopPane.add(sodo);
		desktopPane.add(vethang);
		desktopPane.add(thongke);
		desktopPane.add(trogiup);

		btnHeThong = new JButton("Hệ thống");
		btnHeThong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktopPane.remove(taikhoan);

				taikhoan = new GUIHethong();
				taikhoan.putClientProperty("dragMode", "fixed");
				desktopPane.add(taikhoan);
				taikhoan.show();
			}
		});
		btnHeThong.setHorizontalAlignment(SwingConstants.LEADING);
		btnHeThong.setIcon(new ImageIcon(MainGUI.class
				.getResource("/Image/settings.png")));

		btnQuanLyNhan = new JButton("Quản lý nhận xe");
		btnQuanLyNhan.setIcon(new ImageIcon(MainGUI.class
				.getResource("/Image/shopping-cart-remove.png")));
		btnQuanLyNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktopPane.remove(nhanxe);

				nhanxe = new GUINhanxe();
				nhanxe.putClientProperty("dragMode", "fixed");
				desktopPane.add(nhanxe);
				nhanxe.show();
				NhanxeBussiness nhanxeBussiness = new NhanxeBussiness(nhanxe);
			}
		});
		btnQuanLyNhan.setHorizontalAlignment(SwingConstants.LEADING);

		btnQuanLyTra = new JButton("Quản lý trả xe");
		btnQuanLyTra.setIcon(new ImageIcon(MainGUI.class
				.getResource("/Image/shopping-cart-add.png")));
		btnQuanLyTra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktopPane.remove(traxe);

				traxe = new GUITraxe();
				traxe.putClientProperty("dragMode", "fixed");
				desktopPane.add(traxe);
				traxe.show();
			}
		});
		btnQuanLyTra.setHorizontalAlignment(SwingConstants.LEADING);

		btnThongKe = new JButton("Thống kê");
		btnThongKe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktopPane.remove(thongke);

				thongke = new GUIThongke();
				thongke.putClientProperty("dragMode", "fixed");
				desktopPane.add(thongke);
				thongke.show();
			}
		});
		btnThongKe.setIcon(new ImageIcon(MainGUI.class
				.getResource("/Image/server.png")));
		btnThongKe.setHorizontalAlignment(SwingConstants.LEADING);

		btnTroGiup = new JButton("Trợ giúp");
		btnTroGiup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktopPane.remove(trogiup);

				trogiup = new GUITrogiup();
				trogiup.putClientProperty("dragMode", "fixed");
				desktopPane.add(trogiup);
				trogiup.show();
			}
		});
		btnTroGiup.setIcon(new ImageIcon(MainGUI.class
				.getResource("/Image/book.png")));
		btnTroGiup.setHorizontalAlignment(SwingConstants.LEADING);

		btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Login().setVisible(true);

			}
		});
		btnDangXuat.setIcon(new ImageIcon(MainGUI.class
				.getResource("/Image/refresh.png")));
		btnDangXuat.setHorizontalAlignment(SwingConstants.LEADING);

		btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null,
						"Bạn chắc muốn thoát ?", "Thông báo", 2);
				if (result == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		btnThoat.setIcon(new ImageIcon(MainGUI.class
				.getResource("/Image/bomb.png")));
		btnThoat.setHorizontalAlignment(SwingConstants.LEADING);

		btnTicket = new JButton("Quản lý vé tháng");
		btnTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktopPane.remove(vethang);

				vethang = new GUIVethang();
				vethang.putClientProperty("dragMode", "fixed");
				desktopPane.add(vethang);
				vethang.show();
			}
		});
		btnTicket.setIcon(new ImageIcon(MainGUI.class
				.getResource("/Image/script.png")));
		btnTicket.setHorizontalAlignment(SwingConstants.LEADING);

		btnMap = new JButton("Sơ đồ nhà xe");
		btnMap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktopPane.remove(sodo);

				sodo = new GUISodo();
				sodo.putClientProperty("dragMode", "fixed");
				desktopPane.add(sodo);
				sodo.show();
			}
		});
		btnMap.setIcon(new ImageIcon(MainGUI.class
				.getResource("/Image/coffee-machine.png")));
		btnMap.setHorizontalAlignment(SwingConstants.LEADING);
		GroupLayout gl_pnButton = new GroupLayout(pnButton);
		gl_pnButton
				.setHorizontalGroup(gl_pnButton
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_pnButton
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_pnButton
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_pnButton
																		.createSequentialGroup()
																		.addGroup(
																				gl_pnButton
																						.createParallelGroup(
																								Alignment.TRAILING)
																						.addComponent(
																								btnQuanLyNhan,
																								GroupLayout.PREFERRED_SIZE,
																								223,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								btnQuanLyTra,
																								GroupLayout.PREFERRED_SIZE,
																								223,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								btnHeThong,
																								GroupLayout.PREFERRED_SIZE,
																								211,
																								GroupLayout.PREFERRED_SIZE))
																		.addContainerGap(
																				15,
																				Short.MAX_VALUE))
														.addGroup(
																gl_pnButton
																		.createSequentialGroup()
																		.addComponent(
																				btnMap,
																				GroupLayout.PREFERRED_SIZE,
																				223,
																				GroupLayout.PREFERRED_SIZE)
																		.addContainerGap(
																				15,
																				Short.MAX_VALUE))
														.addGroup(
																gl_pnButton
																		.createSequentialGroup()
																		.addComponent(
																				btnTicket,
																				GroupLayout.PREFERRED_SIZE,
																				223,
																				GroupLayout.PREFERRED_SIZE)
																		.addContainerGap(
																				15,
																				Short.MAX_VALUE))
														.addGroup(
																gl_pnButton
																		.createSequentialGroup()
																		.addComponent(
																				btnThongKe,
																				GroupLayout.PREFERRED_SIZE,
																				223,
																				GroupLayout.PREFERRED_SIZE)
																		.addContainerGap(
																				15,
																				Short.MAX_VALUE))
														.addGroup(
																gl_pnButton
																		.createSequentialGroup()
																		.addGroup(
																				gl_pnButton
																						.createParallelGroup(
																								Alignment.TRAILING,
																								false)
																						.addGroup(
																								gl_pnButton
																										.createSequentialGroup()
																										.addComponent(
																												btnDangXuat,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												Short.MAX_VALUE)
																										.addPreferredGap(
																												ComponentPlacement.RELATED)
																										.addComponent(
																												btnThoat,
																												GroupLayout.PREFERRED_SIZE,
																												95,
																												GroupLayout.PREFERRED_SIZE))
																						.addComponent(
																								btnTroGiup,
																								Alignment.LEADING,
																								GroupLayout.PREFERRED_SIZE,
																								223,
																								GroupLayout.PREFERRED_SIZE))
																		.addContainerGap(
																				15,
																				Short.MAX_VALUE)))));
		gl_pnButton
				.setVerticalGroup(gl_pnButton
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_pnButton
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(btnHeThong,
												GroupLayout.PREFERRED_SIZE, 46,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addComponent(btnQuanLyNhan,
												GroupLayout.PREFERRED_SIZE, 46,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addComponent(btnQuanLyTra,
												GroupLayout.PREFERRED_SIZE, 46,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addComponent(btnTicket,
												GroupLayout.PREFERRED_SIZE, 46,
												GroupLayout.PREFERRED_SIZE)
										.addGap(11)
										.addComponent(btnMap,
												GroupLayout.PREFERRED_SIZE, 46,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addComponent(btnThongKe,
												GroupLayout.PREFERRED_SIZE, 46,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addComponent(btnTroGiup,
												GroupLayout.PREFERRED_SIZE, 46,
												GroupLayout.PREFERRED_SIZE)
										.addGap(11)
										.addGroup(
												gl_pnButton
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																btnDangXuat,
																GroupLayout.PREFERRED_SIZE,
																46,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																btnThoat,
																GroupLayout.PREFERRED_SIZE,
																46,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap()));
		gl_pnButton.linkSize(SwingConstants.HORIZONTAL, new Component[] {
				btnHeThong, btnQuanLyNhan });
		pnButton.setLayout(gl_pnButton);
		contentPane.setLayout(gl_contentPane);

	}

	/**
	 * Đặt giao diện cho hệ thống
	 * @param a Tên của LookAndFeel
	 */
	public void setSwing(String a) {
		try {
			UIManager.setLookAndFeel(a);
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return Lấy ra nút Quản lý hệ thống
	 */
	public JButton getBtnHeThong() {
		return btnHeThong;
	}

	/**
	 * Khóa di chuyển JInternal Frame
	 * @author Nguyễn Văn Sơn
	 *
	 */
	class NoDragDesktopManager extends DefaultDesktopManager {

		private static final long serialVersionUID = 1L;

		public void beginDraggingFrame(JComponent f) {
			if (!"fixed".equals(f.getClientProperty("dragMode")))
				super.beginDraggingFrame(f);
		}

		public void dragFrame(JComponent f, int newX, int newY) {
			if (!"fixed".equals(f.getClientProperty("dragMode")))
				super.dragFrame(f, newX, newY);
		}

		public void endDraggingFrame(JComponent f) {
			if (!"fixed".equals(f.getClientProperty("dragMode")))
				super.endDraggingFrame(f);
		}
	}
}
