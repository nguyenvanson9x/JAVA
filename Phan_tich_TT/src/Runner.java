

public class Runner {
	public static void main(String[] args) {
		Util.phantich_nguyento_2(10);
		System.out.println();
		Util.intoBinary_2(3);
		System.out.println();

		Util.HaNoi_Tower(4, "A", "B", "C");
		int[] a = { 0, 1, 9, 45, 50, 61 };
		System.out.println("Vi tri: " + Util.BinarySearch_2(a, 0, a.length, 0));
		
		Util.sinh_so(10);
	}

}
