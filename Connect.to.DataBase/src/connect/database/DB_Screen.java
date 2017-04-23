package connect.database;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

public class DB_Screen extends JFrame {

	private static final long serialVersionUID = 1L;

	private JTable table;
	private DB_Action model = new DB_Action();

	private connect myConnect = new connect();

	public DB_Screen() {
		myConnect.myconnect();
		getContentPane().add(mainPanel());
		pack();
		displayFrame();

	}

	private JPanel mainPanel() {
		JPanel pnBorder = new JPanel(new BorderLayout());
		pnBorder.add(titlePanel(), BorderLayout.NORTH);
		pnBorder.add(tablePanel(), BorderLayout.CENTER);
		pnBorder.add(buttonPanel(), BorderLayout.SOUTH);

		return pnBorder;
	}

	private JPanel titlePanel() {
		JPanel panel = new JPanel();
		JLabel title = new JLabel("Database Connection");
		title.setForeground(Color.RED);
		title.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel.add(title);
		return panel;
	}

	private JPanel tablePanel() {
		JPanel panel = new JPanel(new BorderLayout());
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table = creatTable());

		scrollPane.setViewportBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.RED));

		panel.add(scrollPane, BorderLayout.CENTER);
		return panel;
	}

	private JPanel buttonPanel() {
		JPanel panel = new JPanel(new GridLayout(1, 3, 5, 5));
		panel.setBorder(new EmptyBorder(5, 50, 10, 50));
		panel.add(creatButton("Add"));
		panel.add(creatButton("Delete"));
		panel.add(creatButton("Update"));
		return panel;
	}

	public JButton creatButton(String text) {
		JButton btn = new JButton(text);
		btn.addActionListener(model.actionListener());
		return btn;
	}

	public JTable creatTable() {

		table = new JTable();
		table.setFillsViewportHeight(true);

		return table;
	}

	public void updateTable(DefaultTableModel model) {
		table.setModel(model);
	}

	private void displayFrame() {
		setTitle("Main Screen");
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public void loadData() {
		DefaultTableModel model = new DefaultTableModel();
		ResultSet rs = myConnect.getData();
		try {
			ResultSetMetaData rsMD = rs.getMetaData();
			int colNumber = rsMD.getColumnCount();

			String[] arr = new String[colNumber];
			for (int i = 0; i < colNumber; i++) {
				arr[i] = rsMD.getColumnName(i + 1);
			}
			model.setColumnIdentifiers(arr);

			while (rs.next()) {
				for (int i = 0; i < colNumber; i++) {
					arr[i] = rs.getString(i + 1);
				}
				model.addRow(arr);
			}
		} catch (SQLException e) {

		}
		table.setModel(model);

	}
	

}
