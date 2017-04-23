package ex07_3;

import java.util.Scanner;

public class EmployeeTest {
	static Scanner scan = new Scanner(System.in);

	public static void inputMember(Employee[] empl) {
		int i;
		for (i = 0; i < empl.length; i++) {
			System.out.println("Nhap thong tin cua nhan vien thu " + (i + 1)
					+ ":");
			empl[i] = new Employee();
			empl[i].id = scan.nextLine();
			empl[i].name = scan.nextLine();
			empl[i].year = scan.nextLine();
			empl[i].mlcb = scan.nextDouble();
			scan.nextLine();
		}
	}

	public static double[] Salary(Employee[] empl) {
		int i;
		double[] salary = new double[empl.length];
		for (i = 0; i < empl.length; i++) {
			salary[i] = empl[i].mlcb * 30;
		}

		return salary;
	}

	public static void sumSalary(double[] salary) {
		int i;
		double sum = 0;
		for (i = 0; i < salary.length; i++) {
			sum += salary[i];
		}
		System.out.println("Tong so tien phai tra:" + sum);
	}

	public static double maxSalary(double[] salary) {
		double max = salary[0];
		int i;
		for (i = 0; i < salary.length; i++) {
			if (salary[i] > max)
				max = salary[i];
		}

		return max;
	}

	public static Employee[] Sapxep(Employee[] empl) {

		int i, j, n = empl.length;
		double t;
		for (i = 0; i < n - 1; i++) {
			for (j = i + 1; j < n; j++) {
				if (empl[i].mlcb > empl[j].mlcb) {
					t = empl[i].mlcb;
					empl[i].mlcb = empl[j].mlcb;
					empl[j].mlcb = t;
				}

			}
		}
		return empl;
	}

	public static double minSalary(double[] salary) {
		double min = salary[0];
		int i;
		for (i = 0; i < salary.length; i++) {
			if (salary[i] < min)
				min = salary[i];
		}
		return min;
	}
	

	public static void main(String[] args) {

		int i, n;
		n = scan.nextInt();
		scan.nextLine();
		Employee[] empl = new Employee[n];
		inputMember(empl);

		double[] salary = Salary(empl);
		
		Employee[] empl1 = Sapxep(empl);
		
		System.out.println("==.. MENU ..==");
		System.out.println("1. Tong so tien phai tra.");
		System.out.println("2. Nhan vien nhan luong nhieu nhat, it nhat.");
		System.out.println("3. Sap xep theo thu tu tang dan.");
		System.out.println();
		System.out.print("Lua chon: ");
		int choice = scan.nextInt();
		switch (choice) {
		case 1:
			sumSalary(salary);
			break;
		case 2:
			System.out.println("Nhan vien nhan duoc luong nhieu nhat:");
			for (i = 0; i < n; i++) {
				if (salary[i] == maxSalary(salary))
					System.out.println(empl[i].toString());
			}
			System.out.println("Nhan vien nhan duoc luong it nhat:");
			for (i = 0; i < n; i++) {
				if (salary[i] == minSalary(salary))
					System.out.println(empl[i].toString());
			}
			break;
		case 3:
			System.out.println("Danh sach nhan vien sau khi sap xep:");
			for (i = 0; i < n; i++) {
				System.out.println(empl1[i].toString());
				System.out.println();
			}
			break;
		}
	}
}
