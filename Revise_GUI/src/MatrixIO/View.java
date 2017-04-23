package MatrixIO;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class View extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	// 0 private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnCenter;
	private JLabel lbStatus;
	private JButton btnTheHe;
	private JButton[][] btnGround;

	public JButton getBtnTheHe() {
		return btnTheHe;
	}

	public void setLbStatus(String s) {
		lbStatus.setText(s);
	}

	public View() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JPanel pnButton = new JPanel();
		pnButton.setBorder(new EmptyBorder(5, 50, 10, 50));
		btnTheHe = new JButton("The he tiep theo");
		pnButton.add(btnTheHe);
		contentPane.add(pnButton, BorderLayout.SOUTH);

		lbStatus = new JLabel("Thế hệ thứ nhât");
		lbStatus.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lbStatus, BorderLayout.NORTH);

		pnCenter = new JPanel();

		contentPane.add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(new GridLayout(10, 10, 0, 0));
	}

	public void initButton(int[][] matrix) {

		btnGround = new JButton[matrix.length][matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				btnGround[i][j] = new JButton();
				if (matrix[i][j] == 1) {
					btnGround[i][j].setText("#");

				}
				btnGround[i][j].setEnabled(false);

				pnCenter.add(btnGround[i][j]);
			}
		}
	}

	public void updateButton(int[][] m) {

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				btnGround[i][j].setText("");

			}

		}

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {

				if (m[i][j] == 1) {
					btnGround[i][j].setText("#");
				}

			}
		}
	}

}
