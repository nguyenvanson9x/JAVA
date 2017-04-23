package vn.vnu.hus.devideconquer;

public class MergeSort {

	public static void merge(int[] array, int left, int middle, int right) {

		int leftArrayEnd = middle - 1;

		int numElements = right - left + 1;
		int[] resultArray = new int[numElements];
		int resultArrayBegin = 0;

		while (left <= leftArrayEnd && middle <= right) {

			if (array[left] <= array[middle]) {

				resultArray[resultArrayBegin++] = array[left++];
			} else {

				resultArray[resultArrayBegin++] = array[middle++];
			}
		}

		while (left <= leftArrayEnd) {

			resultArray[resultArrayBegin++] = array[left++];
		}

		while (middle <= right) {

			resultArray[resultArrayBegin++] = array[middle++];
		}

		for (int i = numElements - 1; i >= 0; i--, right--) {

			array[right] = resultArray[i];
		}
	}

	private static void mergeSort(int[] array, int left, int right) {

		if (left < right) {

			int middle = left + (right - left) / 2;
			mergeSort(array, left, middle);
			mergeSort(array, middle + 1, right);

			merge(array, left, middle + 1, right);
		}
	}

	public static void printResult(int array[]) {

		for (int i = 0; i < array.length; i++) {

			System.out.printf(array[i] + " ");
		}
	}

	public static void main(String[] args) {

		int array[] = { 8, 7, 3, 5, 4, 9, 2 };

		mergeSort(array, 0, array.length - 1);

		printResult(array);
	}

}
