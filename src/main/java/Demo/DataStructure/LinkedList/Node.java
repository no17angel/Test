package Demo.DataStructure.LinkedList;

public class Node<E> {
	
	private E e;// 数据域
    private Node<E> next;// 引用域
    
    public Node(){}
    
    public Node(E e) {
        this.setE(e);
    }

	public E getE() {
		return e;
	}

	public void setE(E e) {
		this.e = e;
	}

	public Node<E> getNext() {
		return next;
	}

	public void setNext(Node<E> next) {
		this.next = next;
	}
    
    
    
}
