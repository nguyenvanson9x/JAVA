package HUSNOTEPAD;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

public class huscontroller {
	private husview view = new husview();
	private husmodel model;
	private static final int FILE_OPEN = 1;
	private static final int FILE_SAVE = 2;
	public huscontroller(husview view, husmodel model) {
		this.view = view;
		this.model = model;
		action ac = new action();
		view.getMntmNew().addActionListener(ac);
		view.getMntmOpen().addActionListener(ac);
		view.getMntmSave().addActionListener(ac);
	}
	
	class action implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String s = e.getActionCommand();
			if (s == "New" ) {
				view.setTextArea("");
			}
			if (s=="Open") {
				model.operateFile("Open a file", FILE_OPEN);
			}
			if (s == "Save") {
				model.operateFile("Save the file", FILE_SAVE);
			}
			
		}
		
	}
}
