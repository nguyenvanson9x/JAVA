//Name: Nguyen Van Son
//Ender;
//NguyenVanSon_14000694_K59A2_W1;
public class Fraction {
	public static void printFraction(int a, int b, int c, int d) {
		int tong = a * d + b * c;
		int hieu = a * d - b * c;
		int tich1 = a * c;
		int tich2 = b * d;
		int tich3 = a * d;
		int tich4 = b * c;

		System.out.printf("(%d/%d)\t+\t(%d/%d)\t=\t%d/%d%n", a, b, c, d, tong,
				tich2);
		System.out.printf("(%d/%d)\t-\t(%d/%d)\t=\t%d/%d%n", a, b, c, d, hieu,
				tich2);
		System.out.printf("(%d/%d)\t*\t(%d/%d)\t=\t%d/%d%n", a, b, c, d, tich1,
				tich2);
		System.out.printf("(%d/%d)\t/\t(%d/%d)\t=\t%d/%d%n", a, b, c, d, tich3,
				tich4);
		System.out.println("\n");

	}

	public static void main(String[] args) {
		int a1 = 3;
		int b1 = 6;
		int c1 = 3;
		int d1 = 2;
		printFraction(a1, b1, c1, d1);

	}

}
