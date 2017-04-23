package Thongke;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

/**
 * Giao diện của chức năng Thống kê
 * 
 * @author Đặng Việt Vũ
 */
public class GUIThongke extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private final ButtonGroup buttonGroup = new ButtonGroup();

	private JDateChooser dateStart, dateEnd;

	private JRadioButton rdbtnTongxe, rdbtnThongtinxe, rdbtnDoanhThu,
			rdbtnTngXeGui, rdbtnThongTinXeGui, rdbtnTongSoXeTra,
			rdbtnThongTinXeTra;

	private JTable tableTK;

	private ThongKeDA da = new ThongKeDA();

	/**
	 * Hàm dựng của lớp GUIThongke
	 */
	public GUIThongke() {

		setTitle("Thống kê số liệu");
		setFrameIcon(new ImageIcon(
				GUIThongke.class.getResource("/Image/server.png")));
		setBounds(0, 0, 1052, 618);

		JPanel pnTitle = new JPanel();
		pnTitle.setBorder(new EmptyBorder(20, 0, 20, 0));
		getContentPane().add(pnTitle, BorderLayout.NORTH);

		JLabel lblThngK = new JLabel("Thống kê số liệu");
		lblThngK.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblThngK.setForeground(Color.RED);
		pnTitle.add(lblThngK);

		JPanel pnCenter = new JPanel();
		pnCenter.setBorder(new MatteBorder(1, 0, 0, 0, (Color) Color.RED));
		getContentPane().add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(null);

		JPanel pnOrder = new JPanel();
		pnOrder.setBorder(new TitledBorder(null,
				"Danh s\u00E1ch y\u00EAu c\u1EA7u", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		pnOrder.setBounds(10, 11, 1028, 213);
		pnCenter.add(pnOrder);
		pnOrder.setLayout(null);

		JPanel pnSearch = new JPanel();
		pnSearch.setBorder(new TitledBorder(null, "Kho\u1EA3ng th\u1EDDi gian",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnSearch.setBounds(650, 11, 368, 55);
		pnOrder.add(pnSearch);
		pnSearch.setLayout(null);

		JLabel lblT = new JLabel("Từ");
		lblT.setBounds(19, 26, 34, 14);
		pnSearch.add(lblT);

		dateStart = new JDateChooser();
		dateStart.setDateFormatString("yyyy-MM-dd");
		dateStart.setBounds(46, 23, 121, 20);
		pnSearch.add(dateStart);

		JLabel lbln = new JLabel("Đến");
		lbln.setBounds(185, 26, 34, 14);
		pnSearch.add(lbln);

		dateEnd = new JDateChooser();
		dateEnd.setDateFormatString("yyyy-MM-dd");
		dateEnd.setBounds(220, 23, 121, 20);
		pnSearch.add(dateEnd);

		rdbtnTongxe = new JRadioButton("Tổng số xe");
		buttonGroup.add(rdbtnTongxe);
		rdbtnTongxe.setBounds(155, 83, 109, 23);
		pnOrder.add(rdbtnTongxe);

		rdbtnThongtinxe = new JRadioButton("Thông tin xe");
		buttonGroup.add(rdbtnThongtinxe);
		rdbtnThongtinxe.setBounds(155, 121, 109, 23);
		pnOrder.add(rdbtnThongtinxe);

		rdbtnDoanhThu = new JRadioButton("Doanh Thu");
		buttonGroup.add(rdbtnDoanhThu);
		rdbtnDoanhThu.setBounds(155, 160, 109, 23);
		pnOrder.add(rdbtnDoanhThu);

		rdbtnTngXeGui = new JRadioButton("Tổng số xe gửi");
		buttonGroup.add(rdbtnTngXeGui);
		rdbtnTngXeGui.setBounds(419, 83, 148, 23);
		pnOrder.add(rdbtnTngXeGui);

		rdbtnThongTinXeGui = new JRadioButton("Thông tin xe gửi");
		buttonGroup.add(rdbtnThongTinXeGui);
		rdbtnThongTinXeGui.setBounds(419, 121, 148, 23);
		pnOrder.add(rdbtnThongTinXeGui);

		rdbtnTongSoXeTra = new JRadioButton("Tổng số xe trả");
		buttonGroup.add(rdbtnTongSoXeTra);
		rdbtnTongSoXeTra.setBounds(722, 83, 148, 23);
		pnOrder.add(rdbtnTongSoXeTra);

		rdbtnThongTinXeTra = new JRadioButton("Thông tin xe trả");
		buttonGroup.add(rdbtnThongTinXeTra);
		rdbtnThongTinXeTra.setBounds(722, 121, 148, 23);
		pnOrder.add(rdbtnThongTinXeTra);

		JPanel pnReport = new JPanel();
		pnReport.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"),
				"Chi ti\u1EBFt b\u00E1o c\u00E1o", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		pnReport.setBounds(10, 251, 1028, 211);
		pnCenter.add(pnReport);
		pnReport.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 20, 1008, 180);
		pnReport.add(scrollPane);

		tableTK = new JTable();
		scrollPane.setViewportView(tableTK);

		JPanel pnButton = new JPanel();
		pnButton.setBorder(new EmptyBorder(0, 0, 0, 20));
		getContentPane().add(pnButton, BorderLayout.SOUTH);
		pnButton.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		JButton btnInDanhSch = new JButton("Xuất báo cáo");
		btnInDanhSch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				int r = chooser.showSaveDialog(null);
				if (r == JFileChooser.APPROVE_OPTION) {
					File file = chooser.getSelectedFile();
					try {
						FileWriter fw = new FileWriter(file + ".xls");
						BufferedWriter bw = new BufferedWriter(fw);
						DefaultTableModel model = (DefaultTableModel) tableTK
								.getModel();

						for (int i = 0; i < model.getColumnCount(); i++) {
							bw.write(model.getColumnName(i) + "\t");

						}
						bw.write("\n");
						for (int j = 0; j < model.getRowCount(); j++) {
							for (int k = 0; k < model.getColumnCount(); k++) {
								bw.write(model.getValueAt(j, k) + "\t");
							}
							bw.write("\n");
						}
						bw.close();
						JOptionPane.showMessageDialog(null, "Lưu thành công");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null,
								"Lưu thất bại" + e.toString());
					}
				}
			}
		});
		btnInDanhSch.setIcon(new ImageIcon(GUIThongke.class
				.getResource("/Image/excel.png")));
		btnInDanhSch.setHorizontalAlignment(SwingConstants.LEFT);
		pnButton.add(btnInDanhSch);
		action ac = new action();
		rdbtnTongxe.addActionListener(ac);
		rdbtnThongtinxe.addActionListener(ac);
		rdbtnDoanhThu.addActionListener(ac);
		rdbtnThongTinXeGui.addActionListener(ac);
		rdbtnThongTinXeTra.addActionListener(ac);
		rdbtnTngXeGui.addActionListener(ac);
		rdbtnTongSoXeTra.addActionListener(ac);
	}

	/**
	 * Lấy ra giá trị của ngày-tháng-năm từ giao diện
	 * 
	 * @param input
	 *            Ngày tháng trên giao diện
	 * @return Trả về kiểu ngày tháng
	 * @throws NullPointerException
	 *             Lỗi dữ liệu null
	 */
	private String getDate(JDateChooser input) throws NullPointerException {
		Date date;
		String dateOutput = null;
		date = input.getDate();
		dateOutput = new SimpleDateFormat("yyyy-MM-dd").format(date);

		return dateOutput;
	}

	/**
	 * @author Admin Xử lý sự kiện cho các nút chức năng
	 */
	class action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String sql;
			String Start = null;
			String End = null;
			Object o = e.getSource();
			try {
				Start = getDate(dateStart);
				End = getDate(dateEnd);
				if (o == rdbtnTongxe) {
					sql = "Select count(*) as 'Tong xe'  from nhanxe where Thoigianvao between '"
							+ Start + "' AND '" + End + "';";
					da.loadData(tableTK, sql);
				}
				if (o == rdbtnThongtinxe) {
					sql = "select nhanxe.Sove, nhanxe.BKS, xe.Loaixe, nhanxe.Loaive, nhanxe.Thoigianvao, nhanxe.Vitri from nhanxe, xe where (nhanxe.BKS = xe.BKS) and (nhanxe.Thoigianvao between '"
							+ Start + "' AND '" + End + "')";
					da.loadData(tableTK, sql);
				}
				if (o == rdbtnDoanhThu) {
					sql = "Select sum(Tien) as 'Doanh thu' from traxe where Thoigianra between '"
							+ Start + "' AND '" + End + "'";
					da.loadData(tableTK, sql);
				}
				if (o == rdbtnTngXeGui) {
					sql = "select count(*) as 'Tong so xe gui' from nhanxe  where (nhanxe.Thoigianvao between '"
							+ Start
							+ "' AND '"
							+ End
							+ "') and (nhanxe.Trangthai = 'N')";
					da.loadData(tableTK, sql);
				}
				if (o == rdbtnTongSoXeTra) {
					sql = "select count(*) as 'Tong so xe tra' from traxe  where traxe.Thoigianra between '"
							+ Start + "' AND '" + End + "'";
					da.loadData(tableTK, sql);
				}
				if (o == rdbtnThongTinXeGui) {
					sql = "select nhanxe.Sove, nhanxe.BKS, xe.Loaixe, "
							+ "nhanxe.Loaive, nhanxe.Thoigianvao, nhanxe.Vitri "
							+ "from nhanxe, xe "
							+ "where (nhanxe.BKS = xe.BKS) "
							+ "and (nhanxe.Trangthai = 'N')"
							+ "and (Thoigianvao between '" + Start + "' AND '"
							+ End + "')";
					da.loadData(tableTK, sql);
				}
				if (o == rdbtnThongTinXeTra) {
					sql = "select nhanxe.Sove, nhanxe.BKS, xe.Loaixe, "
							+ "nhanxe.Loaive, nhanxe.Thoigianvao, nhanxe.Vitri "
							+ "from nhanxe, xe, traxe "
							+ "where (nhanxe.BKS = xe.BKS) "
							+ "and (nhanxe.Trangthai = 'T') "
							+ "and (traxe.Sove = nhanxe.Sove) "
							+ "and (traxe.Thoigianra between '" + Start
							+ "' AND '" + End + "')";
					da.loadData(tableTK, sql);
				}
			} catch (NullPointerException e1) {
				if (Start == null && End != null) {
					JOptionPane.showMessageDialog(null,
							"Chưa chọn thời điểm đầu");
					buttonGroup.clearSelection();
				} else if (End == null && Start != null) {
					JOptionPane.showMessageDialog(null,
							"Chưa chọn thời điểm cuối");
					buttonGroup.clearSelection();
				} else {
					JOptionPane.showMessageDialog(null,
							"Chưa chọn thời điểm đầu & thời điểm cuối");
					buttonGroup.clearSelection();
				}
			}
		}
	}
}
