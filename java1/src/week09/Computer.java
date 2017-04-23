package week09;

public class Computer {
	private String name, manu, para, year;
	private double price;

	public Computer() {

	}
	
	@Override
	public String toString() {
		return "Computer [name=" + name + ", manu=" + manu + ", para=" + para
				+ ", year=" + year + ", price=" + price + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManu() {
		return manu;
	}

	public void setManu(String manu) {
		this.manu = manu;
	}

	public String getPara() {
		return para;
	}

	public void setPara(String para) {
		this.para = para;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
