package Prac;

import java.io.Serializable;

public class Student implements Serializable {
	private String name,add,note;
	private double point;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public double getPoint() {
		return point;
	}
	public void setPoint(double point) {
		this.point = point;
	}
	public Student(String name, String add, String note, double point) {
		super();
		this.name = name;
		this.add = add;
		this.note = note;
		this.point = point;
	}
	@Override
	public String toString() {
		return "" + name + " "+  " " + add + " "+" " + note+ " "+ " " + point+"\n";
	}
	
	
	
}
