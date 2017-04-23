package connect.database;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class DB_Action {


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
