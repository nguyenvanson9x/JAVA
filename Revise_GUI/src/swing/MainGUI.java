package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class MainGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI frame = new MainGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public MainGUI() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
		setLocationRelativeTo(null);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAdminPage = new JMenu("Admin Page");
		mnAdminPage.setIcon(new ImageIcon(MainGUI.class.getResource("/javax/swing/plaf/metal/icons/Error.gif")));
		menuBar.add(mnAdminPage);
		
		JMenu mnNhnXe = new JMenu("Nhận xe");
		mnNhnXe.setIcon(new ImageIcon(MainGUI.class.getResource("/javax/swing/plaf/metal/icons/Inform.gif")));
		menuBar.add(mnNhnXe);
		
		JMenu mnTrXe = new JMenu("Trả xe");
		mnTrXe.setIcon(new ImageIcon(MainGUI.class.getResource("/javax/swing/plaf/metal/icons/Question.gif")));
		menuBar.add(mnTrXe);
		
		JMenu mnThngK = new JMenu("Thống kê");
		mnThngK.setIcon(new ImageIcon(MainGUI.class.getResource("/javax/swing/plaf/metal/icons/Warn.gif")));
		menuBar.add(mnThngK);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JDesktopPane admin_D = new JDesktopPane();
		tabbedPane.addTab("Admin Page", new ImageIcon(MainGUI.class.getResource("/javax/swing/plaf/metal/icons/Error.gif")), admin_D, null);
		tabbedPane.setEnabledAt(0, true);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.WHITE);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 629, 456);
		admin_D.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(5, 5, 531, 47);
		panel.add(panel_1);
		
		JLabel label = new JLabel("Admin Page");
		label.setForeground(Color.RED);
		label.setFont(new Font("Times New Roman", Font.BOLD, 40));
		label.setBounds(160, 0, 210, 47);
		panel_1.add(label);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(5, 62, 531, 231);
		panel.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setForeground(Color.BLACK);
		panel_3.setBorder(new TitledBorder(null, "Informations", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(0, 0, 321, 228);
		panel_2.add(panel_3);
		
		JLabel label_1 = new JLabel("ID");
		label_1.setBounds(26, 37, 102, 34);
		panel_3.add(label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(127, 37, 165, 34);
		panel_3.add(textField);
		
		JLabel label_2 = new JLabel("UserName");
		label_2.setBounds(26, 86, 102, 34);
		panel_3.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(127, 86, 165, 34);
		panel_3.add(textField_1);
		
		JLabel label_3 = new JLabel("Password");
		label_3.setBounds(26, 131, 102, 34);
		panel_3.add(label_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(127, 131, 165, 34);
		panel_3.add(passwordField);
		
		JLabel label_4 = new JLabel("Role");
		label_4.setBounds(26, 176, 102, 34);
		panel_3.add(label_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(127, 176, 165, 34);
		panel_3.add(comboBox);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new TitledBorder(null, "Operator", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(326, 0, 195, 228);
		panel_2.add(panel_4);
		
		JButton button = new JButton("Add");
		button.setBounds(38, 37, 126, 34);
		panel_4.add(button);
		
		JButton button_1 = new JButton("Update");
		button_1.setBounds(38, 86, 126, 34);
		panel_4.add(button_1);
		
		JButton button_2 = new JButton("Delete");
		button_2.setBounds(38, 131, 126, 34);
		panel_4.add(button_2);
		
		JButton button_3 = new JButton("Exit");
		button_3.setBounds(38, 176, 126, 34);
		panel_4.add(button_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 343, 531, 99);
		panel.add(scrollPane);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBounds(97, 304, 428, 28);
		panel.add(panel_5);
		
		JButton button_4 = new JButton("Search");
		button_4.setBounds(272, 0, 126, 23);
		panel_5.add(button_4);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(35, 1, 165, 22);
		panel_5.add(textField_2);
		
		JDesktopPane NhanXe_D = new JDesktopPane();
		tabbedPane.addTab("Nhận xe", new ImageIcon(MainGUI.class.getResource("/javax/swing/plaf/metal/icons/Inform.gif")), NhanXe_D, null);
		
		JDesktopPane TraXe = new JDesktopPane();
		tabbedPane.addTab("Trả Xe", new ImageIcon(MainGUI.class.getResource("/javax/swing/plaf/metal/icons/Question.gif")), TraXe, null);
		
		JDesktopPane ThongKe = new JDesktopPane();
		tabbedPane.addTab("Thống kê", new ImageIcon(MainGUI.class.getResource("/javax/swing/plaf/metal/icons/Warn.gif")), ThongKe, null);
	}

}
