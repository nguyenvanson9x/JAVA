package Notepad;

public class runner {
public static void main(String[] args) {
	husview view = new husview();
	husmodel model = new husmodel(view);
	huscontroller controller = new huscontroller(view, model);
	view.setVisible(true);
}
}
