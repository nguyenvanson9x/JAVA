package connect.database;

import GUI.Login;
import GUI.Main;
import GUI.MainScreen;

public class runner {

	public static void main(String[] args) {

//		DB_Screen dbscreen = new DB_Screen();
//		LoginScreen login = new LoginScreen(dbscreen);
		MainScreen mainscreen = new MainScreen();
		Login login = new Login(mainscreen);

		login.setVisible(true);

	}
}
