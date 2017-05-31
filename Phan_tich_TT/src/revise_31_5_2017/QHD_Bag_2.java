package revise_31_5_2017;

public class QHD_Bag_2 {
	static int n = 5; // số lượng đồ vật
	static int m = 15; // khối lượng tối đa của túi
	static int w[] = { 12, 2, 1, 1, 4 }; // khối lượng mỗi đồ vật
	static int v[] = { 4, 2, 1, 2, 10 }; // giá trị mỗi đồ vật
	static int L[][] = new int[n + 1][m + 1];

	// mỗi đồ vật chọn nhiều lần
	public static void qhd() {

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {

				int a = L[i - 1][j];

				if (w[i - 1] > j) {
					L[i][j] = a;
				} else {
					// chọn vật i với giới hạn trọng lượng là j - w[i - 1]
					int b = L[i][j - w[i - 1]] + v[i - 1]; // lấy thêm vật i
					L[i][j] = a > b ? a : b;
				}
			}
		}
		// Truy vết phương án
		int i = n; // số lượng vật đã có trong túi
		int j = m; // khối lượng của túi
		while (i != 0) {
			if (L[i][j] != L[i - 1][j]) { // nếu có chọn vật thứ i
				System.out.print(i + " "); // in ra túi thứ i
				j = j - w[i - 1]; // bỏ vật thứ i ra khỏi túi
				i++; // truy tiếp L[i][j-w[i-1]]
			}
			i--;
		}
	}

	public static void main(String[] args) {
		qhd();
	}
}
