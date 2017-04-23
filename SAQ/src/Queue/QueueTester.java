package Queue;

public class QueueTester {
	public static void main(String[] args) {
		QueueAsLinkedList<Object> q = new QueueAsLinkedList<Object>();
		for (int i = 0; i < 10; i++) {
			q.enqueue(i);
		}
		q.dequeue();
		q.print();
	}
}
