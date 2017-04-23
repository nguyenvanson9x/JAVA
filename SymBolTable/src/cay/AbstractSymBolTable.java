package cay;

abstract class AbstractSymBolTable<Key extends Comparable<Key>,Value> implements SymBolTable<Key, Value> {
@Override
public void delete(Key k) {
	// TODO Auto-generated method stub
	put(k, null);
}
@Override
	public boolean contains(Key k) {
		// TODO Auto-generated method stub
		return get(k)!=null;
	}
}
