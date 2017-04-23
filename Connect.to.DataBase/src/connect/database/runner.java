package connect.database;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class runner {

	public static void main(String[] args) {
//		try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//            	System.out.println(info.getName());
//                if ("Metal".equals(info.getName())) {
//                    UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
//                    //javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
//           // java.util.logging.Logger.getLogger(jframeConnectData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LoginScreen login = new LoginScreen();
		login.setVisible(true);

	}
}
