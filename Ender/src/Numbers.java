import java.util.Scanner;

public class Numbers {
	private static Scanner nhap;

	public static void countAndSum() {

		int s = 0, count = 0, n;
		nhap = new Scanner(System.in);
		do {
			System.out.print("Nhap n = ");

			n = nhap.nextInt();

		} while (n < 10);

		System.out.print("Nhap vao " + n + " so nguyen: ");
		for (int i = 1; i <= n; i++) {
			int m = nhap.nextInt();
			s = s + m;
			if (m % 2 == 1)
				count = count + 1;
		}
		printStars();
		System.out.println("Tong cua " + n + " so vua nhap la:" + s);
		System.out.println("Co " + count + " so le");
		printStars();

	}

	public static void printStars() {
		for (int i = 1; i <= 20; i++) {
			System.out.print("*");

		}
		System.out.println();
	}

	public static void main(String[] args) {

		countAndSum();

	}

}
