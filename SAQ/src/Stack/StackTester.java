package Stack;
public class StackTester {
	public static void main(String[] args) {
		StackAsLinkedList<Object> s = new StackAsLinkedList<Object>();
		for (int i = 0; i < 10; i++) {
			s.push(i);
		}
		s.push("Son");
		s.pop();
		s.pop();
		
		s.print();
		
	}
}
