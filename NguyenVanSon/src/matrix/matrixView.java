package matrix;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class matrixView extends JFrame {

	public matrixModel model;
	private JPanel pnBorder, pnCenter;
	private JButton[][] btnGround;
	private JButton btnNorth, btnSouth;

	public matrixView(matrixModel model) {
		this.model = model;
		creatFrame();
		addContent();
		displayFrame();

	}

	public JButton getBtnNorth() {
		return btnNorth;
	}

	public JButton getBtnSouth() {
		return btnSouth;
	}

	private void creatFrame() {
		setTitle("Matrix Button");
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	private void addContent() {
		int[][] matrix = model.getMatrix();
		pnBorder = new JPanel();
		pnBorder.setLayout(new BorderLayout());

		btnNorth = new JButton("Add one");
		btnSouth = new JButton("Sub one");
		pnBorder.add(btnNorth, BorderLayout.NORTH);
		pnBorder.add(btnSouth, BorderLayout.SOUTH);

		pnCenter = new JPanel();
		pnCenter.setLayout(new GridLayout(matrix.length, matrix[0].length));
		pnBorder.add(pnCenter, BorderLayout.CENTER);

		Container con = getContentPane();
		con.add(pnBorder);

	}

	private void displayFrame() {

		setLocationRelativeTo(null);
		setVisible(true);

	}

	public void initButtonGround(matrixModel model) {
		int length = model.getMatrix().length;
		btnGround = new JButton[length][length];

		for (int i = 0; i < btnGround.length; i++) {
			for (int j = 0; j < btnGround[0].length; j++) {
				btnGround[i][j] = new JButton();
				btnGround[i][j].setText(model.getMatrix()[i][j] + "");
				pnCenter.add(btnGround[i][j]);
			}
		}
	}

	public void updateButtonGround(int[][] matrix) {

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				btnGround[i][j].setText(matrix[i][j] + "");
			}
		}
	}
	
	public void btnGroundAction(ActionListener ac) {
		for (int i = 0; i < btnGround.length; i++) {
			for (int j = 0; j < btnGround[0].length; j++) {
				btnGround[i][j].addActionListener(ac);
			}
		}
	}

	public JPanel getGroundPanel() {
		// TODO Auto-generated method stub
		return pnCenter;
	}

}
