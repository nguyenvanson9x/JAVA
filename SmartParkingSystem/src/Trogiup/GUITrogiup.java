package Trogiup;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

/**
 * Giao diện của chức năng Trợ giúp
 * @author Nguyễn Văn Sơn
 * 
 */
public class GUITrogiup extends JInternalFrame{

	private static final long serialVersionUID = 1L;

	/**
	 * Hàm dựng của lớp GUITrogiup
	 */
	public GUITrogiup() {

		setTitle("Trợ giúp");
		setFrameIcon(new ImageIcon(GUITrogiup.class.getResource("/Image/book.png")));
		setBounds(0, 0, 1052, 618);
		
		JPanel pnTitle = new JPanel();
		pnTitle.setBorder(new EmptyBorder(20, 0, 20, 0));
		getContentPane().add(pnTitle, BorderLayout.NORTH);
		
		JLabel lbTitle = new JLabel("Trợ Giúp");
		lbTitle.setForeground(Color.RED);
		lbTitle.setFont(new Font("Tahoma", Font.BOLD, 26));
		pnTitle.add(lbTitle);
		
		JPanel pnCenter = new JPanel();
		pnCenter.setBorder(null);
		getContentPane().add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		pnCenter.add(scrollPane, BorderLayout.CENTER);
		
		JTextArea txtrPhnMmQun = new JTextArea();
		txtrPhnMmQun.setEditable(false);
		txtrPhnMmQun.setForeground(Color.BLUE);
		txtrPhnMmQun.setFont(new Font("Monospaced", Font.PLAIN, 25));
		txtrPhnMmQun.setText("Phần mềm quản lý bãi gửi xe thông minh \r\n\tSmart Parking System\r\n\r\nĐược phát triển bởi nhóm:\r\n- Nguyễn Văn Sơn\r\n- Phạm Thu Trang\r\n- Đặng Khắc Toàn\r\n- Nguyễn Duy Vũ\r\n- Đặng Việt Vũ\r\n\r\nMọi ý kiến, thắc mắc xin gửi về hòm thư:\r\n- nguyenvanson_t59@hus.edu.vn\r\n- phamthutrang_t59@hus.edu.vn\r\n- dangkhactoan_t59@hus.edu.vn\r\n- nguyenduyvu_t59@hus.edu.vn\r\n- dangvietvu_t59@hus.edu.vn");
		scrollPane.setViewportView(txtrPhnMmQun);
		
	}
}
