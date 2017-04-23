import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller {
	private Model model;
	private View view;

	public Controller(Model model, View view) {
		super();
		this.model = model;
		this.view = view;

		model.inputMatrix("0.txt");
		view.initButtons(model.getNumber());
		view.addAction(new CellKeyListener());
		view.setVisible(true);

	}

	class CellKeyListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			int key_code = e.getKeyCode();

			if (key_code == KeyEvent.VK_UP) {
				model.UP();
				view.updateButton(model.getNumber());
			}

			if (key_code == KeyEvent.VK_DOWN) {
				model.DOWN();
				view.updateButton(model.getNumber());
			}

			if (key_code == KeyEvent.VK_LEFT) {
				model.LEGHT();
				view.updateButton(model.getNumber());
			}

			if (key_code == KeyEvent.VK_RIGHT) {
				model.RIGHT();
				view.updateButton(model.getNumber());
			}

		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}

	}

}
