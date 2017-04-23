
public class Fibonacy {
	int fib(int n){
		if (n <2)
			return n;
		else
			return fib(n-2) + fib(n-1);
	}
	public static void main(String[] args) {
		System.out.println(new Fibonacy().fib(10));
	}
}
