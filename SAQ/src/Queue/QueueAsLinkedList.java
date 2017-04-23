package Queue;

public class QueueAsLinkedList<E> implements Queue<E> {
	private Node queue = null;
	private Node rear = null;

	@Override
	public void enqueue(E element) {
		Node node = new Node();
		node.element = element;
		node.next = null;
		if (rear != null) {
			rear.next = node;
		} else {
			queue = node;
		}
		rear = node;

	}

	@Override
	public E dequeue() {
		if (queue != null) {
			Node node = queue;
			E element = node.element;
			queue = node.next;
			if (node == rear) {
				rear = null;
			}
			return element;
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return queue == null;
	}

	public void print() {
		System.out.println(rear.element);
		Node p = queue;
		System.out.println(p.next.element);
		while (p != null) {
			System.out.println(p.element);
			p = p.next;
		}
	}

	class Node {
		E element;
		Node next;
	}

}
