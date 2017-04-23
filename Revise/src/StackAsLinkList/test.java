package StackAsLinkList;

public class test {
	public static void main(String[] args) {
		StackAsLinkList<Integer> s = new StackAsLinkList<Integer>();
		// có thể thay Integer thành Object cho nó rộng :3
		s.push(1);
		s.push(10);
		s.push(30);
		s.push(12);
		s.push(22);
		s.push(4);
		s.push(1996);
		
//		s.pop();
		
		s.print();
	}
}
