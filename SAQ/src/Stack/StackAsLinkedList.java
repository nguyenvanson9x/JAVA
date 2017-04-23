package Stack;
public class StackAsLinkedList<E> implements Stack<E> {
	private Node stack = null;

	@Override
	public void push(E element) {
		Node node = new Node();
		node.element = element;
		node.next = stack;
		stack = node;

	}

	@Override
	public E pop() {
		if (!isEmpty()) {
			E element = stack.element;
			stack = stack.next;
			return element;
		}

		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return stack == null;
	}

	public void print() {
		Node p = stack;
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
