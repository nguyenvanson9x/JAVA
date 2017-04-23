package linklist;

import java.util.Arrays;

public class ArraySymBolTable1<Key extends Comparable<Key>,Value> extends AbstractSymBolTable<Key, Value> {
	private Key[] keys;
	private Value[] values;
	private int n;
	public ArraySymBolTable1(int m) {
		super();
		keys=(Key[]) new Comparable[m];
		values=(Value[]) new Object[m];
		n=0;
	}
	@Override
	public Value get(Key key) {
		int r =rank(key);
		if(isEmpty()){
			return null;
		}
		if(r<n&&key.compareTo(keys[r])==0){
			return values[r];
		}
		// TODO Auto-generated method stub
		return null;
	}
	public int rank(Key key) {
		int u=0;
		int v=n-1;
		while(u<=v){
			int m=u+(v-u)/2;
			int c= key.compareTo(keys[m]);
			if(c>0){
				u=m+1;
			}else if(c<0){
				v=m-1;
			}
			else {
				return m;
			}
					
		}
		return u;
		// TODO Auto-generated method stub
		
	}
	@Override
	public void put(Key key, Value value) {
		int r=rank(key);
		if(get(key)!=null){
			values[r]=value;
		}else{
			n++;
			for (int i = n-1; i >r; i--) {
				values[i]=values[i-1];
				keys[i]=keys[i-1];
			}
			keys[r]=key;
			values[r]=value;
		}
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean isEmpty() {
		if(size()==0){
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return n;
	}
	@Override
	public Iterable<Key> keys() {
		// TODO Auto-generated method stub
		return Arrays.asList(keys);
	}
	public void print(){
		for (int i = 0; i < n; i++) {
			System.out.println(keys[i]+"----->"+values[i]);
			
		}
	}

}
