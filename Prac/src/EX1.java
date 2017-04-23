import java.io.Serializable;


public class EX1 implements Serializable {
	private int tuoi,nam;
	private String ten, diachi;
	
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	public int getNam() {
		return nam;
	}
	public void setNam(int nam) {
		this.nam = nam;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public EX1() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "tuoi=" + tuoi + ", nam=" + nam + ", ten=" + ten + ", diachi=" + diachi + "\n";
	}
	
	
	
}
