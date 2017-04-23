package Sodo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * Giao diện của chức năng Sơ đồ nhà xe
 * 
 * @author Đặng Khắc Toàn
 */
public class GUISodo extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel pnNorth, pnCenter, pnTitle, pnSearch, pnBike, pnMoto, pnCar,
			pnMoto_a, pnMoto_b, pnMoto_c;

	private JButton[][] buttonsBike, buttonsCar, buttonsMoto1, buttonsMoto2,
			buttonsMoto3;

	private JTextField tfSearch;
	private Thread myThread;
	private JButton btnSearch;

	/**
	 * Hàm dựng của lớp GUISodo
	 */
	public GUISodo() {

		setTitle("Sơ đồ nhà xe");
		setFrameIcon(new ImageIcon(
				GUISodo.class.getResource("/Image/coffee-machine.png")));
		setBounds(0, 0, 1052, 618);

		pnNorth = new JPanel();
		pnNorth.setBorder(new EmptyBorder(20, 0, 0, 0));
		getContentPane().add(pnNorth, BorderLayout.NORTH);
		pnNorth.setLayout(new BoxLayout(pnNorth, BoxLayout.Y_AXIS));

		pnTitle = new JPanel();
		pnNorth.add(pnTitle);

		JLabel lbTitle = new JLabel("Sơ Đồ Nhà Xe");
		pnTitle.add(lbTitle);
		lbTitle.setForeground(Color.RED);
		lbTitle.setFont(new Font("Tahoma", Font.BOLD, 26));

		pnSearch = new JPanel();
		pnNorth.add(pnSearch);
		pnSearch.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		tfSearch = new JTextField();
		pnSearch.add(tfSearch);
		tfSearch.setColumns(25);

		btnSearch = new JButton("Tìm kiếm");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DataAccessSodo dataSodo = new DataAccessSodo();
				ResultSet rs = dataSodo.search(tfSearch.getText());
				myThread = new Thread(new Runnable() {
					public void run() {
						try {
							if (rs.next()) {
								for (int i = 0; i < buttonsCar.length; i++)
									for (int j = 0; j < buttonsCar[i].length; j++)
										if (buttonsCar[i][j].getText().equals(
												rs.getString("Vitri"))) {
											for (int count = 0; count < 40; count++) {
												buttonsCar[i][j]
														.setEnabled(false);
												Thread.sleep(90);
												buttonsCar[i][j]
														.setEnabled(true);
												buttonsCar[i][j]
														.setForeground(Color.green);
												Thread.sleep(90);
											}
										}
								for (int i = 0; i < buttonsMoto1.length; i++)
									for (int j = 0; j < buttonsMoto1[i].length; j++)
										if (buttonsMoto1[i][j].getText()
												.equals(rs.getString("Vitri"))) {
											for (int count = 0; count < 40; count++) {
												buttonsMoto1[i][j]
														.setEnabled(false);
												Thread.sleep(90);
												buttonsMoto1[i][j]
														.setEnabled(true);
												buttonsMoto1[i][j]
														.setForeground(Color.green);
												Thread.sleep(90);
											}
										}
								for (int i = 0; i < buttonsMoto2.length; i++)
									for (int j = 0; j < buttonsMoto2[i].length; j++)
										if (buttonsMoto2[i][j].getText()
												.equals(rs.getString("Vitri"))) {
											for (int count = 0; count < 40; count++) {
												buttonsMoto2[i][j]
														.setEnabled(false);
												Thread.sleep(90);
												buttonsMoto2[i][j]
														.setEnabled(true);
												buttonsMoto2[i][j]
														.setForeground(Color.green);
												Thread.sleep(90);
											}
										}
								for (int i = 0; i < buttonsMoto3.length; i++)
									for (int j = 0; j < buttonsMoto3[i].length; j++)
										if (buttonsMoto3[i][j].getText()
												.equals(rs.getString("Vitri")))
											for (int count = 0; count < 40; count++) {
												buttonsMoto3[i][j]
														.setEnabled(false);
												Thread.sleep(90);
												buttonsMoto3[i][j]
														.setEnabled(true);
												buttonsMoto3[i][j]
														.setForeground(Color.green);
												Thread.sleep(90);
											}
								for (int i = 0; i < buttonsBike.length; i++)
									for (int j = 0; j < buttonsBike[i].length; j++)
										if (buttonsBike[i][j].getText().equals(
												rs.getString("Vitri")))
											for (int count = 0; count < 40; count++) {
												buttonsBike[i][j]
														.setEnabled(false);
												Thread.sleep(90);
												buttonsBike[i][j]
														.setEnabled(true);
												buttonsBike[i][j]
														.setForeground(Color.green);
												Thread.sleep(90);
											}
							} else {
								JOptionPane.showMessageDialog(null,
										"Xe này chưa có trong Gara",
										"Thông báo từ hệ thống",
										JOptionPane.INFORMATION_MESSAGE);
							}
						} catch (Exception e) {
							System.out.println(e.toString());
						}
					}
				});
				myThread.start();
			}
		});
		btnSearch.setForeground(Color.BLACK);
		btnSearch.setBackground(Color.WHITE);
		pnSearch.add(btnSearch);

		pnCenter = new JPanel();

		getContentPane().add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		pnCenter.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		pnCar = new JPanel();
		pnCar.setBorder(new TitledBorder(null, "\u00D4 t\u00F4",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnCar.setBounds(10, 11, 1028, 68);
		panel.add(pnCar);
		pnCar.setLayout(new GridLayout(2, 9, 10, 1));

		pnBike = new JPanel();
		pnBike.setBorder(new TitledBorder(null, "Xe \u0111\u1EA1p",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnBike.setBounds(10, 193, 295, 289);
		panel.add(pnBike);
		pnBike.setLayout(new GridLayout(7, 3, 1, 10));

		pnMoto = new JPanel();
		pnMoto.setBorder(new TitledBorder(null, "Xe m\u00E1y",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnMoto.setBounds(380, 193, 658, 289);
		panel.add(pnMoto);
		pnMoto.setLayout(null);

		pnMoto_a = new JPanel();
		pnMoto_a.setBounds(7, 16, 195, 262);
		pnMoto.add(pnMoto_a);
		pnMoto_a.setLayout(new GridLayout(7, 2, 1, 10));

		pnMoto_b = new JPanel();
		pnMoto_b.setBounds(212, 16, 325, 262);
		pnMoto.add(pnMoto_b);
		pnMoto_b.setLayout(new GridLayout(7, 3, 1, 10));

		pnMoto_c = new JPanel();
		pnMoto_c.setBounds(544, 16, 104, 262);
		pnMoto.add(pnMoto_c);
		pnMoto_c.setLayout(new GridLayout(7, 1, 1, 10));

		JLabel lblNewLabel = new JLabel(
				"-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\r\n\r\n");
		lblNewLabel.setBounds(10, 126, 1028, 14);
		panel.add(lblNewLabel);

		JLabel lbOut = new JLabel();
		lbOut.setBounds(10, 75, 60, 60);
		panel.add(lbOut);

		JLabel lbIn = new JLabel();
		lbIn.setBounds(10, 133, 60, 60);
		panel.add(lbIn);
		addLocation();
		setPicture(lbOut, "out.png");
		setPicture(lbIn, "in.png");
		setColor();
		buttonsCar[1][1].setBackground(Color.red);
		getRootPane().setDefaultButton(btnSearch);
	}

	public JButton[][] getButtonsBike() {
		return buttonsBike;
	}

	public void setButtonsBike(JButton[][] buttonsBike) {
		this.buttonsBike = buttonsBike;
	}

	public JButton[][] getButtonsCar() {
		return buttonsCar;
	}

	public void setButtonsCar(JButton[][] buttonsCar) {
		this.buttonsCar = buttonsCar;
	}

	public JButton[][] getButtonsMoto1() {
		return buttonsMoto1;
	}

	public void setButtonsMoto1(JButton[][] buttonsMoto1) {
		this.buttonsMoto1 = buttonsMoto1;
	}

	public JButton[][] getButtonsMoto2() {
		return buttonsMoto2;
	}

	public void setButtonsMoto2(JButton[][] buttonsMoto2) {
		this.buttonsMoto2 = buttonsMoto2;
	}

	public JButton[][] getButtonsMoto3() {
		return buttonsMoto3;
	}

	public void setButtonsMoto3(JButton[][] buttonsMoto3) {
		this.buttonsMoto3 = buttonsMoto3;
	}

	/**
	 * Hiển thị các vị trí của xe trong bãi lên giao diện
	 */
	private void addLocation() {
		buttonsBike = new JButton[7][3];
		for (int i = 0; i < buttonsBike.length; i++)
			for (int j = 0; j < buttonsBike[i].length; j++) {
				buttonsBike[i][j] = new JButton();
				buttonsBike[i][j].setText("B"
						+ (buttonsBike[i].length * i + j + 1));
				buttonsBike[i][j].setEnabled(false);
				buttonsBike[i][j].addActionListener(this);
				pnBike.add(buttonsBike[i][j]);
			}
		buttonsMoto1 = new JButton[7][2];
		for (int i = 0; i < buttonsMoto1.length; i++)
			for (int j = 0; j < buttonsMoto1[i].length; j++) {
				buttonsMoto1[i][j] = new JButton();
				buttonsMoto1[i][j].setText("Ma"
						+ (buttonsMoto1[i].length * i + j + 1));
				buttonsMoto1[i][j].setEnabled(false);
				buttonsMoto1[i][j].addActionListener(this);
				pnMoto_a.add(buttonsMoto1[i][j]);
			}
		buttonsMoto2 = new JButton[7][3];
		for (int i = 0; i < buttonsMoto2.length; i++)
			for (int j = 0; j < buttonsMoto2[i].length; j++) {
				buttonsMoto2[i][j] = new JButton();
				buttonsMoto2[i][j].setText("Mb"
						+ (buttonsMoto2[i].length * i + j + 1));
				buttonsMoto2[i][j].setEnabled(false);
				buttonsMoto2[i][j].addActionListener(this);
				pnMoto_b.add(buttonsMoto2[i][j]);
			}
		buttonsMoto3 = new JButton[7][1];
		for (int i = 0; i < buttonsMoto3.length; i++)
			for (int j = 0; j < buttonsMoto3[i].length; j++) {
				buttonsMoto3[i][j] = new JButton();
				buttonsMoto3[i][j].setText("Mc"
						+ (buttonsMoto3[i].length * i + j + 1));
				buttonsMoto3[i][j].setEnabled(false);
				buttonsMoto3[i][j].addActionListener(this);
				pnMoto_c.add(buttonsMoto3[i][j]);
			}

		buttonsCar = new JButton[2][9];
		for (int i = 0; i < buttonsCar.length; i++)
			for (int j = 0; j < buttonsCar[i].length; j++) {
				buttonsCar[i][j] = new JButton();
				buttonsCar[i][j].setText("C"
						+ (buttonsCar[i].length * i + j + 1));
				buttonsCar[i][j].setEnabled(false);
				buttonsCar[i][j].addActionListener(this);
				pnCar.add(buttonsCar[i][j]);
			}

	}

	/**
	 * Ảnh ra/ vào
	 * 
	 * @param label
	 *            Đối tượng để hiện thị ảnh
	 * @param filename
	 *            Ảnh ra/ vào
	 */
	@SuppressWarnings("static-access")
	public void setPicture(JLabel label, String filename) {
		try {
			BufferedImage image = ImageIO.read(new File(filename));
			int x = label.getSize().width;
			int y = label.getSize().height;
			int ix = image.getWidth();
			int iy = image.getHeight();
			int dx = 0;
			int dy = 0;
			if (x / y > ix / iy) {
				dy = y;
				dx = dy * ix / iy;
			} else {
				dx = x;
				dy = dx * iy / ix;
			}
			ImageIcon icon = new ImageIcon(image.getScaledInstance(50, 50,
					image.SCALE_SMOOTH));
			label.setIcon(icon);
		} catch (IOException e) {
			Logger.getLogger(ImageIO.class.getName())
					.log(Level.SEVERE, null, e);
		}
	}

	/**
	 * Đặt màu cho các vị trí được tìm thấy
	 */
	private void setColor() {
		DataAccessSodo dataSodo = new DataAccessSodo();
		ResultSet rs = dataSodo.setGara();
		try {
			while (rs.next()) {
				for (int i = 0; i < buttonsCar.length; i++)
					for (int j = 0; j < buttonsCar[i].length; j++)
						if (buttonsCar[i][j].getText().equals(
								rs.getString("Vitri")))
							buttonsCar[i][j].setEnabled(true);
				for (int i = 0; i < buttonsMoto1.length; i++)
					for (int j = 0; j < buttonsMoto1[i].length; j++)
						if (buttonsMoto1[i][j].getText().equals(
								rs.getString("Vitri")))
							buttonsMoto1[i][j].setEnabled(true);
				for (int i = 0; i < buttonsMoto2.length; i++)
					for (int j = 0; j < buttonsMoto2[i].length; j++)
						if (buttonsMoto2[i][j].getText().equals(
								rs.getString("Vitri")))
							buttonsMoto2[i][j].setEnabled(true);
				for (int i = 0; i < buttonsMoto3.length; i++)
					for (int j = 0; j < buttonsMoto3[i].length; j++)
						if (buttonsMoto3[i][j].getText().equals(
								rs.getString("Vitri")))
							buttonsMoto3[i][j].setEnabled(true);
				for (int i = 0; i < buttonsBike.length; i++)
					for (int j = 0; j < buttonsBike[i].length; j++)
						if (buttonsBike[i][j].getText().equals(
								rs.getString("Vitri")))
							buttonsBike[i][j].setEnabled(true);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < buttonsCar.length; i++)
			for (int j = 0; j < buttonsCar[i].length; j++) {
				if (e.getSource() == buttonsCar[i][j]) {
					DataAccessSodo dataSodo = new DataAccessSodo();
					dataSodo.viewInfo(buttonsCar[i][j].getText());
				}

			}
		for (int i = 0; i < buttonsMoto3.length; i++)
			for (int j = 0; j < buttonsMoto3[i].length; j++) {
				if (e.getSource() == buttonsMoto3[i][j]) {
					DataAccessSodo dataSodo = new DataAccessSodo();
					dataSodo.viewInfo(buttonsMoto3[i][j].getText());
				}
			}
		for (int i = 0; i < buttonsMoto2.length; i++)
			for (int j = 0; j < buttonsMoto2[i].length; j++) {
				if (e.getSource() == buttonsMoto2[i][j]) {
					DataAccessSodo dataSodo = new DataAccessSodo();
					dataSodo.viewInfo(buttonsMoto2[i][j].getText());
				}
			}
		for (int i = 0; i < buttonsMoto1.length; i++)
			for (int j = 0; j < buttonsMoto1[i].length; j++) {
				if (e.getSource() == buttonsMoto1[i][j]) {
					DataAccessSodo dataSodo = new DataAccessSodo();
					dataSodo.viewInfo(buttonsMoto1[i][j].getText());
				}
			}
		for (int i = 0; i < buttonsBike.length; i++)
			for (int j = 0; j < buttonsBike[i].length; j++) {
				if (e.getSource() == buttonsBike[i][j]) {
					DataAccessSodo dataSodo = new DataAccessSodo();
					dataSodo.viewInfo(buttonsBike[i][j].getText());
				}
			}
	}
}
