import java.util.Scanner;

public class aaa {
	public static void printStars() {
		int i;
		for (i = 1; i <= 20; i++)
			System.out.print("*");
	}

	public static String createContract() {
		Scanner scan = new Scanner(System.in);
		int n;// STT
		String z = "";// danh sach cac nhan vien
		int y = 0;// tong so luong phai tra

		while (true) {
			n = scan.nextInt();
			if (n == 0)
				break;
			if (n >= 1 && n <= 10) {
				continue;
			}
			if (n >= 1 || n <= 10) {
				if (n == 1) {
					int m = 50000;
					y += m;
					z += ("\n" + m + " Nguyen Van A");
				} else if (n == 2) {
					int m = 45000;
					y += m;
					z += ("\n" + m + " Tran Van Chinh");
				} else if (n == 3) {
					int m = 100000;
					y += m;
					z += ("\n" + y + " Nguyen Thi Van");
				} else if (n == 4) {
					int m = 85000;
					y += m;
					z += ("\n" + y + " Cao Thuy Anh");
				} else if (n == 5) {
					int m = 100000;
					y += m;
					z += ("\n" + y + " Bui Cong Vuong");
				} else if (n == 6) {
					int m = 110000;
					y += m;
					z += ("\n" + y + " Vu Thi Anh");
				} else if (n == 7) {
					int m = 90000;
					y += m;
					z += ("\n" + y + " Ha Lan Huong");
				} else if (n == 8) {
					int m = 80000;
					y += m;
					z += ("\n" + y + " Nguyen Thi Ngoc");
				} else if (n == 9) {
					int m = 60000;
					y += m;
					z += ("\n" + m + " Nguyen Thi Hai Yen");
				} else {
					int m = 100000;
					y += m;
					z += ("\n" + y + " Vu Thi Le");
				}
			}
		}
		return (z + "\n" + "y = " + y);
	}

	public static void main(String args[]) {
		printStars();
		System.out.println(createContract());
		printStars();
	}

}