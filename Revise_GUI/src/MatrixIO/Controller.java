package MatrixIO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
	private Model model;
	private View view;
	private InputMatrix inputM = new InputMatrix();
	public Controller(View view, Model model) {
		super();
		this.model = model;
		this.view = view;
		model.setMatrix(inputM.readFile("0.txt"));
		action ac = new action();
		view.initButton(model.getMatrix());

		view.setVisible(true);
		view.getBtnTheHe().addActionListener(ac);

	}

	class action implements ActionListener {
		int k=1;
		@Override
		
		public void actionPerformed(ActionEvent e) {
			k+=1;
			view.setLbStatus("Thế hệ thứ "+k);
			
			int newmatrix[][] = model.creatMarkMatrix(model.getMatrix());
			int sumMatrix[][] = model.sumMatrix(newmatrix);
			model.standardizedMatrix(sumMatrix);
			view.updateButton(model.getMatrix());
			
		}

	}

}
