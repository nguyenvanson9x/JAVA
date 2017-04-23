package BinaryHeapTree;

public class UnOrderedPriorityQueue<Key extends Comparable<Key>> implements MaxPriorityQueue<Key> {
	private Key[] queue;
	private int n;

	public UnOrderedPriorityQueue(int m) {
		// TODO Auto-generated constructor stub
		queue = (Key[]) new Comparable[m];
		n = 0;
	}

	@Override
	public void insert(Key k) {
		// TODO Auto-generated method stub
		queue[n++] = k;

	}

	@Override
	public Key deleteMax() {
		// TODO Auto-generated method stub
		int maxId = 0;
		for (int i = 0; i < n; i++) {
			if (queue[i].compareTo(queue[maxId]) > 0)
				maxId = i;
		}
		swap(maxId, n - 1);
		return queue[n--];
	}

	private void swap(int maxId, int i) {
		// TODO Auto-generated method stub
		Key temp = queue[maxId];
		queue[maxId] = queue[i];
		queue[i] = temp;
		
	}

	@Override
	public Key max() {
		// TODO Auto-generated method stub
		Key max = queue[0];
		for (int i = 0; i < n; i++) {
			if (queue[i].compareTo(max) > 0)
				max = queue[i];
		}
		return max;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return n == 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return n;
	}
	
	public void print() {
		for (int i = 0; i < n; i++) {
			System.out.print(queue[i] + " ");
		}
	}

}
