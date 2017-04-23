package demo;

public class hoanvi {
	public static void binaryString(int[] a, int i, int n) {
		if (i == n) {
			for (int j = 0; j < a.length; j++) {
				System.out.print(a[j]);
			}
			System.out.println();
		} else {
			for (int j = i; j <= n; j++) {
				//a[i] = j;
				swap(a,i,j);
				binaryString(a, i + 1, n);
				swap(a,i,j);
			}
		}
	}

	public static void swap(int[] b, int i, int j) {
		int x = b[i];
		b[i] = b[j];
		b[j] = x;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3 };
		binaryString(a, 0, a.length - 1);
	}
}
