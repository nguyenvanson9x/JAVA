import java.util.ArrayList;
import java.util.Scanner;

public class Test {
	private static Scanner scan;

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();
		scan = new Scanner(System.in);
		System.out.println("Khoi tao danh sach: ");
		// khoi tao danh sach
		input(arr);

		// 3.2
		int size = arr.size();
		if (size < 5)
			System.out.println("3.2: Null");
		else if (checkNguyenTo(arr.get(4)))
			System.out.println(arr.get(4) + " La so nguyen to");
		else
			System.out.println(arr.get(4) + " Khong la so nguyen to");

		// 3.3
		average(arr);

	}

	private static void input(ArrayList<Integer> arr) {
		String value;
		while (true) {
			value = scan.nextLine();
			if (value.compareTo("#") == 0)
				break;
			try {
				arr.add(Integer.parseInt(value));
			} catch (NumberFormatException e) {
				System.out.println("Khong duoc nhap chu");
				break;
			}

		}
	}

	private static boolean checkNguyenTo(int x) {
		if (x > 1) {
			for (int i = 2; i <= (x / 2); i++) {
				if (x % i == 0)
					return false;
			}
		} else
			return false;
		return true;
	}

	private static void average(ArrayList<Integer> arr) {
		int n = arr.size();
		int sum = 0, count = 0;
		double avr;
		for (int i = 0; i < n; i++) {
			if (arr.get(i) > 0 && arr.get(i) % 10 == 0) {
				sum += arr.get(i);
				count++;
			}
		}
		if (count > 0)
			System.out.println("Trung binh: " + sum / count);
		else
			System.out.println("3.3: Null");
	}

}
