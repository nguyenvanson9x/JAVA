package cay;

public class test {
	public static void main(String[] args) {
		BinarySearchTry<Integer, String> a = new BinarySearchTry<>();
		a.put(1, "a");
		a.put(5, "c");
		a.put(2, "d");
		a.put(3, "b");
		a.put(100, "a");
		a.put(30, "q");
		System.out.println("Chieu cao: " + a.chieucao());
		for (int s : a.keys()) {
			System.out.print(s + " ");
		}
		System.out.println();
		System.out.println("Ket qua: " + a.sum(100));
	}
		
}
