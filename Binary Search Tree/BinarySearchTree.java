package Lab4;

public class BinarySearchTree {

	private Node root;

	public BinarySearchTree() {
		root=null;
	}

	public void add(int a, Node parent) {
		Node n=new Node(a);
		if (root==null) {
			root=n;
			return;}

		else {
			Node current=parent;

			if (current.getValue()<a) {
				if(current.getRight()!=null) {
					add(a,current.getRight());
				}
				else {
					current.setRight(n);
				}
			}
			else {
				if (current.getLeft()!=null)
					add(a,current.getLeft());
				else current.setLeft(n);
			}
		}
	}

	public boolean delete(int i,Node parent) {
		if(root==null) {
			return false;
		}
		else {
			Node prev=null;
			Node current=parent;

			while(current.getValue()!=i) {
				prev=current;

				if(i<current.getValue()) {
					if(current.getLeft()!=null) {
						current=current.getLeft();

					}
					else return false;
				}
				else {
					if(current.getRight()!=null) {
						current=current.getRight();

					}
					else return false;
				}
			}

			if(current==root) {
				root=null;
				return true;
			}

			// we need to delete current
			if (current.getRight()==null && current.getLeft()==null) {
				if(prev.getLeft()==current) {
					prev.setLeft(null);
				}
				else prev.setRight(null);
			}
			else if(current.getRight()!=null && current.getLeft()==null) {
				if(prev.getLeft()==current) {
					prev.setLeft(current.getRight());
				}
				else prev.setRight(current.getRight());
			}
			else if(current.getRight()==null && current.getLeft()!=null) {
				if(prev.getRight()==current) {
					prev.setRight(current.getLeft());
				}
				else prev.setLeft(current.getLeft());
			}
			else { // 2 children
				Node successor=getMinOfRightChild(current);
				delete(successor.getValue(),current);
				current.setValue(successor.getValue());
			}
		}
		return true;
	}

	public boolean checkifBST(BinarySearchTree b, Node parent) {
		// pass to it the root at first turn

		if(root==null)
			return true;
		else if (root.getLeft()==null && root.getRight()==null)
			return true;
		else {
			if(parent.getRight()!=null) {
				if (parent.getRight().getValue()<=parent.getValue()) {
					checkifBST(b,parent.getRight());
				}
				else return false;
			}
			if(parent.getLeft()!=null) {
				if (parent.getLeft().getValue()>parent.getValue()) {
					checkifBST(b,parent.getLeft());
				}
				else return false;
			}
			return true;
		}
	}
	
	public void printIncreasing(Node parent) {
		
		if (root==null)
			System.out.println("The BST is empty");
		else if(parent==null)
			return;
		else {
	        printIncreasing(parent.getLeft()); 

	        System.out.print(parent.getValue() + " "); 
	  
	        printIncreasing(parent.getRight()); 
	
		}
		
	}

	public Node getMinOfRightChild(Node parent) {
		Node current=parent;
		while(current.getRight()!=null)
			current=current.getRight();
		return current;
	}
}

