package revise_31_5_2017;

public class greedy_bag {
	private static Integer[] p = { 6, 30, 25, 2 }; // price
	private static Integer[] w = { 4, 15, 10, 2 }; // weight
	private static int[] x;
	private static int n, W = 30;

	public static void main(String[] args) {
		n = p.length;
		x = new int[n];
		System.out.println("Khoi luong toi da: " + W);
		greed_bag_1();
	}

	private static void greed_bag_1() {
		int i, sum_price, sum_weight;
		sum_price = 0;
		sum_weight = 0;

		sort(p, w);
		System.out.println("Weight\t" + "Price" + "\tCount");
		for (i = 0; i < n; i++) {
			// moi loai chon 1 lan
			// if (sum_weight + w[i] <= C) {
			// System.out.println(w[i] + "\t" + p[i]);
			// sum_price += p[i];
			// sum_weight += w[i];
			// }

			// moi loai chon nhieu lan
			x[i] = W / w[i];
			W -= x[i] * w[i];
			System.out.println(w[i] + "\t" + p[i] + "\t" + x[i]);
			sum_price += p[i] * x[i];
			sum_weight += w[i] * x[i];
		}
		System.out.println("Tong khoi luong: " + sum_weight);
		System.out.println("Tong gia tri: " + sum_price);

	}

	private static void sort(Integer[] price, Integer[] weight) {
		int i, j, n = price.length;
		Double[] temp = new Double[n];

		for (i = 0; i < n; i++)
			temp[i] = (double) price[i] / weight[i];

		for (i = 0; i < n - 1; i++)
			for (j = i + 1; j < n; j++)
				if (temp[i] <= temp[j]) {
					swap(price, i, j);
					swap(weight, i, j);
					swap(temp, i, j);
				}
	}

	private static <E extends Comparable<E>> void swap(Comparable<E>[] arr, int i, int j) {
		Comparable<E> temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
