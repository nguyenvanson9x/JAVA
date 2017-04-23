public class Test {
	public static void main(String[] args) {
		Student stu = new Student(1, "An");
		stu.sing();
		// sing(stu); // error ?
		Student.sing(stu);
		stu.addScore(2, 8);
		System.out.println(stu.printString());
		stu.addScore(3, 6);
		System.out.println(stu.printString());
		int i = 0;
		int[] j = { 0 };
		System.out.println("Old values:");
		System.out.println(i + "\t" + j[0]);
		System.out.println(stu.printString());
		Student.doSomething(i, j, stu);
		System.out.println("New values:");
		System.out.println(i + "\t" + j[0]);
		System.out.println(stu.printString());
		int x = 20;
		int [] ys= {10};
		stu.name = "Son";
		stu.doSomething(x,ys,stu);
		System.out.println(x);
		System.out.println(ys[0]);
		System.out.println(stu.name);
	}

}
