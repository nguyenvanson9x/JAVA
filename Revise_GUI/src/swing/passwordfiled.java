package swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class passwordfiled {

	public static void main(String args[]) {
	    JFrame f = new JFrame("JPasswordField Sample");
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    Container content = f.getContentPane();
	    content.setLayout(new GridLayout(2,1,5,5));
	    Box rowOne = Box.createHorizontalBox();
	    rowOne.add(new JLabel("Username"));
	    rowOne.add(new JTextField());
	    Box rowTwo = Box.createHorizontalBox();
	    rowTwo.add(new JLabel("Password"));
	    rowTwo.add(new JPasswordField());
	    content.add(rowOne);
	    content.add(rowTwo);
	    f.setSize(300, 100);
	    f.setVisible(true);
	  }

}
