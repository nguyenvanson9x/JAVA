package Connect;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Giao diện đăng nhập vào hệ thống
 * 
 * @author Nguyễn Văn Sơn
 *
 */
public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField tfUsername;
	private JPasswordField pfPassword;
	private JButton bDangNhap;

	/**
	 * Hàm dựng của lớp Login
	 */
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Image/log_in.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(552, 404);
		getContentPane().setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);

		JLabel lbbg = new JLabel();
		lbbg.setIcon(new ImageIcon(Login.class.getResource("/Image/login_e.jpg")));
		lbbg.setBounds(-10, 0, 556, 381);
		getContentPane().add(lbbg);

		bDangNhap = new JButton();
		bDangNhap.setBounds(163, 267, 239, 43);
		bDangNhap.setBorder(BorderFactory.createEmptyBorder());
		bDangNhap.setContentAreaFilled(false);
		bDangNhap.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbbg.add(bDangNhap);
		this.getRootPane().setDefaultButton(bDangNhap);

		tfUsername = new JTextField();
		tfUsername.setColumns(20);
		lbbg.add(tfUsername);
		tfUsername.setBounds(280, 162, 115, 20);
		tfUsername.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

		pfPassword = new JPasswordField();
		pfPassword.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		pfPassword.setColumns(20);
		lbbg.add(pfPassword);
		pfPassword.setBounds(280, 201, 115, 20);

		bDangNhap.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				connect conn = connect.getInstance();
				if (tfUsername.getText().equals("")) {
					if (new String(pfPassword.getPassword()).equals("")) {
						JOptionPane.showMessageDialog(null, "Bạn chưa nhập tên đăng nhập và mật khẩu", "Invalid",
								JOptionPane.ERROR_MESSAGE);
						tfUsername.requestFocus();
					} else {
						JOptionPane.showMessageDialog(null, "Bạn chưa nhập tên đăng nhập", "Invalid",
								JOptionPane.ERROR_MESSAGE);
						tfUsername.requestFocus();
					}
				} else if (new String(pfPassword.getPassword()).equals("")) {
					JOptionPane.showMessageDialog(null, "Bạn chưa nhập mật khẩu", "Invalid", JOptionPane.ERROR_MESSAGE);
					pfPassword.requestFocus();
				} else {
					try {

						Statement statement = conn.getConnection().createStatement();
						String sql = String.format(
								"SELECT USERNAME,PASSWORD,CHUCVU FROM TAIKHOAN WHERE USERNAME = '%s' AND PASSWORD = '%s'",
								tfUsername.getText(), new String(pfPassword.getPassword()));
						ResultSet rs = statement.executeQuery(sql);
						if (rs != null) {
							if (rs.next()) {
								if (tfUsername.getText().equals(rs.getString("USERNAME"))
										&& pfPassword.getPassword().equals(rs.getString("PASSWORD"))) {
									MainGUI menu = new MainGUI();
									dispose();
									menu.setVisible(true);

									String chucvu = rs.getString("CHUCVU");
									switch (chucvu) {
									case "Quan ly":
										menu.getBtnHeThong().setEnabled(true);
										break;
									case "Nhan vien":
										menu.getBtnHeThong().setEnabled(false);
										break;
									default:
										break;
									}

								}
							} else {
								JOptionPane.showMessageDialog(null, "Tên đăng nhập hoặc mật khẩu không đúng",
										"Login failed", JOptionPane.ERROR_MESSAGE);
								tfUsername.requestFocus();
								tfUsername.selectAll();
								pfPassword.selectAll();
							}
							statement.close();

						}
					} catch (Exception e) {
					}
				}
			}
		});
	}

}
