import java.util.Scanner;

public class Vampire {
	private static Scanner scan;

	public static boolean isVampire(int n) {

		String str = String.valueOf(n);
		int l = str.length();
		int i, j, t = 0;
		boolean result = false;
		int[] arrayNumber = new int[l + 1];
		int[] mix = new int[l * l + 1];

		for (i = 1; i <= l; i++) {
			arrayNumber[i] = (int) ((n % Math.pow(10, l - i + 1) - n
					% Math.pow(10, l - i)) / Math.pow(10, l - i));
			arrayNumber[l] = n % 10;

		}
		for (i = 1; i <= l; i++) {
			for (j = 1; j <= l; j++) {
				if (arrayNumber[i] != 0) {
					mix[t] = arrayNumber[i] * 10 + arrayNumber[j];
					t++;
				}

			}
		}
		for (i = 0; i <= t - 1; i++) {
			for (j = 0; j <= t - 1; j++) {
				if (mix[i] * mix[j] == n) {
					result = true;
					break;
				}

			}

		}

		return result;

	}

	public static void printStars() {
		for (int i = 1; i <= 20; i++) {
			System.out.print("*");

		}
		System.out.println();
	}

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		System.out.println("Nhap vao so n (co 4 chu so):");
		int n = scan.nextInt();
		printStars();
		if (isVampire(n) == true) {
			System.out.println(n + " la so vampire");
		} else
			System.out.println(n + " khong la so vampire");
		printStars();

	}

}
// 1260,1395,1435,1530,1827,2187,6880