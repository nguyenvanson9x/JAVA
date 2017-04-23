package week09.NguyenVanSon_BT08;

public class Employee {
	private String id, name, year;
	private double mlcb;

	public Employee() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", year=" + year
				+ ", mlcb=" + mlcb + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public double getMlcb() {
		return mlcb;
	}

	public void setMlcb(double mlcb) {
		this.mlcb = mlcb;
	}
}
