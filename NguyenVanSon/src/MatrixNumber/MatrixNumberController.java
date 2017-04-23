package MatrixNumber;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MatrixNumberController {
	private MatrixNumberView theView;
	private MatrixNumberModel theModel;

	public MatrixNumberController(MatrixNumberView theView,
			MatrixNumberModel theModel) {
		this.theView = theView;
		this.theModel = theModel;

		ActionListener ac = new addButtonListener();
		theView.initGroundButton(theModel);
		theView.addAction(new addOneButton());
	}

	class addButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

		}

	}

	class addOneButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			theModel.updateMatrixByAdd();
			//theView.initGroundButton(theModel);
			theModel.updateAllButtons(theModel.getMatrix());

		}

	}
}
