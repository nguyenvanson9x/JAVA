package PriorityQueue;

public interface MaxPQ<Key extends Comparable<Key>> {
	void insert(Key key);
	Key deleteMax();
	Key max();
	boolean isEmpty();
	int size();
}
