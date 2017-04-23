package QueueAsLinkList;

public class QueueAsLinkList<E> implements Queue<E> {
	class Node {
		E element;
		Node next;
	}
	
	private Node first, last;
	@Override
	public void enqueue(E e) {
		// TODO Auto-generated method stub
		Node node = new Node();
		node.element = e;
		node.next = null;
		
		if (last != null)
			last.next = node;
		else
			first = node;
		last = node;
		
	}

	@Override
	public E dequeue() {
		// TODO Auto-generated method stub
		if (! isEmpty()) {
			Node temp = first;
			E e = temp.element;
			first = temp.next;
			
			if (temp == last)
				last = null;
			return e;
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return first == null;
	}
	
	public void print() {
		Node node = first;
		while (node != null) {
			System.out.print(node.element + " ");
			node = node.next;
		}
	}

}
