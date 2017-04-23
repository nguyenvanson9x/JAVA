package calculator;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorView extends JFrame {

	private JPanel contentPane;
	private JTextField txtResult;
	private JPanel pnlButtons;
	private String[][] strButtonNames;
	private JButton[][] buttons;
	private CalculatorModel model;

	private void initButtons() {
		buttons = new JButton[5][4];
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[i].length; j++) {
				buttons[i][j] = new JButton();
				buttons[i][j].setText(strButtonNames[i][j]);
				pnlButtons.add(buttons[i][j]);

				if (strButtonNames[i][j].equals("")) {
					buttons[i][j].setEnabled(false);
				}
			}
		}

	}

	public void addAC(ActionListener ac) {
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[i].length; j++) {
				buttons[i][j].addActionListener(ac);
			}
		}
	}

	public String getResult() {
		return txtResult.getText();
	}

	public void setResult(String newResult) {
		txtResult.setText(newResult);
	}

	private void initComponents() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(400, 400);
		this.setTitle("Calculator");

		contentPane = new JPanel();
		this.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());

		txtResult = new JTextField();
		contentPane.add(txtResult, BorderLayout.NORTH);

		pnlButtons = new JPanel();
		pnlButtons.setLayout(new GridLayout(5, 4));
		contentPane.add(pnlButtons, BorderLayout.CENTER);
	}

	public CalculatorView(CalculatorModel model) {
		this.model = model;
		strButtonNames = model.getButtonNames();

		// TODO Auto-generated constructor stub
		initComponents();

		initButtons();
	}

}
