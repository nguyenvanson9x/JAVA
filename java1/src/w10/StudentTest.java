package w10;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentTest {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int i, n;

		System.out.print("Nhap so sinh vien: ");
		n = scan.nextInt();
		scan.nextLine();
		ArrayList<Student> stus = new ArrayList<Student>();

		inputStudent(stus, n);
		outputStudent(stus);
		System.out.print(sumFee(stus));

		System.out.println("Hoc phi:");
		for (i = 0; i < n; i++) {
			System.out.println(stus.get(i).getFee());
		}
		System.out.println("Sinh vien co hoc phi thap nhat:");
		for (i = 0; i < n; i++) {
			if (stus.get(i).getFee() == minFee(stus))
				System.out.println(stus.get(i));
		}

		ArrayList<Student> sort = sort(stus);
		for (i = 0; i < n; i++) {
			System.out.println(sort.get(i));

		}
	}

	public static void inputStudent(ArrayList<Student> stus, int n) {
		int i, type;

		for (i = 0; i < n; i++) {
			type = scan.nextInt();
			scan.nextLine();
			if (type == 0) {
				Student bt = new Student();

				bt.setId(scan.nextLine());

				bt.setName(scan.nextLine());

				bt.setLop(scan.nextLine());

				bt.setYear(scan.nextInt());

				bt.setFee(scan.nextDouble());
				scan.nextLine();
				stus.add(bt);
			}
			if (type == 1) {
				sv_uutien bt = new sv_uutien();
				bt.setId(scan.nextLine());
				bt.setName(scan.nextLine());
				bt.setLop(scan.nextLine());
				bt.setYear(scan.nextInt());
				bt.setFee(scan.nextDouble());
				bt.setType(scan.nextDouble());
				scan.nextLine();
				stus.add(bt);
			}
			if (type == 2) {
				sv_ngheo bt = new sv_ngheo();
				bt.setId(scan.nextLine());
				bt.setName(scan.nextLine());
				bt.setLop(scan.nextLine());
				bt.setYear(scan.nextInt());
				bt.setFee(scan.nextDouble());
				scan.nextLine();
				stus.add(bt);

			}

		}
	}

	public static void outputStudent(ArrayList<Student> stus) {
		int i;
		for (i = 0; i < stus.size(); i++) {
			System.out.print(stus.get(i));
			System.out.println();
		}
	}

	public static double sumFee(ArrayList<Student> stus) {
		int i;
		double sum = 0;
		for (i = 0; i < stus.size(); i++) {
			sum += stus.get(i).getFee();
		}
		return sum;
	}

	public static double minFee(ArrayList<Student> stus) {
		double min = stus.get(0).getFee();
		int i;
		for (i = 0; i < stus.size(); i++) {
			if (stus.get(i).getFee() < min)
				min = stus.get(i).getFee();
		}
		return min;
	}

	public static ArrayList<Student> sort(ArrayList<Student> stus) {
		int i, j;
		Student t = new Student();
		for (i = 0; i < stus.size() - 1; i++) {
			for (j = i + 1; j < stus.size(); j++) {
				if (stus.get(i).getFee() > stus.get(j).getFee()) {
					t = stus.get(i);
					stus.set(i, stus.get(j));
					stus.set(j, t);
				}
			}
		}
		return stus;
	}

}
