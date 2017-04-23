package MatrixNumber;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MatrixNumberView extends JFrame {
	private MatrixNumberModel theModel;
	private JPanel pnBoder, pnCenter;
	private JButton btnNorth, btnSouth;
	private JButton[][] groundButton;

	public MatrixNumberView() {

		creatFrame();
		addControl();
		displayFrame();
	}

	private void creatFrame() {
		setTitle("Matrix Number");
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	private void addControl() {
		pnBoder = new JPanel();
		pnBoder.setLayout(new BorderLayout());

		btnNorth = new JButton("+1");
		btnSouth = new JButton("-1");
		pnBoder.add(btnNorth, BorderLayout.NORTH);
		pnBoder.add(btnSouth, BorderLayout.SOUTH);

		pnCenter = new JPanel();
		pnCenter.setLayout(new GridLayout(5, 5, 5, 5));

		pnBoder.add(pnCenter, BorderLayout.CENTER);
		Container con = getContentPane();
		con.add(pnBoder);

	}

	private void displayFrame() {
		setLocationRelativeTo(null);
		// pack();
		setVisible(true);

	}

	public void initGroundButton(MatrixNumberModel theModel) {
		int length = theModel.length();

		groundButton = new JButton[length][length];

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				groundButton[i][j] = new JButton();

				groundButton[i][j].setText(theModel.getMatrix()[i][j] + "");

				pnCenter.add(groundButton[i][j]);
			}
		}
	}

	public void addAction(ActionListener e) {
		btnNorth.addActionListener(e);
	}
}
