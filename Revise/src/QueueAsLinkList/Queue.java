package QueueAsLinkList;

public interface Queue<E> {
	void enqueue(E e);

	E dequeue();

	boolean isEmpty();

}
