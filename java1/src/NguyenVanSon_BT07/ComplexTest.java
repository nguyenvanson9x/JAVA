package NguyenVanSon_BT07;

import java.util.Scanner;

public class ComplexTest {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		double m, n, p, q, t;

		System.out.println("Nhap so phuc a:");
		System.out.print("Phan thuc: ");
		m = scan.nextDouble();
		System.out.print("Phan ao: ");
		n = scan.nextDouble();

		System.out.println("Nhao so phuc b:");
		System.out.print("Phan thuc: ");
		p = scan.nextDouble();
		System.out.print("Phan ao: ");
		q = scan.nextDouble();

		System.out.print("Nhap n = ");
		t = scan.nextInt();

		ComplexNumber a = new ComplexNumber(m, n);
		ComplexNumber b = new ComplexNumber(p, q);

		System.out.println("Hai so phuc vua nhap:");
		System.out.println("a = " + a.toString());
		System.out.println("b = " + b.toString());

		System.out.print("Tong hai so phuc: a + b =  ");
		System.out.println(a.add(b));

		System.out.print("Hieu hai so phuc: a - b = ");
		System.out.println(a.subtract(b));

		System.out.print("Tich hai so phuc: a * b = ");
		System.out.println(a.multiply(b));

		System.out.print("Thuong hai so phuc: a / b = ");
		System.out.println(a.divide(b));

		System.out.println("a^n = " + a.pow(t));
		System.out.println("b^n = " + b.pow(t));

	}
}
