package Bag.Data.Structures;

public interface Bag<E> {
	void add (E element);
	E remove();
	boolean isEmpty();
	boolean contains(E element);
}
