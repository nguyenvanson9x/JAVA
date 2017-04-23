package swing;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class AdminPage extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtUsername;
	private JPasswordField passwordField;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPage frame = new AdminPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555,495);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnTitle = new JPanel();
		pnTitle.setBounds(5, 5, 531, 47);
		contentPane.add(pnTitle);
		pnTitle.setLayout(null);
		
		JLabel lbAdmin = new JLabel("Admin Page");
		lbAdmin.setBounds(160, 0, 210, 47);
		lbAdmin.setForeground(Color.RED);
		lbAdmin.setFont(new Font("Times New Roman", Font.BOLD, 40));
		pnTitle.add(lbAdmin);
		
		JPanel pnCenter = new JPanel();
		pnCenter.setBounds(5, 62, 531, 231);
		contentPane.add(pnCenter);
		pnCenter.setLayout(null);
		
		JPanel pnInfor = new JPanel();
		pnInfor.setForeground(Color.BLACK);
		pnInfor.setBorder(new TitledBorder(null, "Informations", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnInfor.setBounds(0, 0, 321, 228);
		pnCenter.add(pnInfor);
		pnInfor.setLayout(null);
		
		JLabel lbID = new JLabel("ID");
		lbID.setBounds(26, 37, 102, 34);
		pnInfor.add(lbID);
		
		txtID = new JTextField();
		txtID.setBounds(127, 37, 165, 34);
		pnInfor.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setBounds(26, 86, 102, 34);
		pnInfor.add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(127, 86, 165, 34);
		pnInfor.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(26, 131, 102, 34);
		pnInfor.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(127, 131, 165, 34);
		pnInfor.add(passwordField);
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setBounds(26, 176, 102, 34);
		pnInfor.add(lblRole);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Guest"}));
		comboBox.setBounds(127, 176, 165, 34);
		pnInfor.add(comboBox);
		
		JPanel pnTool = new JPanel();
		pnTool.setBorder(new TitledBorder(null, "Operator", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnTool.setBounds(326, 0, 195, 228);
		pnCenter.add(pnTool);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(38, 37, 126, 34);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(38, 86, 126, 34);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(38, 131, 126, 34);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(38, 176, 126, 34);
		pnTool.setLayout(null);
		pnTool.add(btnAdd);
		pnTool.add(btnUpdate);
		pnTool.add(btnDelete);
		pnTool.add(btnExit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 343, 531, 99);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBounds(97, 304, 428, 28);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(272, 0, 126, 23);
		panel.add(btnSearch);
		
		textField = new JTextField();
		textField.setBounds(35, 1, 165, 22);
		panel.add(textField);
		textField.setColumns(10);
	}
}
