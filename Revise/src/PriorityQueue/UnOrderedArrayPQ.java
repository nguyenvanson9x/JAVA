package PriorityQueue;

public class UnOrderedArrayPQ<Key extends Comparable<Key>> implements MaxPQ<Key> {
	private Key[] a;
	private int n;
	public UnOrderedArrayPQ(int default_size) {
		super();
		a =(Key[]) new Comparable[default_size];
		n = 0;
	}

	@Override
	public void insert(Key key) {
		// TODO Auto-generated method stub

	}

	@Override
	public Key deleteMax() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Key max() {
		// TODO Auto-generated method stub
		return null;
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
	
	private void downheap(int k, int n) {
		while (2 * k <= n) {
			int j = 2 * k;
			if (j < n && a[j].compareTo(a[j+1]) < 0)
				j++;
			if (a[j].compareTo(a[k]) < 0)
				break;
			swap(a, k, j);
			k = j;
		}
		
	}
	
	private void upheap(int k) {
		while (k > 1 && a[k].compareTo(a[k / 2]) < 0) {
			swap(a, k / 2, k);
			k = k / 2;
		}
	}

	private void swap(Key[] a, int i, int k) {
		// TODO Auto-generated method stub
		Key temp = a[i];
		a[i] = a[k];
		a[k] = temp;
		
	}
}

