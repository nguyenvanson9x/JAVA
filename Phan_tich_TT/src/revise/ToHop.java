package revise;

public class ToHop {
	private static int[] x;
	private static int n, k;
	public static void main(String[] args) {
		n = 9;
		k = 3;
		x = new int[n];
		tohop(1);
	}
	
	private static void tohop(int i) {
		if (i == n) {
			ket_qua();
			return;
		}
		x[i] = 0;
		tohop(i + 1);
		x[i] = 1;
		tohop(i + 1);
	}
	
	private static void ket_qua() {
		int i;
		for (i = 0; i < n; i++)
			if (x[i] == 0)
				System.out.print(i + " ");
		System.out.println();
	}
}
