package connect.database;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class LoginScreen extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnBorder, pnCenter, pnButton, pnLable, pnTxt;
	private final JLabel lbUser = new JLabel("Tài khoản");
	private final JLabel lbPass = new JLabel("Mật khẩu");

	private final JTextField txtUser = new JTextField(20);
	private final JPasswordField pfPass = new JPasswordField();

	private final JButton btnLogin = new JButton("Đăng nhập");
	private final JButton btnCancel = new JButton("Thoát");

	private connect myConnect = new connect();

	public LoginScreen() {
	
		setAlwaysOnTop(true);
		creatFrame();
		addContent();
		this.getRootPane().setDefaultButton(btnLogin);
	}

	private void addContent() {
		pnBorder = new JPanel(new BorderLayout());

		pnLable = new JPanel(new GridLayout(2, 1));
		lbUser.setFont(lbUser.getFont().deriveFont(lbUser.getFont().getStyle() | Font.BOLD));
		pnLable.add(lbUser);
		lbPass.setFont(lbUser.getFont().deriveFont(lbUser.getFont().getStyle() | Font.BOLD));
		pnLable.add(lbPass);

		pnTxt = new JPanel(new GridLayout(2, 1));

		txtUser.setToolTipText("");
		pnTxt.add(txtUser);

		pnTxt.add(pfPass);

		pnCenter = new JPanel();
		pnCenter.add(pnLable);
		pnCenter.add(pnTxt);

		pnButton = new JPanel();
		btnLogin.setFont(lbUser.getFont().deriveFont(lbUser.getFont().getStyle() | Font.BOLD));
		pnButton.add(btnLogin);
		btnCancel.setFont(lbUser.getFont().deriveFont(lbUser.getFont().getStyle() | Font.BOLD));
		pnButton.add(btnCancel);

		pnBorder.add(pnButton, BorderLayout.SOUTH);
		pnBorder.add(pnCenter, BorderLayout.CENTER);

		Container con = getContentPane();
		con.add(pnBorder);
		pack();

		btnLogin.addActionListener(new btnLoginActionListener());
		btnCancel.addActionListener(new btnCancelActionListener());
	}

	class btnLoginActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (Arrays.equals(myConnect.getPass().toCharArray(), pfPass.getPassword())
					&& myConnect.getUser().equals(txtUser.getText())) {
				myConnect.myconnect();
				setVisible(false);
				DB_Screen mainscreen = new DB_Screen();
				mainscreen.loadData();
				mainscreen.setVisible(true);

			} else {
				JOptionPane.showMessageDialog(pnBorder, "Sai tên đăng nhập hoặc mật khẩu", "Thông báo", 1);
				txtUser.requestFocus();
				txtUser.selectAll();
				pfPass.selectAll();

			}

		}

	}

	class btnCancelActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			//setVisible(false);
			System.exit(0);

		}

	}

	private void creatFrame() {
		setTitle("Đăng nhập vào hệ thống");
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

	}

}
