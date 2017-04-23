package BinaryHeapTree;

public interface MaxPriorityQueue<Key extends Comparable<Key>> {
	void insert(Key k);
	Key deleteMax();
	Key max();
	boolean isEmpty();
	int size();
}
