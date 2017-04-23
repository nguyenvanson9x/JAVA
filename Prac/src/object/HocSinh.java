package object;

import java.io.Serializable;

public class HocSinh implements Serializable {

	private String mahs;
	private String tenhs;
	private int diem;
	private String ghichu;

	public String getMahs() {
		return mahs;
	}

	public void setMahs(String mahs) {
		this.mahs = mahs;
	}

	public String getTenhs() {
		return tenhs;
	}

	public void setTenhs(String tenhs) {
		this.tenhs = tenhs;
	}

	public double getDiem() {
		return diem;
	}

	public void setDiem(int diem) {
		this.diem = diem;
	}

	public String getGhichu() {
		return ghichu;
	}

	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}

	public HocSinh(String maHS, String tenHS, int Diem, String ghiChu) {
		this.mahs = maHS;
		this.tenhs = tenHS;
		this.diem = Diem;
		this.ghichu = ghiChu;
	}

	@Override
	public String toString() {
		return ""+mahs+"\t"+tenhs+"\t"+diem+"\t"+ghichu+"";
	}
	
}