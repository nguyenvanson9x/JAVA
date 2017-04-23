package Calculator;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorView extends JFrame {
	private JPanel pnBorder, pnCenter;
	private JButton[][] button;
	private JTextField txt;
	private String[][] strButton;
	private CalculatorModel model;

	public CalculatorView(CalculatorModel model) {
		this.model = model;
		strButton = model.getStrButton();
		creatFrame();

		addContent();
		addButton();
		displayFrame();
	}

	public String getTxt() {
		return txt.getText();
	}

	public void setTxt(String txt) {
		this.txt.setText(txt);
	}

	private void creatFrame() {
		setTitle("Calculator");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 500);

	}

	private void addContent() {
		pnBorder = new JPanel();
		pnBorder.setLayout(new BorderLayout());

		txt = new JTextField();
		pnBorder.add(txt, BorderLayout.NORTH);

		pnCenter = new JPanel();
		pnCenter.setLayout(new GridLayout(4, 4, 5, 5));

		pnBorder.add(pnCenter, BorderLayout.CENTER);

		Container con = getContentPane();
		con.add(pnBorder);
	}

	private void displayFrame() {
		setLocationRelativeTo(null);
		setVisible(true);

	}

	private void addButton() {
		button = new JButton[4][4];
		int i, j;
		for (i = 0; i < button.length; i++) {
			for (j = 0; j < button[i].length; j++) {
				button[i][j] = new JButton();
				button[i][j].setText(strButton[i][j]);
				pnCenter.add(button[i][j]);
			}

		}
	}

	public void actionButton(ActionListener ac) {
		int i, j;
		for (i = 0; i < button.length; i++) {
			for (j = 0; j < button[i].length; j++) {
				button[i][j].addActionListener(ac);
			}
		}
	}

}
