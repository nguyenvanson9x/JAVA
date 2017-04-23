package linklist;

public class testarr {
	public static void main(String[] args) {
		ArraySymBolTable1<Integer, String>a=new ArraySymBolTable1<>(10);
		a.put(1, "a");
		a.put(2, "b");
		a.put(12, "cong");
		a.put(21, "hoa");
		a.put(34, "xa");
		a.put(44, "hoi");
		System.out.println(a.get(1));
		System.out.println("hang cua");
		System.out.println(a.rank(44));
		a.print();
	}

}
