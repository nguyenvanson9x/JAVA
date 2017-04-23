package vn.vnu.hus.devideconquer;

public class BinarySearch {

	public static int binarySearch(int array[], int x, int L, int R) {

		if (L == R) {
			return (x == array[L]) ? L : -1;
		} else {
			int M = (R + L) / 2;
			if (x == array[M]) {
				return M;
			} else {
				if (x < array[M]) {
					return binarySearch(array, x, L, M - 1);
				} else {
					return binarySearch(array, x, M + 1, R);
				}
			}
		}

	}

	public static void main(String[] args) {

		int a[] = { 1, 3, 4, 8, 12, 56, 456 };
		int x = 12;
		
		System.out.println(binarySearch(a, x, 0, a.length - 1));

	}

}
