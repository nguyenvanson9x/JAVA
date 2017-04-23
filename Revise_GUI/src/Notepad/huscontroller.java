package Notepad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class huscontroller {
	private husmodel model;
	private husview view;

	private static final int FILE_OPEN = 1;
	private static final int FILE_SAVE = 2;

	public huscontroller(husview view, husmodel model) {
		this.model = model;
		this.view = view;

		action ac = new action();
		view.getMntmNew().addActionListener(ac);
		view.getMntmOpen().addActionListener(ac);
		view.getMntmSave().addActionListener(ac);
		view.getMntmExit().addActionListener(ac);
	}

	class action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String s = e.getActionCommand();
			if (s == "New") {
				view.setTextArea("");
			}
			if (s == "Open") {
				view.setTextArea("");
				operateFile("Open a file", 1);
			}

			if (s == "Save") {
				operateFile("Save the file", 2);
			}
			if (s == "Exit") {
				System.exit(0);
			}

		}

	}

	public void operateFile(String title, int type) {
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle(title);
		int choose = -1;
		switch (type) {
		case FILE_OPEN:
			choose = chooser.showOpenDialog(null);
			break;

		case FILE_SAVE:
			choose = chooser.showSaveDialog(null);
			break;
		}

		if (choose == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			switch (type) {
			case FILE_OPEN:
				model.openFile(file);
				view.setTitle(file.getName());
				break;

			case FILE_SAVE:
				int result = JOptionPane.showConfirmDialog(null,
						"Do u want to save this file" + "\n" + "Xuống dòng đây!");
				if (result == JOptionPane.YES_OPTION) {
					model.saveFile(file);
					view.setTitle(file.getName());
				}

			}
		}
	}

}
