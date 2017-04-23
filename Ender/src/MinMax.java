//Name: Nguyen Van Son
//Ender;
//NguyenVanSon_14000694_K59A2_W1;
public class MinMax {
	public static void printMinMax(int a, int b) {
		if (a > b) {
			System.out.println("So lon nhat la a");
			System.out.println("So nho nhat la b");
		} else {
			if (a == b) {
				System.out.println("Hai so bang nhau");

			} else {
				System.out.println("So lon nhat la b");
				System.out.println("So nho nhat la a");
			}
		}
	}

	public static int min(int a, int b) {
		if (a < b) {

			return a;
		} else {
			return b;
		}

	}

	public static int max(int a, int b) {

		if (a > b) {
			return a;
		} else {
			return b;
		}

	}

	public static void main(String[] args) {
		int a = 10;
		int b = 100;

		System.out.println("a=" + a + ",b=" + b + "");
		System.out.println("Cach 1:");
		printMinMax(a, b);

		System.out.println("\n");
		System.out.println("Cach 2:");
		if (min(a, b) == max(a, b)) {
			System.out.println("Hai so bang nhau");
		} else {
			if (a == max(a, b)) {
				System.out.println("So lon nhat la a");
				System.out.println("So nho nhat la b");
			} else {

				System.out.println("So lon nhat la b");
				System.out.println("So nho nhat la a");

			}
		}
	}
}
