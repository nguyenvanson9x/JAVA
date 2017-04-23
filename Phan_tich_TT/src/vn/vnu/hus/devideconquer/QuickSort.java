package vn.vnu.hus.devideconquer;

public class QuickSort {

	public static void swap(int array[], int i, int j) {

		int x = array[i];
		array[i] = array[j];
		array[j] = x;
	}

	public static void quickSort(int array[], int left, int right) {

		int i = left, j = right, x = array[(left + right) / 2];

		while (i <= j) {
			while (array[i] < x)
				i++;
			while (array[j] > x)
				j--;

			if (i <= j) {

				if (i < j) {

					swap(array, i, j);
				}

				i++;
				j--;
			}

		}
		// printResult(a);
		if (left < j) {
			
			quickSort(array, left, j);
		}

		if (right > i) {
		
			quickSort(array, i, right);
		}
	}

	public static void print(int array[]) {
		
		for (int i = 0; i < array.length; i++) {
		
			System.out.printf(array[i] + " ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = { 8, 7, 3, 5, 4, 9, 2 };
		
		quickSort(array, 0, array.length - 1);
		
		print(array);
	}

}
