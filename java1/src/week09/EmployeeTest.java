package week09;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeTest {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int i;
		int n = scan.nextInt();
		scan.nextLine();

		ArrayList<Employee> emps = new ArrayList<Employee>();
		inputEmployee(emps, n);

		System.out.println("Tong so tien phai tra:");
		System.out.println(salary(emps));

		System.out.println("Nhan vien co muc luong cao nhat:");
		for (i = 0; i < n; i++) {
			if (emps.get(i).getMlcb() == maxSalary(emps))
				System.out.println(emps.get(i));
		}

		System.out.println("Nhan vien co muc luong thap nhat:");
		for (i = 0; i < n; i++) {
			if (emps.get(i).getMlcb() == minSalary(emps))
				System.out.println(emps.get(i));
		}

		ArrayList<Employee> emps1 = new ArrayList<Employee>(sapxep(emps));
		System.out.println("Danh sach sau khi sap xep:");
		for (i = 0; i < n; i++) {
			System.out.println(emps1.get(i));
		}

	}

	private static void inputEmployee(ArrayList<Employee> emps, int n) {
		int i;
		for (i = 0; i < n; i++) {
			Employee emp = new Employee();
			emp.setId(scan.nextLine());
			emp.setName(scan.nextLine());
			emp.setYear(scan.nextLine());
			emp.setMlcb(scan.nextDouble());
			scan.nextLine();
			emps.add(emp);
		}
	}

	private static double salary(ArrayList<Employee> emps) {
		double sum = 0;
		int i;
		for (i = 0; i < emps.size(); i++) {
			sum += emps.get(i).getMlcb() * 30;
		}
		return sum;

	}

	private static double maxSalary(ArrayList<Employee> emps) {
		double max = emps.get(0).getMlcb();
		int i;
		for (i = 0; i < emps.size(); i++) {
			if (emps.get(i).getMlcb() > max)
				max = emps.get(i).getMlcb();
		}
		return max;
	}

	private static double minSalary(ArrayList<Employee> emps) {
		double min = emps.get(0).getMlcb();
		int i;
		for (i = 0; i < emps.size(); i++) {
			if (emps.get(i).getMlcb() < min)
				min = emps.get(i).getMlcb();
		}

		return min;
	}

	private static ArrayList<Employee> sapxep(ArrayList<Employee> emps) {
		int i, j, n = emps.size();
		Employee temp = new Employee();
		for (i = 0; i < n - 1; i++) {
			for (j = i + 1; j < n; j++) {
				if (emps.get(i).getMlcb() > emps.get(j).getMlcb()) {

					temp = emps.get(i);
					emps.set(i, emps.get(j));
					emps.set(j, temp);
					
				}
			}
		}
		return emps;
	}
}
