package swing;

import javax.swing.JFrame;
import javax.swing.JSeparator;

public class separator {
	public static void main(String[] a){
	    JFrame frame = new JFrame();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    JSeparator sep = new JSeparator(JSeparator.HORIZONTAL);
	    sep.setOrientation(JSeparator.HORIZONTAL);
	    frame.add(sep);

	    frame.setSize(300, 200);
	    frame.setVisible(true);
	  }
}
