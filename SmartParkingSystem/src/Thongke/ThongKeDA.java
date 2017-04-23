package Thongke;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Connect.connect;

/**
 * Xử lý các vấn đề liên quan đến cơ sở dữ liệu
 * 
 * @author Đặng Việt Vũ
 */
public class ThongKeDA {
	private connect conn = connect.getInstance();

	/**
	 * Đưa dữ liêu từ database lên bảng
	 * 
	 * @param table
	 *            Bảng để hiện thông tin
	 * @param sql
	 *            Câu truy vấn SQL
	 */
	public void loadData(JTable table, String sql) {
		DefaultTableModel model = new DefaultTableModel();
		ResultSet rs = getData(sql);
		try {
			ResultSetMetaData rsMD = rs.getMetaData();
			int colNumber = rsMD.getColumnCount();

			String[] arr = new String[colNumber];
			for (int i = 0; i < colNumber; i++) {
				arr[i] = rsMD.getColumnName(i + 1);
			}
			model.setColumnIdentifiers(arr);

			while (rs.next()) {
				for (int i = 0; i < colNumber; i++) {
					if (rs.getString(i + 1) != null) {
						if (rs.getString(i + 1).equals("Xe dap"))
							arr[i] = "Xe đạp";
						else if (rs.getString(i + 1).equals("Xe may"))
							arr[i] = "Xe máy";
						else if (rs.getString(i + 1).equals("Xe o to"))
							arr[i] = "Xe ô tô";
						else
							arr[i] = rs.getString(i + 1);
					} else
						arr[i] = "0";

				}
				model.addRow(arr);

			}

			table.setModel(model);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Lấy dữ liệu từ cơ sở dữ liệu
	 * 
	 * @param sql
	 *            Câu truy vấn SQL
	 * @return Trả về đối tượng chứa dữ liệu lấy từ database
	 */
	public ResultSet getData(String sql) {
		ResultSet rs = null;
		Statement stmt;

		try {
			stmt = conn.getConnection().createStatement();

			rs = stmt.executeQuery(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

}
