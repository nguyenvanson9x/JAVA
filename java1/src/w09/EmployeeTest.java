package w09;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeTest {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int i;

		System.out.print("Nhap so nhan vien: ");
		int n = scan.nextInt();
		scan.nextLine();
		ArrayList<Employee> emps = new ArrayList<Employee>();
		inputEmployee(emps, n);

		System.out.println("Thong tin cua cac nhan vien: ");
		outputEmployee(emps);

		System.out.println("Luong cua cac nhan vien: ");
		salary(emps);
		
		System.out.println("Nhan vien co luong cao nhat:");
		for (i = 0; i < n; i++){
			if (emps.get(i).getSalary() == maxSalary(emps)){
				System.out.println(emps.get(i).toString());
				System.out.println(emps.get(i).getDepartmentName());
				System.out.println();
			}
		}
		for(i = 0; i < n; i++) {
			System.out.println(sort(emps).get(i));
		}
		
	}

	private static void inputEmployee(ArrayList<Employee> emps, int n) {

		int i, type;
		for (i = 0; i < n; i++) {
			// System.out.println("Nhap kieu nhan vien:(0 - san xuat; 1 - van phong): ");
			type = scan.nextInt();
			scan.nextLine();
			if (type == 0) {

				Sanxuat sx = new Sanxuat();
				// System.out.print("ID: ");
				sx.setId(scan.nextLine());

				// System.out.print("Name: ");
				sx.setName(scan.nextLine());

				// System.out.print("Ngay sinh: ");
				sx.setDate(scan.nextLine());

				// System.out.print("So ngay lam viec: ");
				sx.setDay(scan.nextInt());

				// System.out.print("Luong: ");
				sx.setLuong(scan.nextDouble());
				scan.nextLine();
				emps.add(sx);
			} else {

				Vanphong vp = new Vanphong();

				// System.out.print("ID: ");
				vp.setId(scan.nextLine());

				// System.out.print("Name: ");
				vp.setName(scan.nextLine());

				// System.out.print("Ngay sinh: ");
				vp.setDate(scan.nextLine());

				// System.out.print("So ngay lam viec: ");
				vp.setDay(scan.nextInt());

				// System.out.print("Luong: ");
				vp.setLuong(scan.nextDouble());
				scan.nextLine();
				emps.add(vp);
			}
		}
	}

	private static void outputEmployee(ArrayList<Employee> emps) {
		int i;
		for (i = 0; i < emps.size(); i++) {
			System.out.println(emps.get(i).toString());
		}
	}

	private static void salary(ArrayList<Employee> emps) {
		int i;
		for (i = 0; i < emps.size(); i++) {
			System.out.println(emps.get(i).getSalary());
		}
	}

	private static double maxSalary(ArrayList<Employee> emps) {
		double max = Double.MIN_VALUE;
		int i;
		for (i = 0; i < emps.size(); i++) {
			if (emps.get(i).getSalary() > max)
				max = emps.get(i).getSalary();
		}

		return max;
	}
	
	private static ArrayList<Employee> sort(ArrayList<Employee> emps){
		int i, j;
		for (i = 0; i < emps.size() - 1; i++) {
			for (j = i+1; j < emps.size(); j++) {
				if (emps.get(i).getName().compareToIgnoreCase(emps.get(j).getName()) == 1) {
					Employee temp = emps.get(i);
					emps.set(i, emps.get(j));
					emps.set(j, temp);
				}
			}
			
		}
		
		
		return emps;
	}
}
