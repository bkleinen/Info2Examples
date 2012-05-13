package linkedlists;

public class Node<E> {
	public Node(E s){
		data = s;
	}
	Node<E> prev,next;
	E data;
	public String toString(){
		return data.toString();
	}
	E getData(){
		return data;
	}
}
