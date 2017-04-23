package Tuan06;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MatrixView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton addbutton;
	private JButton subbutton;
	private JButton groundButton[][];
	private JPanel groundPanel;

	/*
	 * public void addButtonActionListener(ActionListener e){
	 * addbutton.addActionListener(e); }
	 */

	/**
	 * Create the frame.
	 */
	public MatrixView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		addbutton = new JButton("+1");
		contentPane.add(addbutton, BorderLayout.NORTH);

		subbutton = new JButton("-1");

		contentPane.add(subbutton, BorderLayout.SOUTH);

		groundPanel = new JPanel();
		contentPane.add(groundPanel, BorderLayout.CENTER);
		groundPanel.setLayout(new GridLayout(5, 5, 0, 0));

	}

	public void initGroundButton(int[][] matrix) {
		int length = matrix.length;
		groundButton = new JButton[length][length];

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				groundButton[i][j] = new JButton();
				groundButton[i][j].setText(matrix[i][j] + "");
				groundPanel.add(groundButton[i][j]);

			}
		}
	}

	public void addActionListener(ActionListener ac) {
		int length = groundButton.length;

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				groundButton[i][j].addActionListener(ac);
			}
		}
		// addbutton.addActionListener(ac);
		// subbutton.addActionListener(ac);
	}

	public JButton getAddbutton() {
		return addbutton;
	}

	public JButton getSubbutton() {
		return subbutton;
	}

	public JPanel getGroundPanel() {
		return groundPanel;
	}

	public void updateGroundButton(int[][] matrix) {
		int length = matrix.length;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				groundButton[i][j].setText(matrix[i][j] + "");
			}
		}
	}
}
