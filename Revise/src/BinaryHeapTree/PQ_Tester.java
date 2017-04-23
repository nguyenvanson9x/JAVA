package BinaryHeapTree;

public class PQ_Tester {
	public static void main(String[] args) {
		UnOrderedPriorityQueue<Integer> q = new UnOrderedPriorityQueue<>(10);
		
		q.insert(3);
		q.insert(100);
		q.insert(65);
		q.insert(12);
		
		q.insert(63);
		q.deleteMax();
		q.print();
	}
}
