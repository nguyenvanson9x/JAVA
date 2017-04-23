package Tuan06;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MatrixController {
	private MatrixView view;
	private MatrixModel model;
	public MatrixController(MatrixView view, MatrixModel model) {
		super();
		this.view = view;
		this.model = model;
		view.initGroundButton(model.getMatrix());
		view.setVisible(true);
		
		view.getAddbutton().addActionListener(new addButtonListener());
		
		view.getSubbutton().addActionListener(new subButtonListener());
		view.addActionListener(new groundButtonListener());
		
	}
	//ActionListener ac = new addButtonListener();
	
	class addButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			model.addOne();
			view.updateGroundButton(model.getMatrix());
		}
	}
	class subButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			model.subOne();
			view.updateGroundButton(model.getMatrix());
		}
		
	}
	class groundButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton button = (JButton) e.getSource();
			JPanel panel = view.getGroundPanel();
			int order = panel.getComponentZOrder(button);

			int length = model.getMatrix().length;
			int row = order/length;
			int col = order%length;

			model.updateCell(row, col);
			view.updateGroundButton(model.getMatrix());
		}
			
	}
	
}
