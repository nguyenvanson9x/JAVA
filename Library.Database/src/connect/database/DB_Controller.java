package connect.database;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.Main;

public class DB_Controller {
	private Main screen;
	private DB_Model model;

	public DB_Controller(Main screen, DB_Model model) {
		this.model = model;
		this.screen = screen;
	}

	class btnAddActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

	class btnDeleteActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

	class btnUpdateActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}
}
