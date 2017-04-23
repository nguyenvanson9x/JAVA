package PriorityQueueLinkList;

import java.util.Iterator;

public class Test {
	public static void main(String[] args) {
		ListPriorityQueue<Integer> q = new ListPriorityQueue<>();
		q.insert(10);
		q.insert(12);
		q.insert(9);
		q.insert(2);
		q.insert(30);
		q.insert(42);
		Iterator<Integer> itr = q.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next() + " ");
		}
	}
}
