package Student;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class StudentView extends JFrame {
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public StudentView() {
		getContentPane().setLayout(new GridLayout(5, 1, 5, 5));

		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Ten");
		lblNewLabel.setBounds(43, 14, 30, 14);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(132, 11, 304, 20);
		panel.add(textField);
		textField.setColumns(10);


		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblLop = new JLabel("Lop");
		lblLop.setBounds(43, 23, 46, 14);
		panel_1.add(lblLop);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(132, 20, 304, 20);
		panel_1.add(comboBox);

		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblGioiTinh = new JLabel("Gioi tinh");
		lblGioiTinh.setBounds(43, 23, 46, 14);
		panel_2.add(lblGioiTinh);
		
		JRadioButton rdbtnNam = new JRadioButton("Nam");
		buttonGroup.add(rdbtnNam);
		rdbtnNam.setBounds(132, 12, 57, 23);
		panel_2.add(rdbtnNam);
		
		JRadioButton rdbtnNu = new JRadioButton("Nu");
		buttonGroup.add(rdbtnNu);
		rdbtnNu.setBounds(232, 12, 57, 23);
		panel_2.add(rdbtnNu);
		
		JRadioButton rdbtnKhac = new JRadioButton("Khac");
		buttonGroup.add(rdbtnKhac);
		rdbtnKhac.setBounds(332, 12, 57, 23);
		panel_2.add(rdbtnKhac);

		JPanel panel_3 = new JPanel();
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblSoThich = new JLabel("So thich");
		lblSoThich.setBounds(43, 23, 46, 14);
		panel_3.add(lblSoThich);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Am nhac");
		chckbxNewCheckBox.setBounds(132, 19, 97, 23);
		panel_3.add(chckbxNewCheckBox);
		
		JCheckBox chckbxTheThao = new JCheckBox("The Thao");
		chckbxTheThao.setBounds(232, 19, 97, 23);
		panel_3.add(chckbxTheThao);
		
		JCheckBox chckbxNgheThuat = new JCheckBox("Nghe thuat");
		chckbxNgheThuat.setBounds(332, 19, 97, 23);
		panel_3.add(chckbxNgheThuat);

		JPanel panel_4 = new JPanel();
		getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBounds(41, 5, 89, 23);
		panel_4.add(btnNewButton);
		
		JLabel label = new JLabel("");
		label.setBounds(158, 16, 0, 0);
		panel_4.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(163, 16, 0, 0);
		panel_4.add(label_1);
		
		JButton btnHuy = new JButton("Canced");
		btnHuy.setBounds(171, 5, 89, 23);
		panel_4.add(btnHuy);
		
		JButton btnListStudent = new JButton("List Student");
		btnListStudent.setBounds(301, 5, 123, 23);
		panel_4.add(btnListStudent);
	}

public static void main(String[] args) {
	StudentView show = new StudentView();
	show.setVisible(true);
	show.setSize(500,300);
}
}
