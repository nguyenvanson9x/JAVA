package ex07;

import java.util.Scanner;

public class ComputerTest {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		int n, i;
		double sum = 0;
		n = scan.nextInt();
		scan.nextLine();
		Computer[] coms = new Computer[n];

		inputComputer(coms);

		for (i = 0; i < n; i++) {
			System.out.println(coms[i].toString());
			sum = sum + coms[i].price;
		}
		System.out.println("Gia trung binh cua cac may:" + sum / n);
		System.out.println("May tinh co gia lon nhat:");
		for (i = 0; i < n; i++) {
			if (coms[i].price == maxPrice(coms)) {
				System.out.println(coms[i].toString());
			}
		}
		System.out.println("Cac may co hang san xuat la DELL");
		findDELL(coms);
	}

	public static void inputComputer(Computer[] coms) {
		int n = coms.length;
		int i;
		for (i = 0; i < n; i++) {
			System.out.println("Nhap thong so may thu " + (i + 1) + "");
			coms[i] = new Computer();
			coms[i].name = scan.nextLine();
			coms[i].manu = scan.nextLine();
			coms[i].year = scan.nextLine();
			coms[i].para = scan.nextLine();
			coms[i].price = scan.nextDouble();
			scan.nextLine();
		}
	}

	public static double maxPrice(Computer[] coms) {
		int i;
		double max = coms[0].price;
		for (i = 0; i < coms.length; i++) {
			if (coms[i].price > max)
				max = coms[i].price;
		}
		return max;
	}

	public static void findDELL(Computer[] coms) {
		int i;
		for (i = 0; i < coms.length; i++) {
			if (coms[i].manu.compareTo("Dell")==0) {
				System.out.println(coms[i].toString());
			}
		}
	}
}
