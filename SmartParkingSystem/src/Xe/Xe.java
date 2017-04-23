package Xe;

/**
 * Lưu trữ thông tin về xe
 * @author Nguyễn Duy Vũ
 * 
 */
public class Xe {
	private String id;
	private String liscensePlate;
	private String type;
	private String timeIn;
	private String timeOut;
	private String typeOfTicket;
	private String location;
	private String money;

	/**
	 * Hàm dựng của lớp Xe
	 * @param id Số vé
	 * @param liscensePlate Biển kiểm soát
	 * @param type Loại xe
	 * @param timeIn Thời gian vào
	 * @param typeOfTicket Loại vé
	 * @param location Vị trí
	 * @param timeOut Thời gian ra
	 * @param money Giá vé
	 */
	public Xe(String id, String liscensePlate, String type, String timeIn,
			String typeOfTicket, String location, String timeOut, String money) {
		super();
		this.id = id;
		this.liscensePlate = liscensePlate;
		this.type = type;
		this.timeIn = timeIn;
		this.typeOfTicket = typeOfTicket;
		this.location = location;
		this.timeOut = timeOut;
		this.money = money;

	}

	/**
	 * @return Lấy ra giá vé
	 */
	public String getMoney() {
		return money;
	}

	/**
	 * @return Lấy ra thời gian ra
	 */
	public String getTimeOut() {
		return timeOut;
	}

	/**
	 * @return Lấy ra Số vé
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return Lấy ra Biển kiểm soát
	 */
	public String getLiscensePlate() {
		return liscensePlate;
	}

	/**
	 * @return Lấy ra Loại xe
	 */
	public String getType() {
		return type;
	}

	/**
	 * @return Lấy ra thời gian vào
	 */
	public String getTimeIn() {
		return timeIn;
	}

	/**
	 * @return Lấy ra Loại vé
	 */
	public String getTypeOfTicket() {
		return typeOfTicket;
	}

	/**
	 * @return Lấy ra vị trí
	 */
	public String getLocation() {
		return location;
	}

}
