

public class CopyOfMotorbike {
	
	private String maso,ten,hsx,color,nsx;
	private int soluong;
	private double gia,khoiluong;
	
	public CopyOfMotorbike(){
		
	}
	
	public String getMaso() {
		return maso;
	}
	public void setMaso(String maso) {
		this.maso = maso;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getHsx() {
		return hsx;
	}
	public void setHsx(String hsx) {
		this.hsx = hsx;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getNsx() {
		return nsx;
	}
	public void setNsx(String nsx) {
		this.nsx = nsx;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public double getGia() {
		return gia;
	}
	public void setGia(double gia) {
		this.gia = gia;
	}
	public double getKhoiluong() {
		return khoiluong;
	}
	public void setKhoiluong(double khoiluong) {
		this.khoiluong = khoiluong;
	}

	@Override
	public String toString() {
		return "Motorbike [maso=" + maso + ", ten=" + ten + ", hsx=" + hsx
				+ ", color=" + color + ", nsx=" + nsx + ", soluong=" + soluong
				+ ", gia=" + gia + ", khoiluong=" + khoiluong + "]";
	}
	
}
