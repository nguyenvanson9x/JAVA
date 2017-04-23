package QueueAsLinkList;

public class QueueTester {
	public static void main(String[] args) {
		QueueAsLinkList<Integer> q = new QueueAsLinkList<Integer>();
		q.enqueue(3);
		q.enqueue(9);
		q.enqueue(43);
		q.enqueue(12);
		q.dequeue();
		q.print();
	}
}
