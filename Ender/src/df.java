import java.util.Scanner;

public class df {
	public static double cosh(double x, double epsilon) {
		double sum = 1, term = 1;
		int i=1;
		while (term > epsilon) {
			
				term = term * x * x / ((i + 1) * (i + 2));
				sum = sum + term;
				i++;
		}
		return sum;
	}

	public static double cos(double x, double epsilon) {
		double sum = 1, term = 1;
		int i=1;;
		while (term > epsilon) {
				term = term * -x * x / ((i + 1) * (i + 2));
				sum = sum + term;
				i++;
			
		}
		return sum;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print(" Nhap x: ");
		double x = scan.nextDouble();
		System.out.print(" Nhap epsilon: ");
		double epsilon = scan.nextDouble();
		System.out.println("cosh(x) = " + cosh(x, epsilon));
		System.out.println("cos(x) = " + cos(x, epsilon));
	}
}