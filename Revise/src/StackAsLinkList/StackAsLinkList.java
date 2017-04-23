package StackAsLinkList;
public class StackAsLinkList<E> implements Stack<E> {
	// Để chứa dữ liệu trong stack, ta dùng một đối tượng có tên là Node - nút cho dễ hiểu
	// tạo lớp nội Node
	class Node {
		E element; 
		Node next;
		// mỗi Node sẽ có một cái node kế bên là next, mặc định "next" = null
	}
	
	// khởi tạo Stack
	private Node head; // head =null !
	// hàm isEmpty() very simple, nên làm nó trước, đơn giản chỉ cần kiểm tra xem head == null ?
	@Override
	public void push(E e) {
		// TODO Auto-generated method stub
		//đê thêm một node mới, ta cần tạo một node
		Node node = new Node();
		// gán giá trị cho node
		node.element = e;
		node.next = head;
		//sau khi gắn được cái node vào Stack rồi, thấy rằng cái head sẽ bị ở sau cái node, giờ phải chuyển head lên đầu
		head = node;
		
	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		// chỉ lấy phần tử ra khỏi Stack khi Stack khác null
		if(! isEmpty()) {
			// để cho việc lấy phần tử ra không làm ảnh hưởng đến Stack, ta tạo thêm một cái nút mới, ở ngay trên đầu head
			Node temp = head;
			E e = temp.element;
			// trước khi return e, cần phải cập nhập lại vị trí của head,
			head = temp.next;
			return e;
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return head == null;
	}
// giờ phải Override 3 phương thức có trong Stack<E>
	
	// viết thêm cái hàm in ra các phần tử của Stack để cho dễ kiểm tra.
	
	public void print() {
		Node node = head;
		while (node != null) {
			System.out.print(node.element + " ");
			node = node.next; // sau khi in ra node.element thì phải thay đổi vị trí của node thành vị trí của node.next 
		}
	}
	
	//giờ test thử xem !!
	// à, kiểm tra xem có bao nhiêu view đã :v 
	
	// source code ở dưới cmt nhé @@
	
	// Đùa đấy, không share đâu. Tự code lại đi !
}
