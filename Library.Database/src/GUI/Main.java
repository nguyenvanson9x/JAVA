package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JDesktopPane;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.border.EtchedBorder;
import javax.swing.JMenuBar;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;

import javax.swing.SwingConstants;

public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 786, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnNorth = new JPanel();
		pnNorth.setForeground(Color.CYAN);
		contentPane.add(pnNorth, BorderLayout.NORTH);
		pnNorth.setLayout(new BorderLayout(0, 0));
		
		JPanel N_Center = new JPanel();
		pnNorth.add(N_Center);
		N_Center.setLayout(new GridLayout(1, 8, 10, 10));
		
		JMenuBar menuBar = new JMenuBar();
		N_Center.add(menuBar);
		menuBar.setBackground(Color.LIGHT_GRAY);
		menuBar.setMargin(new Insets(10, 10, 10, 10));
		menuBar.setFont(menuBar.getFont().deriveFont(menuBar.getFont().getStyle() | Font.BOLD));
		
		JMenu mnGioiThieu = new JMenu("Gioi thieu");
		
		mnGioiThieu.setFont(new Font("Tahoma", Font.BOLD, 14));
		mnGioiThieu.setHorizontalAlignment(SwingConstants.LEFT);
		
		menuBar.add(mnGioiThieu);
		
		JMenu mnDanhMuc = new JMenu("");
		mnDanhMuc.setFont(new Font("Tahoma", Font.BOLD, 14));
		//	mnDanhMuc.(new ImageIcon(Main.class.getResource("/icon/Biorhythms80.png")));
			menuBar.add(mnDanhMuc);
			
			JMenuItem mntmTacGia = new JMenuItem("Tác giả");
			mntmTacGia.setFont(new Font("Tahoma", Font.BOLD, 14));
			//mntmTacGia.setIcon(new ImageIcon(Main.class.getResource("/icon/callrecorder.png")));
			mnDanhMuc.add(mntmTacGia);
			
			JMenuItem mntmTheLoai = new JMenuItem("Thể loại");
			mntmTheLoai.setFont(new Font("Tahoma", Font.BOLD, 14));
			//mntmTheLoai.setIcon(new ImageIcon(Main.class.getResource("/icon/callrecorder.png")));
			mnDanhMuc.add(mntmTheLoai);
			
			JMenuItem mntmNXB = new JMenuItem("Nhà xuất bản");
			mntmNXB.setFont(new Font("Tahoma", Font.BOLD, 14));
			//mntmNXB.setIcon(new ImageIcon(Main.class.getResource("/icon/callrecorder.png")));
			mnDanhMuc.add(mntmNXB);
			
			JMenuItem mntmNgonNgu = new JMenuItem("Ngôn ngữ");
			mntmNgonNgu.setFont(new Font("Tahoma", Font.BOLD, 14));
			//	mntmNgonNgu.setIcon(new ImageIcon(Main.class.getResource("/icon/callrecorder.png")));
				mnDanhMuc.add(mntmNgonNgu);
				
				JMenuItem mntmTinhTrang = new JMenuItem("Tình trạng");
				mntmTinhTrang.setFont(new Font("Tahoma", Font.BOLD, 14));
				///mntmTinhTrang.setIcon(new ImageIcon(Main.class.getResource("/icon/callrecorder.png")));
				mnDanhMuc.add(mntmTinhTrang);
				
				JMenu mnDauSach = new JMenu("");
				mnDauSach.setFont(new Font("Tahoma", Font.BOLD, 14));
				//mnDauSach.setIcon(new ImageIcon(Main.class.getResource("/icon/babylock.png")));
				menuBar.add(mnDauSach);
				
				JMenuItem mntmQuanLy = new JMenuItem("Quản lý đầu sách");
				mntmQuanLy.setFont(new Font("Tahoma", Font.BOLD, 14));
				//mntmQuanLy.setIcon(new ImageIcon(Main.class.getResource("/icon/apkenv-qml80.png")));
				mnDauSach.add(mntmQuanLy);
				
				JMenuItem mntmThanhLy = new JMenuItem("Thanh Lý");
				mntmThanhLy.setFont(new Font("Tahoma", Font.BOLD, 14));
				//mntmThanhLy.setIcon(new ImageIcon(Main.class.getResource("/icon/apkenv-qml80.png")));
				mnDauSach.add(mntmThanhLy);
				
				JMenu mnMuonTra = new JMenu("");
				//mnMuonTra.setIcon(new ImageIcon(Main.class.getResource("/icon/airattack.png")));
				mnMuonTra.setFont(new Font("Tahoma", Font.BOLD, 14));
				menuBar.add(mnMuonTra);
				
				JMenuItem mntmMuon = new JMenuItem("Mượn");
				mntmMuon.setFont(new Font("Tahoma", Font.BOLD, 14));
				//mntmMuon.setIcon(new ImageIcon(Main.class.getResource("/icon/animaluniverse80.png")));
				mnMuonTra.add(mntmMuon);
				
				JMenuItem mntmTra = new JMenuItem("Trả");
				mntmTra.setFont(new Font("Tahoma", Font.BOLD, 14));
				//mntmTra.setIcon(new ImageIcon(Main.class.getResource("/icon/animaluniverse80.png")));
				mnMuonTra.add(mntmTra);
				
				JMenu mnNguoiDung = new JMenu("");
				mnNguoiDung.setFont(new Font("Tahoma", Font.BOLD, 14));
				//mnNguoiDung.setIcon(new ImageIcon(Main.class.getResource("/icon/AntiMosquito80.png")));
				menuBar.add(mnNguoiDung);
				
				JMenuItem mntmKhach = new JMenuItem("Khách");
				mntmKhach.setFont(new Font("Tahoma", Font.BOLD, 14));
				//mntmKhach.setIcon(new ImageIcon(Main.class.getResource("/icon/barcodecamplus80.png")));
				mnNguoiDung.add(mntmKhach);
				
				JMenuItem mntmNguoiQuanLy = new JMenuItem("Nhân viên");
				mntmNguoiQuanLy.setFont(new Font("Tahoma", Font.BOLD, 14));
				//mntmNguoiQuanLy.setIcon(new ImageIcon(Main.class.getResource("/icon/barcodecamplus80.png")));
				mnNguoiDung.add(mntmNguoiQuanLy);
				
				JMenu mnThongKe = new JMenu("");
				mnThongKe.setFont(new Font("Tahoma", Font.BOLD, 14));
				//mnThongKe.setIcon(new ImageIcon(Main.class.getResource("/icon/autolock.png")));
				menuBar.add(mnThongKe);
				
				JMenuItem mntmThongKe = new JMenuItem("Thống kê");
				mntmThongKe.setFont(new Font("Tahoma", Font.BOLD, 14));
				//mntmThongKe.setIcon(new ImageIcon(Main.class.getResource("/icon/BeautifulSMSMG80.png")));
				mnThongKe.add(mntmThongKe);
				
				JMenu mnHeThong = new JMenu("");
				mnHeThong.setFont(new Font("Tahoma", Font.BOLD, 14));
				//mnHeThong.setIcon(new ImageIcon(Main.class.getResource("/icon/AngryBirds_Orig_Free_80x80.png")));
				menuBar.add(mnHeThong);
				
				JMenu mnThoat = new JMenu("");
				mnThoat.setFont(new Font("Tahoma", Font.BOLD, 14));
				mnThoat.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						System.exit(0);
					}
				});
				
				//mnThoat.setIcon(new ImageIcon(Main.class.getResource("/icon/burn-the-city.png")));
				menuBar.add(mnThoat);
		
		JPanel N_South = new JPanel();
		pnNorth.add(N_South, BorderLayout.SOUTH);
		N_South.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lbStatus = new JLabel("Status");
		
		N_South.add(lbStatus);
		
		JPanel pnCenter = new JPanel();
		contentPane.add(pnCenter, BorderLayout.SOUTH);
		pnCenter.setLayout(new BorderLayout(0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JInternalFrame internalFrame = new JInternalFrame("New JInternalFrame");
		internalFrame.setToolTipText("");
		internalFrame.setMaximizable(true);
		internalFrame.setClosable(true);
		internalFrame.setBounds(10, 11, 700, 323);
		desktopPane.add(internalFrame);
		internalFrame.setVisible(true);
	//	pack();
		
	}
	
	public void loadData() {
		
	}
}
