package matrix;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class matrixController {
	
	private matrixModel model;
	private matrixView view;
	
	
	public matrixController(matrixView view, matrixModel model) {
		
		this.model = model;
		this.view = view;
		view.initButtonGround(model);
		btnGroundAction ac = new btnGroundAction();
		view.getBtnNorth().addActionListener(new addOneButtonAction());
		view.getBtnSouth().addActionListener(new subOneButtonAction());
		view.btnGroundAction(ac);
	}
	
	class addOneButtonAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			model.addOne();
			view.updateButtonGround(model.getMatrix());
			
		}
		
	}
	
	class subOneButtonAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			model.subOne();
			view.updateButtonGround(model.getMatrix());
			
		}
		
	}
	
	class btnGroundAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			JPanel panel = view.getGroundPanel();
			int order = panel.getComponentZOrder(button);
			
			// xac dinh toa do cua button;
			int length = model.getMatrix().length;
			int row = order/length;
			int col = order%length;
			
			model.updateCell(row, col);
			view.updateButtonGround(model.getMatrix());
			
		}
		
	}
	

}
