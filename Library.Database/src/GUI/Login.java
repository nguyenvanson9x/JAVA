package GUI;

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

import connect.database.connect;

public class Login extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnBorder, pnCenter, pnButton, pnLable, pnTxt;
	private final JLabel lbUser = new JLabel("Username");
	private final JLabel lbPass = new JLabel("Password");

	private final JTextField txtUser = new JTextField(20);
	private final JPasswordField pfPass = new JPasswordField();

	private final JButton btnLogin = new JButton("Đăng nhập");
	private final JButton btnRetype = new JButton("Nhập lại");
	private final JButton btnCancel = new JButton("Thoát");

	private connect myConnect = new connect();
	private MainScreen mainscreen;

	public Login(MainScreen mainscreen) {
		this.mainscreen = mainscreen;
		//setAlwaysOnTop(true);
		creatFrame();
		addContent();

	}

	private void addContent() {
		pnBorder = new JPanel(new BorderLayout());

		pnLable = new JPanel(new GridLayout(2, 1));
		lbUser.setFont(lbUser.getFont().deriveFont(lbUser.getFont().getStyle() | Font.BOLD));
		pnLable.add(lbUser);
		lbPass.setFont(lbUser.getFont().deriveFont(lbUser.getFont().getStyle() | Font.BOLD));
		pnLable.add(lbPass);

		pnTxt = new JPanel(new GridLayout(2, 1));
		pnTxt.add(txtUser);
		pnTxt.add(pfPass);

		pnCenter = new JPanel();
		pnCenter.add(pnLable);
		pnCenter.add(pnTxt);

		pnButton = new JPanel();
		btnLogin.setFont(lbUser.getFont().deriveFont(lbUser.getFont().getStyle() | Font.BOLD));
		pnButton.add(btnLogin);
		btnRetype.setFont(lbUser.getFont().deriveFont(lbUser.getFont().getStyle() | Font.BOLD));
		pnButton.add(btnRetype);
		btnCancel.setFont(lbUser.getFont().deriveFont(lbUser.getFont().getStyle() | Font.BOLD));
		pnButton.add(btnCancel);

		pnBorder.add(pnButton, BorderLayout.SOUTH);
		pnBorder.add(pnCenter, BorderLayout.CENTER);

		Container con = getContentPane();
		con.add(pnBorder);
		pack();

		btnLogin.addActionListener(new btnLoginActionListener());
		btnCancel.addActionListener(new btnCancelActionListener());
		btnRetype.addActionListener(new btnRetypeActionListener());
		
	}

	class btnLoginActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (Arrays.equals(myConnect.getPass().toCharArray(), pfPass.getPassword())
					&& myConnect.getUser().equals(txtUser.getText())) {
				myConnect.myconnect();
				setVisible(false);
				mainscreen.setVisible(true);
				//mainscreen.loadData();

			} else {
				JOptionPane.showMessageDialog(pnBorder, "Sai thông tin đăng nhập", "Thông báo", 2);
				txtUser.selectAll();
				txtUser.requestFocus();
				
			}

		}

	}

	class btnCancelActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			setVisible(false);
			System.exit(0);

		}

	}
	
	class btnRetypeActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			txtUser.setText("");
			pfPass.setText("");
		}
		
	}

	private void creatFrame() {
		setTitle("Đăng nhập");
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

	}

}
