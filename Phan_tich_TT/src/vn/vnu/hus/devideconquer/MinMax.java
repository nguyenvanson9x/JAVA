package vn.vnu.hus.devideconquer;

public class MinMax {

	public static int min(int a[], int left, int right) {
		if (left == right) {

			return a[left];
		} else {

			int min1 = min(a, left, (left + right) / 2);
			int min2 = min(a, (left + right) / 2 + 1, right);

			if (min1 < min2) {

				return min1;
			} else {

				return min2;
			}
		}
	}

	public static int max(int a[], int l, int r) {
		if (l == r) {

			return a[l];
		} else {

			int max1 = max(a, l, (l + r) / 2);
			int max2 = max(a, (l + r) / 2 + 1, r);

			if (max1 > max2) {
				
				return max1;
			} else {
			
				return max2;
			}
		}
	}

	public static void main(String[] args) {
		
		int array[] = { 3, 5, 5, 7, 1, 79, 34, 145 };
		System.out.println("min = " + min(array, 0, array.length - 1));
		System.out.println("max = " + max(array, 0, array.length - 1));
	}
}
