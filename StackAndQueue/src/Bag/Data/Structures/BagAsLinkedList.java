package Bag.Data.Structures;


public class BagAsLinkedList<E> implements Bag<E>{
	
	private Node bag = null;
	@Override
	public void add(E element) {
		Node node = new Node();
		node.element = element;
		node.next = bag;
		bag = node;
	}

	@Override
	public E remove() {
		if (!isEmpty()){
			E element = bag.element;
			bag = bag.next;
			return element;
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		return bag == null;
	}

	@Override
	public boolean contains(E element) {
		return false;
	}
	
	class Node {
		E element;
		Node next;
	}


}
