package GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MainScreen extends JFrame {

	private String[] MenuName = { "Giới thiệu", "Danh mục", "Đầu sách", "Mượn trả", "Người dùng", "Thống kê",
			"Hệ thống", "Thoát" };
	private JMenu[] mn;
	private String[][] ItemName = { { "", "", "", "", "" },
			{ "Ngôn ngữ", "Nhà xuất bản", "Tác giả", "Thể loại", "Tình trạng" },
			{ "Quản lý đầu sách", "Thanh lý", "", "", ""}, 
			{ "Mượn", "Trả", "", "", ""},
			{ "Nhân viên", "Khách", "", "", ""}, 
			{ "", "", "", "", ""},
			{ "", "", "", "", ""}, 
			{ "", "", "", "", ""} };
	
	private JMenuItem[][] mnItem;
	private MainModel model = new MainModel();

	public MainScreen() {

		add(mainPanel());
		pack();
		creatFrame();
	}

	private JPanel mainPanel() {
		JPanel pnBorder = new JPanel(new BorderLayout());

		pnBorder.add(pnNorth(), BorderLayout.NORTH);
		pnBorder.add(pnCenter(), BorderLayout.CENTER);
		pnBorder.add(pnSouth(), BorderLayout.SOUTH);

		return pnBorder;
	}

	private JPanel pnNorth() {
		JPanel pnNorth = new JPanel(new GridLayout(1, 8));
		int length = MenuName.length;
		JMenuBar mnBar = new JMenuBar();
		mn = new JMenu[length];
		String s;
		for (int i = 0; i < length; i++) {
			mn[i] = creatMenu(MenuName[i]);
			s = "/icon/1 ("+(i+1)+").ico";
			
			mn[i].setIcon(new ImageIcon(MainScreen.class.getResource(s)));
			mn[i].addActionListener(model.ItemAction());
			mnBar.add(mn[i]);
		}

		mnItem = new JMenuItem[ItemName.length][ItemName[0].length];
		int i, j;
		for (i = 0; i < ItemName.length; i++) {
			for (j = 0; j < ItemName[0].length; j++) {
				if (ItemName[i][j] != "") {
					
					s = "/icon/1 ("+(i+1)+").ico";
					mnItem[i][j] = mnItem(ItemName[i][j]);
					mnItem[i][j].setIcon(new ImageIcon(MainScreen.class.getResource(s)));
					mnItem[i][j].addActionListener(model.ItemAction());
					mn[i].add(mnItem[i][j]);
				}

			}

		}

		pnNorth.add(mnBar);
		return pnNorth;
	}

	private JMenuItem mnItem(String name) {
		JMenuItem mnItem = new JMenuItem(name);

		return mnItem;
	}

	private JMenu creatMenu(String name) {
		JMenu mn = new JMenu(name);
		return mn;
	}

	private JPanel pnCenter() {
		JPanel pnCenter = new JPanel();

		return pnCenter;
	}

	private JPanel pnSouth() {
		JPanel pnSouth = new JPanel();

		return pnSouth;
	}

	private void creatFrame() {
		setTitle("Welcome");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		MainScreen show = new MainScreen();
		show.setVisible(true);
	}
}
