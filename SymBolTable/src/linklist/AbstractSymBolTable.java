package linklist;

abstract class AbstractSymBolTable<Key extends Comparable<Key>,Value> implements SymBolTable<Key, Value> {
	@Override
	public boolean contains(Key key) {
		// TODO Auto-generated method stub
		return get(key)!=null;
	}
	@Override
	public void delete(Key key) {
		put(key, null);
		// TODO Auto-generated method stub
		
	}
}
