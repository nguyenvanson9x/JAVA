package linklist;

import java.util.LinkedList;
import java.util.List;

public class LinklistSymbolTable<Key extends Comparable<Key>, Value> extends AbstractSymBolTable<Key, Value> {
	class Pair {
		private Key keys;
		private Value values;

		public boolean equals(Pair other) {
			if (other == null) {
				return false;
			} else {
				if (this.getClass().getName().equals(other.getClass().getName())) {
					Pair t = (Pair) other;
					return keys.equals(t.keys);
				}
				return false;
			}
		}
	}

	private List<Pair> list = new LinkedList<>();

	@Override
	public Value get(Key key) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).keys.compareTo(key) == 0) {
				return list.get(i).values;
			}
		}

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void put(Key key, Value value) {
		Pair p = new Pair();
		p.keys = key;
		p.values = value;
		if (!contains(key)) {
			list.add(p);
		} else {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).keys.compareTo(key) == 0) {
					list.get(i).values = value;
				}
			}
		}
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Iterable<Key> keys() {
		List<Key> key1 = new LinkedList<Key>();
		for (int i = 0; i < list.size(); i++) {
			key1.add(list.get(i).keys);
		}
		return key1;
		// TODO Auto-generated method stub

	}

}
