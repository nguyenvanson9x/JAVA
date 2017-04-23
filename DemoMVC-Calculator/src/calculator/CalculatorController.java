package calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CalculatorController {
	private CalculatorView view;
	private CalculatorModel model;

	public CalculatorController(CalculatorView view, CalculatorModel model) {
		super();
		this.view = view;
		this.model = model;

		this.view.addAC(new ButtonActionListener());
	}

	class ButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton aButton = (JButton) e.getSource();
			String token = aButton.getText();

			String currentText = view.getResult();

			String newResult = model.append(currentText, token);

			view.setResult(newResult);

		}
	}
}
