package HUSNOTEPAD;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Toolkit;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class husview extends JFrame {

	private JPanel pnBorder;
	private JMenuItem mntmOpen;
	private JMenuItem mntmNew;
	private JMenuItem mntmSave;
	private JMenuItem mntmExit;
	private JSeparator separator;
	private JTextArea textArea;

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(String s) {
		textArea.setText(s);
	}

	public JMenuItem getMntmOpen() {
		return mntmOpen;
	}

	public JMenuItem getMntmNew() {
		return mntmNew;
	}

	public JMenuItem getMntmSave() {
		return mntmSave;
	}

	public husview() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(husview.class.getResource("/javax/swing/plaf/basic/icons/image-delayed.png")));
		setTitle("HUS NOTEPAD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		mntmOpen = new JMenuItem("Open");
		mnFile.add(mntmOpen);

		mntmNew = new JMenuItem("New");
		mnFile.add(mntmNew);

		mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);

		separator = new JSeparator();
		mnFile.add(separator);

		mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		JMenuItem mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
		pnBorder = new JPanel();
		pnBorder.setBorder(new EmptyBorder(5, 5, 5, 5));
		pnBorder.setLayout(new BorderLayout(0, 0));
		setContentPane(pnBorder);

		JScrollPane scrollPane = new JScrollPane();
		pnBorder.add(scrollPane, BorderLayout.CENTER);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}

}
