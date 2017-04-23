//Name: Nguyen Van Son
//Ender;
//NguyenVanSon_14000694_K59A2_W1;
public class Complex {
	public static void printComplex(double a, double b, double c, double d) {

		double congR = a + c;
		double congI = b + d;
		double truR = a - c;
		double truI = b - d;
		double nhanR = a * c - b * d;
		double nhanI = a * d + b * c;
		double chiaR = (a * c + b * d) / (c * c + d * d);
		double chiaI = (b * c - a * d) / (c * c + d * d);
		System.out.printf("(%.0f+%.0fi)+(%.0f+%.0fi)=%.0f+%.0fi%n", a, b, c, d,
				congR, congI);
		System.out.printf("(%.0f+%.0fi)-(%.0f+%.0fi)=%.0f+%.0fi%n", a, b, c, d,
				truR, truI);
		System.out.printf("(%.0f+%.0fi)*(%.0f+%.0fi)=%.0f+%.0fi%n", a, b, c, d,
				nhanR, nhanI);
		if (chiaI < 0) {
			System.out.printf("(%.0f+%.0fi)/(%.0f+%.0fi)=%.2f%.2fi%n", a, b,
					c, d, chiaR, chiaI);
		} else {
			System.out.printf("(%.0f+%.0fi)/(%.0f+%.0fi)=%.2f+%.2fi%n", a, b,
					c, d, chiaR, chiaI);
		}

	}

	public static void main(String[] args) {
		double a1 = 4;
		double b1 = 6;
		double c1 = 3;
		double d1 = 8;
		System.out.println("Bo so: a=4;b=6;c=3;d=8");
		printComplex(a1, b1, c1, d1);

	}

}
