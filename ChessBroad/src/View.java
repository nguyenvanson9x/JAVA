import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class View extends JFrame {
	private JPanel contentPane;
	private JPanel pnlGround;
	private JButton[][] buttons;
	private Model model;
	private int n;

	public View() {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 600);
		setTitle("Ban co");

		model = new Model();
		model.inputMatrix("0.txt");
		n = model.getSize();

		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);
		pnlGround = new JPanel();
		contentPane.add(pnlGround, BorderLayout.CENTER);
		pnlGround.setLayout(new GridLayout(n, n, 0, 0));

		paintAll(getGraphics());
	}

	public void initButtons(int[][] numbers) {
		// TODO Auto-generated method stub
		int n = numbers.length;
		buttons = new JButton[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				buttons[i][j] = new JButton();
				buttons[i][j].setText("" + numbers[i][j]);
				if (numbers[i][j] == 1)
					buttons[i][j].setBackground(Color.red);
				else
					buttons[i][j].setBackground(Color.gray);
				pnlGround.add(buttons[i][j]);
			}
		}
	}

	public void updateButton(int[][] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length; j++) {
				buttons[i][j].setText("" + numbers[i][j]);
				if (numbers[i][j] == 1)
					buttons[i][j].setBackground(Color.red);
				else
					buttons[i][j].setBackground(Color.gray);
			}
		}
	}

	public void addAction(KeyListener e) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				buttons[i][j].addKeyListener(e);

			}
		}
	}

}
