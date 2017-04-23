package linklist;

public class test {
	public static void main(String[] args) {
		SymBolTable<Integer, Integer> a = new LinklistSymbolTable<>();
		a.put(1, 2);
		a.put(2, 5);
		System.out.println(a.get(1));
	}

}
