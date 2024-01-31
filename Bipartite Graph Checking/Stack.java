package Assignment3;


public class Stack {

	private Node top;

	public Stack() {
		top=null;
	}

	public void push(int o) {
		if (top==null) {
			Node n=new Node(o);
			top=n;
		}
		else {
			Node n=new Node(o);
			n.setNext(top);//added.getnext
			top=n;
		}
	}

	public int pop() {
		if (top==null) {
			return -99;
		}
		else {
			Node current=top;
			top=top.getNext();
			current.setNext(null);
			return current.getInfo();
		}
	}

	public int peak() {

		if (top==null) {
			return -99;
		}
		else {
			return top.getInfo();
		}
	}

	public boolean isEmpty() {
		if (top==null) {
			return true;
		}
		return false;
	}

	public Stack reverse() {
		if (top==null || top.getNext()==null) {
			return this;
		}
		else {
			Stack temp = new Stack();
			while(top!=null) {
				temp.push(pop());
			}
			return temp;
		}
	}
	
	public Node getTop() {
		return top;
	}

	public void setTop(Node top) {
		this.top = top;
	}

}