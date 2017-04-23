package revise;

public class ATM {
	private static int[] x, xbest, tmax, t = { 10, 75, 50, 20, 100, 30 };
	private static int S, sum = 0, count, n, best;

	public static void main(String[] args) {
		n = t.length;
		best = n + 1;
		count = 0;
		S = 40;
		x = new int[n];
		xbest = new int[n];
		tmax = tmax();
		ATM_Machine(0);
		if (!check())
			System.out.println("Not");
		else
			ket_qua();
	}

	private static void ATM_Machine(int i) {

		if ((count + (S - sum) / tmax[i]) > best)
			return;
		else {
			int j;
			for (j = 0; j <= 1; j++) {
				x[i] = j;
				count += x[i];
				sum += x[i] * t[i];
				if (i == n - 1)
					update();
				else
					ATM_Machine(i + 1);
				count -= x[i];
				sum -= x[i] * t[i];

			}

		}
	}

	private static void update() {
		if (sum == S && count < best) {
			best = count;
			int i;
			for (i = 0; i < n; i++)
				xbest[i] = x[i];
		}

	}

	private static int[] tmax() {
		int i;
		int[] tmax = new int[n];
		tmax[n - 1] = t[n - 1];
		for (i = n - 2; i >= 0; i--)
			if (t[i] > tmax[i + 1])
				tmax[i] = t[i];
			else
				tmax[i] = tmax[i + 1];
		return tmax;
	}

	private static void ket_qua() {
		int i;
		for (i = 0; i < n; i++)
			System.out.print(xbest[i] + " ");
		System.out.println();
	}

	private static boolean check() {
		int i;
		for (i = 0; i < n; i++)
			if (xbest[i] > 0)
				return true;
		return false;
	}

}
