import java.io.Serializable;
 
public class HocSinh implements Serializable {
 
    private String mahs, tenhs;
   // private int tenhs;
    private float diem;
    private String ghichu;
 
    //Các hàm getter và setter
    public String getMaHS() {
        return mahs;
    }
 
    public void setMaHS(String maHS) {
        this.mahs = maHS;
    }
 
    public String getTenHS() {
        return tenhs;
    }
 
    public void setTenHS(String tenHS) {
        this.tenhs = tenHS;
    }
 
    public float getDiem() {
        return diem;
    }
 
    public void setDiem(float Diem) {
        this.diem = Diem;
    }
 
    public String getGhiChu() {
        return ghichu;
    }
 
    public void setGhiChu(String ghiChu) {
        this.ghichu = ghiChu;
    }
 
    // Phương thức khởi tạo không có tham số
    public HocSinh() {
        this("","",0,"");
    }
 
    public HocSinh(String string, String string2, float i, String string3) {
		// TODO Auto-generated constructor stub
	}

	// Phương thức khởi tạo có tham số
    public void HocSinh(String maHS, String tenHS, float Diem, String ghiChu) {
        this.mahs = maHS;
        this.tenhs = tenHS;
        this.diem = Diem;
        this.ghichu = ghiChu;
    }
}