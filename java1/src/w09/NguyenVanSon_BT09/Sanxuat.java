package w09.NguyenVanSon_BT09;

public class Sanxuat implements Employee {
	private String id, name, date;
	private int day;
	private double luong;

	public double getLuong() {
		return luong;
	}

	public void setLuong(double luong) {
		this.luong = luong;
	}

	public double getSalary() {

		return luong * day / 5;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	@Override
	public String getDepartmentName() {
		
		return "Toi la nhan vien san xuat";
	}

	@Override
	public String toString() {
		return "Id=" + id + ", name=" + name + ", date=" + date
				+ ", day=" + day + ", luong=" + luong + "";
	}
	

}
