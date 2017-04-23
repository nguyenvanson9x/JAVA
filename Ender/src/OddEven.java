//Name: Nguyen Van Son
//Ender;
//NguyenVanSon_14000694_K59A2_W1;
public class OddEven {
	public static void printParity(int n) {
		String z;
		z = (n % 2 == 0) ? n + " la so chan" : n + " la so le";
		System.out.println(z);
	}

	public static int odd(int m) {
		
		if (m%2==0) {
			return 1;
		}
		else {
			return 0;
		}

	}

	public static void main(String[] args) {
		int n =22041996;
		System.out.println("Cach 1:");
		printParity(n);
		System.out.print("\n");
		System.out.println("Cach 2:");
		if (odd(n)==1) {
			System.out.println(odd(n));
			System.out.println(n+" la so chan");
		}
		else {
			System.out.println(odd(n));
			System.out.println(n+" la so le");
		}

	}

}
