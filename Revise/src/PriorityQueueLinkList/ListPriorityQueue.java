package PriorityQueueLinkList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListPriorityQueue<E> {

	private static final int DEFAULT_MAX_CAPACITY = 100;
	private Node head;
	private int size;

	private class Node {
		private E value;
		private Node next;

		public Node(E value, Node next) {
			this.value = value;
			this.next = next;
		}
	}

	private class NodeIter implements Iterator<E> {
		private ArrayList<E> a = new ArrayList<>();
		private int n;

		public NodeIter() {

			n = size;
			Node p = head;
			while (p != null) {
				a.add(p.value);
				p = p.next;
			}
		}

		public boolean hasNext() {
			return n > 0;
		}

		public E next() {
			if (n == 0)
				throw new NoSuchElementException();
			return a.get(--n);
		}
	}

	public ListPriorityQueue() {
		this.head = null;
		this.size = 0;
	}

	public boolean insert(E object) {
		if (isFull())
			return false;
		if (head == null) {
			head = new Node(object, null);
		} else if (((Comparable<E>) object).compareTo(head.value) < 0) {
			head = new Node(object, head);
		} else {
			Node p = head;
			while (p.next != null && ((Comparable<E>) object).compareTo(p.next.value) >= 0) {
				p = p.next; // or equal to preserve FIFO on equal items
			}
			p.next = new Node(object, p.next);
		}
		++size;
		return true;
	}

	public E remove() {
		if (isEmpty())
			return null;
		E value = head.value;
		head = head.next;
		--size;
		return value;
	}

	public E peek() {
		if (isEmpty())
			return null;
		return head.value;
	}

	public int size() {
		return size;
	}

	public boolean contains(E object) {
		Node p = head;
		while (p != null) {
			if (((Comparable<E>) object).compareTo(p.value) == 0)
				return true;
			p = p.next;
		}
		return false;
	}

	public Iterator<E> iterator() {
		if (isEmpty())
			return null;
		return new NodeIter();
	}

	public void clear() {
		head = null;
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == DEFAULT_MAX_CAPACITY;
	}
}