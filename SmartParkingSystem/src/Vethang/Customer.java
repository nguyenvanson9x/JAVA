package Vethang;

/**
 * Đối tượng lưu trữ thông tin của Vé tháng
 * @author Phạm Thu Trang
 * 
 */
public class Customer {
	private int Mathe;
	private String Loaixe;
	private String BKS;
	private String timeStart;
	private String timeEnd;
	private int Giave;
	private String photo;

	/**
	 * Hàm dựng của lớp Customer
	 * @param mathe Mã thẻ
	 * @param bks Biển kiểm soát
	 * @param loaixe Loại xe
	 * @param ngaybatdau Ngày bắt đầu
	 * @param ngayketthuc Ngày kết thúc
	 * @param giave Giá vé
	 * @param photo Đường dẫn ảnh tệp ảnh
	 */
	public Customer(int mathe, String bks, String loaixe, String ngaybatdau,
			String ngayketthuc, int giave, String photo) {
		super();
		Mathe = mathe;
		Loaixe = loaixe;
		BKS = bks;
		this.timeStart = ngaybatdau;
		this.timeEnd = ngayketthuc;
		Giave = giave;
		this.photo = photo;
	}

	/**
	 * @return Lấy ra đường dẫn của tệp ảnh
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * @return Lấy ra thời gian đăng ký
	 */
	public String getTimeStart() {
		return timeStart;
	}

	/**
	 * @return Lấy ra Thời gian hết hạn
	 */
	public String getTimeEnd() {
		return timeEnd;
	}

	/**
	 * @return Lấy ra Mã thẻ
	 */
	public int getMathe() {
		return Mathe;
	}

	/**
	 * @return Lấy ra Loại xe
	 */
	public String getLoaixe() {
		return Loaixe;
	}

	/**
	 * @return Lấy ra Biển kiểm soát
	 */
	public String getBKS() {
		return BKS;
	}

	/**
	 * @return Lấy ra Giá vé
	 */
	public int getGiave() {
		return Giave;
	}

}
