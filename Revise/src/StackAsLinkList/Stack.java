package StackAsLinkList;

public interface Stack<E> {
	// trong interface này có 3 method:
	void push(E e); // thêm một phần tử vào stack
	E pop(); // lấy ra phần tử đầu tiên của stack
	boolean isEmpty(); // kiểm tra stack == null? 
}
