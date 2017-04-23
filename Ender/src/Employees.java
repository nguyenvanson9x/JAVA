import java.util.Scanner;

public class Employees {
	private static Scanner scan;

	public static void Id(int n) {
		switch (n) {
		case 1:
			System.out.println(n + " Nguyen Van An");
			break;
		case 2:
			System.out.println(n + " Tran Van Chinh");
			break;
		case 3:
			System.out.println(n + " Nguyen Thi Van");
			break;
		case 4:
			System.out.println(n + " Cao Thuy Anh");
			break;
		case 5:
			System.out.println(n + " Bui Cong Vuong");
			break;
		case 6:
			System.out.println(n + " Vu Thi Anh Ngoc");
			break;
		case 7:
			System.out.println(n + " Ha Lan Huong");
			break;
		case 8:
			System.out.println(n + " Nguyen Thi Ngoc");
			break;
		case 9:
			System.out.println(n + " Nguyen Thi Hai Yen");
			break;
		case 10:
			System.out.println(n + " Vu Thi Le");
			break;

		}
	}

	public static int sum(int x) {

		switch (x) {
		case 1:
			return 50000;
		case 2:
			return 45000;
		case 3:
			return 100000;
		case 4:
			return 85000;
		case 5:
			return 100000;
		case 6:
			return 110000;
		case 7:
			return 45000;
		case 8:
			return 45000;
		case 9:
			return 45000;
		case 10:
			return 45000;
		}

		int money = 0;
		return money;
	}

	public static String createContract() {
		scan = new Scanner(System.in);
		int i = 1, j;
		int tien = 0;
		int[] arrayID = new int[20];
		System.out.println("Nhap vao ma so cua nhan vien:");
		for (i = 1;; i++) {
			arrayID[i] = scan.nextInt();
			j = i;
			if (arrayID[i] < 1 || arrayID[i] > 10 || arrayID[i] == 0) {
				break;
			}

		}
		printStars();
		System.out.println("Cong ty lua chon " + (j - 1) + " nhan vien la:");
		for (i = 1; i <= j; i++) {

			Id(arrayID[i]);
			tien = tien + sum(arrayID[i]);

		}
		System.out.println("Tong so tien phai tra la:" + tien);
		printStars();
		return null;

	}

	public static void printStars() {
		for (int i = 1; i <= 20; i++) {
			System.out.print("*");

		}
		System.out.println();
	}

	public static void main(String[] args) {
		createContract();
	}

}
