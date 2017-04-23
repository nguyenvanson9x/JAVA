
public class Counter {
	void count(int n){
		if (n <0){
			System.out.println("End");
		} else if (n >= 0){
				System.out.println(n);
				count(n-1);
		}
	}
	public static void main(String[] args) {
		new Counter().count(10);
	}
}
