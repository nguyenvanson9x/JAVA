package cay;

public interface SymBolTable<Key extends Comparable<Key>,Value> {
	void put(Key k,Value v);
	Value get(Key k);
	void delete(Key k);
	boolean contains(Key k);
	boolean isEmpty();
	Iterable<Key> keys();
	int size();

}
