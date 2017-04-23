package Calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CalculatorController {
	private CalculatorView view;
	private CalculatorModel model;
	public CalculatorController(CalculatorView view, CalculatorModel model) {
		this.view = view;
		this.model = model;
		this.view.actionButton(new ButtonActionListener());
	}
	
	class ButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton nameButton  = (JButton)e.getSource();
			String token = nameButton.getText();

			String currentText = view.getTxt();

			String newResult = model.append(currentText, token);

			view.setTxt(newResult);
			
		}
		
	}
}
