import java.util.Scanner;

public class Array {
	static Scanner scan = new Scanner(System.in);

	public static void inputArray(int a[]) {
		int i;
		for (i = 0; i < a.length; i++) {
			a[i] = scan.nextInt();
		}
		for (i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void printIndexOfx(int a[], int x) {
		int i, count = 0;
		System.out.print(x + " xuat hien trong mang tai cac vi tri:");
		for (i = 0; i < a.length; i++) {
			if (x == a[i]) {
				System.out.print(i + 1 + " ");
				count++;
			} else
				continue;
		}

		if (count == 0) {
			System.out.println("Khong tim thay");
		}
		System.out.println();
	}

	public static boolean isPerfectNumber(int k) {
		int i, sum = 0;
		for (i = 1; i < k; i++) {
			if (k % i == 0) {
				sum += i;
			}
		}
		if (sum == k) {
			return true;
		} else
			return false;
	}

	public static boolean isAlternative(int a[]) {
		int i;
		for (i = 0; i < (a.length - 1); i++) {
			if (a[i] * a[i + 1] < 0) {
				continue;
			} else
				return false;
		}
		return true;
	}

	public static int[] deleteRepeatedValues1(int a[]) {
		int[] b = new int[a.length];
		int i, j, t;
		int n = a.length;
		for (i = 0; i < a.length; i++) {
			b[i] = a[i];
		}
		for (i = 0; i < a.length - 1; i++) {
			for (j = i + 1; j < a.length; j++) {
				if (a[i] == a[j]) {
					int index = j;
					for (int k = index + 1; k < a.length; k++) {
						 a[k - 1] = a[k];
					}
					n--;
				}
			}
			System.out.println(a[i]);
		}
		return a;

	//	return a;
	}

	public static void main(String[] args) {
		int n, i;
		n = scan.nextInt();
		int[] a = new int[n];
		inputArray(a);

		int x;
		x = scan.nextInt();
		printIndexOfx(a, x);
		System.out.print("So hoan hao: ");

		for (i = 0; i < n; i++) {
			if (isPerfectNumber(a[i]) == true) {
				System.out.println(a[i] + " ");
			}
		}
		System.out.println();

		if (isAlternative(a) == true) {
			System.out.println("La mang dan dau");
		} else
			System.out.println("Khong la mang dan dau");
		System.out.println(deleteRepeatedValues1(a));

	}
}
