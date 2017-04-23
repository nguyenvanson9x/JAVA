package linklist;

public interface SymBolTable<Key extends Comparable<Key>,Value> {
	Value get(Key key);
	void put(Key key,Value value);
	boolean isEmpty();
	boolean contains(Key key);
	int size();
	void delete(Key key);
	Iterable<Key> keys();
	

}
