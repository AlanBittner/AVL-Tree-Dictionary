
public class Node<AnyType extends Comparable> implements Comparable<Node> {
	AnyType item;
	Node root=null;
	Node LeftNode=null;
	Node RightNode=null;
	private int height=0;
	
	
	
	public Node() {
		this.item=null;
	}
	
	public Node(AnyType item) {
		this.item=item;
	}
	
	@Override
	public int compareTo(Node x) {
		return this.item.compareTo(x.item);
	}
	
	public Node getRoot() {
		return root;
	}
	
	public void setRoot(Node x) {
		this.root=x;
	}

	public Node getLeft() {
		return LeftNode;
	}
	
	public void setLeft(Node x) {
		this.LeftNode=x;
	}
	
	public Node getRight() {
		return RightNode;
	}
	
	public void setRight(Node x) {
		this.RightNode=x;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int x) {
		this.height=x;
	}
	
	public AnyType getItem() {
		return item;
	}
	
	public void setItem(AnyType item) {
		this.item=item;
	}
	
	public String toString() {
		return this.item.toString();
	}
	
}