public class FunctionCallMain {
	private static int a = 0;

	public static void main(String[] args) {
		// kiem tra chuong trinh chay 2 lan se dung lại, tránh trường hợp lặp vô
		// hạn
		if (a == 2)
			System.exit(0);
		else
			++a;
		System.out.println("This is main");
		callMain();

	}

	public static void callMain() {
		System.out.println("This is a function call main function");
		main(new String[] { "Quan" });
	}
}