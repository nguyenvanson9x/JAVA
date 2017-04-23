package revise;

public class HoanVi {
	private static int N;
	private static int[] x, flag;
	public static void main(String[] args) {
		N = 3;
		x = new int[N];
		flag = new int[N];
		int i;
		for (i = 0; i < N; i++)
			flag[i] = 0;
		hoanvi(0);
	}
	private static void hoanvi(int i) {
		int j;
		for (j = 0; j < N; j++) {
			if (flag[j] == 0) {
				x[i] = j + 1;
				flag[j] = 1;
				if (i < N - 1)
					hoanvi(i + 1);
				else
					ket_qua();
				flag[j] = 0;
			}
		}
	}
	private static void ket_qua() {
		int i;
		for (i = 0; i < N; i++)
			System.out.print(x[i] + " ");
		System.out.println();
	}
	
}
