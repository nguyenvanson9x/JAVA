package test;

import javax.swing.JFrame;

public class test2 extends JFrame {

	private PassWordDialog passDialog;

	public test2() {
		passDialog = new PassWordDialog();
		passDialog.setVisible(true);
	}

	public static void main(String[] args) {
		
		test2 show = new test2();
		
	}
}
