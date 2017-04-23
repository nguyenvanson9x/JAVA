package Xe;

/**
 * Chuyển đổi kiểu dữ liệu
 * @author Nguyễn Văn Sơn
 * 
 */
public class Convert {
	/**
	 * Chuyển dữ liệu từ giao diện thành dữ liệu để nhập vào database
	 * @param GUI Dữ liệu trên giao diện
	 * @return Trả về dữ liệu
	 */
	public static String GUI_To_DB(String GUI) {
		String DB = "";
		switch (GUI) {
		case "Xe đạp":
			DB = "Xe dap";
			break;
		case "Xe máy":
			DB = "Xe may";
			break;
		case "Xe ô tô":
			DB = "Xe o to";
			break;
		case "Quản lý":
			DB = "Quan ly";
			break;
		case "Nhân viên":
			DB = "Nhan vien";
			break;
			default:
				DB = GUI;
		}
		return DB;
	}

	/**
	 * Chuyển dữ liệu từ database để hiện thị lên giao diện
	 * @param DB Dữ liệu trong database
	 * @return Trả về dữ liệu
	 */
	public static String DB_To_GUI(String DB) {
		String GUI = "";
		switch (DB) {
		case "Xe dap":
			GUI = "Xe đạp";
			break;
		case "Xe may":
			GUI = "Xe máy";
			break;
		case "Xe o to":
			GUI = "Xe ô tô";
			break;
		case "Quan ly":
			GUI = "Quản lý";
			break;
		case "Nhan vien":
			GUI = "Nhân viên";
			break;
		default:
			break;
		}
		return GUI;
	}
}
