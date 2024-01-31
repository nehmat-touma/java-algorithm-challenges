package Assignment3;

public class Node {

	private int info;
	private Node next;
	
	public Node() {
		info=0;
		next=null;
	}
	
	public Node(int o) {
		info=o;
		next=null;
	}
	
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public int getInfo() {
		return info;
	}
	public void setInfo(int info) {
		this.info = info;
	}
	
	
	
}
