package Hethong;

/**
 * Lưu trữ các thông tin về tài khoản
 * @author Nguyễn Văn Sơn
 *
 */
public class HethongUser {
	private int id;
	private String username, password, ten, chucvu;

	/**
	 * Hàm dựng của lớp HethongUser
	 * @param id Mã tài khoản
	 * @param username Tên tài khoản
	 * @param password Mật khẩu
	 * @param ten Tên người dùng
	 * @param chucvu Chức vụ người dùng
	 */
	public HethongUser(int id, String username, String password, String ten, String chucvu) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.ten = ten;
		this.chucvu = chucvu;
	}
	
	/**
	 * @return Lấy ra mã của tài khoản
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id Mã tài khoản
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return Lấy ra tên đăng nhập
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username Tên đăng nhập
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return Lấy ra mật khẩu của tài khoản
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password Mật khẩu
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return Lấy ra tên người sử dụng tài khoản đó
	 */
	public String getTen() {
		return ten;
	}

	/**
	 * @param ten Tên người dùng
	 */
	public void setTen(String ten) {
		this.ten = ten;
	}

	/**
	 * @return Lấy ra tên của Chức vụ
	 */
	public String getChucvu() {
		return chucvu;
	}

	/**
	 * 
	 * @param chucvu Tên chức vụ
	 */
	public void setChucvu(String chucvu) {
		this.chucvu = chucvu;
	}

}
