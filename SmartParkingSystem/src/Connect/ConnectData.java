package Connect;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Color;

/**
 * Giao diện đăng nhập vào Database
 * @author Nguyễn Văn Sơn
 *
 */
public class ConnectData extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel pnLogo, pnTitle, pnProcess;

	private JButton btnConnect, btnImport, btnExit;

	private JLabel lbLogo1, lbTitle, lbUser, lbPass, lbLogo2, lbDB, lbPort;

	private JTextField tfDB, tfPort, tfHost, tfUser;

	private JPasswordField pfPass;

	private String host, port, db_name, user, pass;

	/**
	 * Hàm dựng của lớp ConnectData
	 */
	public ConnectData() {

		initComponents();
		this.getRootPane().setDefaultButton(btnConnect);
		this.setLocationRelativeTo(null);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(
				ConnectData.class.getResource("/Image/data.png")));
	}

	/**
	 * Thêm các thành phần cho giao diện
	 */
	private void initComponents() {

		pnLogo = new JPanel();
		lbLogo1 = new JLabel();
		pnTitle = new JPanel();
		lbTitle = new JLabel();
		pnProcess = new JPanel();
		lbUser = new JLabel();
		lbPass = new JLabel();
		lbLogo2 = new JLabel();
		pfPass = new JPasswordField();
		btnConnect = new JButton();
		btnConnect.setHorizontalAlignment(SwingConstants.LEADING);
		btnExit = new JButton();
		btnExit.setHorizontalAlignment(SwingConstants.LEADING);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setBackground(Color.WHITE);
		setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		setResizable(false);

		pnLogo.setBackground(new java.awt.Color(21, 139, 46));
		pnLogo.setBorder(javax.swing.BorderFactory
				.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

		lbLogo1.setBackground(new java.awt.Color(19, 172, 65));
		lbLogo1.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/Image/data.png")));

		javax.swing.GroupLayout gl_pnLogo = new javax.swing.GroupLayout(pnLogo);
		pnLogo.setLayout(gl_pnLogo);
		gl_pnLogo.setHorizontalGroup(gl_pnLogo.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				gl_pnLogo
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(lbLogo1)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));
		gl_pnLogo.setVerticalGroup(gl_pnLogo.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				gl_pnLogo
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(lbLogo1)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));

		pnTitle.setBackground(new java.awt.Color(49, 122, 233));
		pnTitle.setBorder(javax.swing.BorderFactory
				.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

		lbTitle.setBackground(new java.awt.Color(255, 255, 255));
		lbTitle.setFont(new java.awt.Font("Tahoma", 1, 24));
		lbTitle.setForeground(new java.awt.Color(255, 255, 255));
		lbTitle.setText("KẾT NỐI CƠ SỞ DỮ LIỆU");

		javax.swing.GroupLayout gl_pnTitle = new javax.swing.GroupLayout(
				pnTitle);
		pnTitle.setLayout(gl_pnTitle);
		gl_pnTitle.setHorizontalGroup(gl_pnTitle.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				gl_pnTitle
						.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(lbTitle,
								javax.swing.GroupLayout.PREFERRED_SIZE, 372,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		gl_pnTitle.setVerticalGroup(gl_pnTitle.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				gl_pnTitle
						.createSequentialGroup()
						.addGap(20, 20, 20)
						.addComponent(lbTitle)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));

		pnProcess.setBackground(Color.LIGHT_GRAY);
		pnProcess.setBorder(javax.swing.BorderFactory
				.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

		lbUser.setText("Tên đăng nhập:");

		lbPass.setText("Mật khẩu:");

		lbLogo2.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/Image/login1.png")));
		btnConnect.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/Image/refresh.png")));
		btnConnect.setText("Kết nối");
		btnConnect.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonDangNhapActionPerformed(evt);
			}
		});

		btnExit.setIcon(new ImageIcon(ConnectData.class.getResource("/Image/close1.png")));
		btnExit.setText("Thoát");
		btnExit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonThoatActionPerformed(evt);
			}
		});

		lbDB = new JLabel("Database Name:");

		tfDB = new JTextField();
		tfDB.setText("sps");
		tfDB.setColumns(10);

		JLabel lblHost = new JLabel("Host:");

		tfHost = new JTextField();
		tfHost.setText("localhost");
		tfHost.setColumns(10);

		btnImport = new JButton("Nhập cấu hình");
		btnImport.setHorizontalAlignment(SwingConstants.LEADING);
		btnImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnImportActionPerformed(arg0);
			}
		});
		btnImport.setIcon(new ImageIcon(ConnectData.class.getResource("/Image/list.png")));

		tfPort = new JTextField();
		tfPort.setText("3306");
		tfPort.setColumns(10);

		lbPort = new JLabel("Port:");

		tfUser = new JTextField();
		tfUser.setText("root");
		tfUser.setColumns(10);
		javax.swing.GroupLayout gl_pnProcess = new javax.swing.GroupLayout(
				pnProcess);
		gl_pnProcess.setHorizontalGroup(
			gl_pnProcess.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnProcess.createSequentialGroup()
					.addContainerGap()
					.addComponent(lbLogo2)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pnProcess.createParallelGroup(Alignment.TRAILING)
						.addComponent(lbUser)
						.addComponent(lbPass)
						.addComponent(lbDB)
						.addComponent(lblHost)
						.addComponent(lbPort))
					.addGap(40)
					.addGroup(gl_pnProcess.createParallelGroup(Alignment.LEADING)
						.addComponent(tfUser, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnProcess.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(tfHost)
							.addComponent(tfDB, Alignment.LEADING)
							.addComponent(pfPass, Alignment.LEADING)
							.addComponent(tfPort, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)))
					.addGap(18)
					.addGroup(gl_pnProcess.createParallelGroup(Alignment.LEADING)
						.addComponent(btnImport, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnConnect, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
						.addComponent(btnExit, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_pnProcess.setVerticalGroup(
			gl_pnProcess.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnProcess.createSequentialGroup()
					.addContainerGap(21, Short.MAX_VALUE)
					.addGroup(gl_pnProcess.createParallelGroup(Alignment.LEADING)
						.addComponent(lbLogo2)
						.addGroup(gl_pnProcess.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_pnProcess.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_pnProcess.createSequentialGroup()
									.addGroup(gl_pnProcess.createParallelGroup(Alignment.BASELINE)
										.addComponent(tfHost, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblHost))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_pnProcess.createParallelGroup(Alignment.BASELINE)
										.addComponent(tfPort, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lbPort)))
								.addComponent(btnConnect))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_pnProcess.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnProcess.createParallelGroup(Alignment.BASELINE)
									.addComponent(lbDB)
									.addComponent(tfDB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnImport, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))))
					.addGap(5)
					.addGroup(gl_pnProcess.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbUser)
						.addComponent(btnExit)
						.addComponent(tfUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pnProcess.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbPass)
						.addComponent(pfPass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26))
		);
		gl_pnProcess.linkSize(SwingConstants.VERTICAL, new Component[] {btnConnect, btnExit, btnImport});
		pnProcess.setLayout(gl_pnProcess);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		layout.setHorizontalGroup(layout
				.createParallelGroup(Alignment.TRAILING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												Alignment.TRAILING)
												.addComponent(
														pnProcess,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		pnLogo,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		ComponentPlacement.RELATED)
																.addComponent(
																		pnTitle,
																		GroupLayout.DEFAULT_SIZE,
																		449,
																		Short.MAX_VALUE)))
								.addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												Alignment.LEADING, false)
												.addComponent(
														pnTitle,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(
														pnLogo,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(pnProcess,
										GroupLayout.PREFERRED_SIZE, 208,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)));
		getContentPane().setLayout(layout);

		pack();

	}

	/**
	 * Xử lý xự kiện cho nút Kết Nối: Kết nối vào DB
	 * @param evt Đối số
	 */
	private void jButtonDangNhapActionPerformed(java.awt.event.ActionEvent evt) {
		upToConnect();
		if (connect.checkConnect()) {
			new Login().setVisible(true);
			dispose();
		} else
			JOptionPane.showMessageDialog(this, "Lỗi đăng nhập CSDL",
					"Lỗi đăng nhập", JOptionPane.ERROR_MESSAGE);
		pfPass.requestFocus();
		pfPass.selectAll();
	}

	/**
	 * Xử lý sự kiện cho nút Thoát: Thoát chương trình
	 * @param evt Đối số
	 */
	private void jButtonThoatActionPerformed(java.awt.event.ActionEvent evt) {

		System.exit(0);
	}

	/**
	 * Xử lý sự kiện cho nút Nhập cấu hình: Nhập cấu hình để đăng nhập vào DB
	 * @param evt Đối số
	 */
	private void btnImportActionPerformed(ActionEvent evt) {
		Properties p = new Properties();
		JFileChooser chooser = new JFileChooser(".");
		FileNameExtensionFilter loc = new FileNameExtensionFilter("Config",
				"cfg");
		chooser.setFileFilter(loc);
		File file = null;

		int choose = chooser.showOpenDialog(null);
		if (choose == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
			try {
				p.load(new FileInputStream(file));
				host = p.getProperty("host");
				port = p.getProperty("port");
				db_name = p.getProperty("db_name");
				user = p.getProperty("user");

				inputInfor(host, port, db_name, user);
				upToConnect();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Error loading file");
			}
		}

	}

	/**
	 * Truyền thông tin đăng nhập từ tệp cấu hình lên giao diện
	 * @param host Tên máy chủ
	 * @param port Cổng kết nối
	 * @param db_name Tên Database
	 * @param user Tên đăng nhập vào Database
	 */
	private void inputInfor(String host, String port, String db_name,
			String user) {
		tfHost.setText(host);
		tfPort.setText(port);
		tfDB.setText(db_name);
		tfUser.setText(user);

	}

	/**
	 * Chuyển thông tin đăng nhập từ giao diện vào đối tượng connect
	 */
	private void upToConnect() {
		host = tfHost.getText();
		port = tfPort.getText();
		db_name = tfDB.getText();
		user = tfUser.getText();
		pass = String.valueOf(pfPass.getPassword());

		connect.setHost(host);
		connect.setPort(port);
		connect.setDbName(db_name);
		connect.setUser(user);
		connect.setPass(pass);

	}

	
	public static void main(String args[]) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new ConnectData()

				.setVisible(true);
			}
		});
	}

}
