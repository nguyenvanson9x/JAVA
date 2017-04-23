package week09;

import java.util.ArrayList;
import java.util.Scanner;

public class ComputerTest {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int i;
		double sum = 0;
		ArrayList<Computer> coms = new ArrayList<Computer>();
		int n = scan.nextInt();
		scan.nextLine();

		inputComputer(coms, n);

		outputComputer(coms);

		for (i = 0; i < n; i++) {
			sum += coms.get(i).getPrice();
		}
		System.out.println("Gia trung binh: " + sum / n);

		System.out.println("May co gia lon nhat:");
		for (i = 0; i < n; i++) {
			if (coms.get(i).getPrice() == maxPrice(coms))
				System.out.println(coms.get(i));
		}

		System.out.println("Cac may co hang san xuat la DELL:");
		findDELL(coms);

		System.out.println("Danh sach sau khi sap xep:");
		ArrayList<Computer> coms1 = new ArrayList<Computer>(sapxep(coms));
		for (i = 0; i < n; i++) {
			System.out.println(coms1.get(i));
		}

	}

	private static void inputComputer(ArrayList<Computer> coms, int n) {
		int i;
		for (i = 0; i < n; i++) {
			System.out.println("May " + (i + 1) + ":");
			Computer com = new Computer();
			com.setName(scan.nextLine());
			com.setManu(scan.nextLine());
			com.setPara(scan.nextLine());
			com.setYear(scan.nextLine());
			com.setPrice(scan.nextDouble());
			scan.nextLine();
			coms.add(com);
		}
	}

	private static void outputComputer(ArrayList<Computer> coms) {
		int i;
		for (i = 0; i < coms.size(); i++) {
			System.out.println(coms.get(i));
		}
	}

	private static double maxPrice(ArrayList<Computer> coms) {
		double max = coms.get(0).getPrice();
		int i;
		for (i = 0; i < coms.size(); i++) {
			if (coms.get(i).getPrice() > max)
				max = coms.get(i).getPrice();
		}
		return max;
	}

	private static void findDELL(ArrayList<Computer> coms) {
		int i;
		for (i = 0; i < coms.size(); i++) {
			if (coms.get(i).getManu().compareToIgnoreCase("DELL") == 0)
				System.out.println(coms.get(i));
		}
	}

	private static ArrayList<Computer> sapxep(ArrayList<Computer> coms) {
		int i, j, n = coms.size();
		double t;
		for (i = 0; i < n - 1; i++) {
			for (j = i + 1; j < n; j++) {
				if (coms.get(i).getPrice() > coms.get(j).getPrice()) {
					t = coms.get(i).getPrice();
					coms.get(i).setPrice(coms.get(j).getPrice());
					coms.get(j).setPrice(t);
				}

			}
		}
		return coms;
	}
}
