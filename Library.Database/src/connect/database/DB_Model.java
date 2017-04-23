package connect.database;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DB_Model {
	private connect myConnect = new connect();
	private DefaultTableModel model;
	private String[] arr;

	public DefaultTableModel loadData() {
		model = new DefaultTableModel();
		ResultSet rs = myConnect.getData();
		try {
			ResultSetMetaData rsMD = rs.getMetaData();
			int colNumber = rsMD.getColumnCount();

			arr = new String[colNumber];
			for (int i = 0; i < colNumber; i++) {
				arr[i] = rsMD.getColumnName(i + 1);
			}

		} catch (SQLException e) {

		}
		model.setColumnIdentifiers(arr);
		
		return model;

	}

	public DefaultTableModel getModel() {

		return model;
	}

	public ActionListener actionListener() {
		ActionListener ac = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object o = e.getActionCommand();
				if (o.equals("Add")) {
					JOptionPane.showMessageDialog(null, "Add");
				}
				if (o.equals("Delete")) {
					JOptionPane.showMessageDialog(null, "Delete");
				}
				if (o.equals("Update")) {
					JOptionPane.showMessageDialog(null, "Update");
				}

			}
		};
		return ac;
	}

}
