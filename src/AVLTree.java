
public class AVLTree<AnyType extends Comparable> {
	private Node root;
	
	public AVLTree () {
		root=null;
	}
	
	public Node getRoot() {
		return root;
	}
	
	public void setRoot(Node x) {
		this.root=x;
	}
	
	public Node find(AnyType term) {
		return find(term, root);
	}
	
	public Node find(AnyType term, Node check) {
		if(check==null) {
			return check;
		}
		Node returned=null;
		if(term.compareTo(check.item)==0) returned=check;
		else if(term.compareTo(check.item)<0) {
			if(check.getLeft()!=null) {
				returned=find(term, check.getLeft());
			}
		}
		else if(term.compareTo(check.item)>0) {
			if(check.getRight()!=null) {
				returned=find(term, check.getRight());
			}
		}
		return returned;
	}
	
	public void insert(AnyType element) {
		root=insert(element, root);
	}
	
	public Node<AnyType> insert(AnyType element, Node<AnyType> check ) {
		if(check == null) {
			check= new Node(element);
		}
		else if(element.compareTo(check.getItem())<0) {
			check.LeftNode = insert(element, check.LeftNode);
			if(getHeight(check.LeftNode)-getHeight(check.RightNode)==2) {
				if(element.compareTo(check.LeftNode.getItem())<0) {
					check = rotateWithLeftNode(check);
				}
				else {
					check= doubleWithLeftNode(check);
				}
			}
		}
		else if(element.compareTo(check.getItem())>0) {
			check.RightNode = insert(element, check.RightNode);
			if(getHeight(check.RightNode)- getHeight(check.LeftNode)==2) {
				if(element.compareTo(check.RightNode.getItem())>0) {
					check = rotateWithRightNode(check);
				}
				else {
					check = doubleWithRightNode(check);
				}
			}	
		}
		else {
			System.out.println("The word you entered already exists in the dictionary.");
		}
		
		check.setHeight(Integer.max(getHeight(check.LeftNode),getHeight(check.RightNode))+1);
		return check;
	}
	
	private Node<AnyType> rotateWithLeftNode(Node<AnyType> n2){
		Node n1= n2.LeftNode;
		n2.LeftNode=n1.RightNode;
		n1.RightNode=n2;
		n2.setHeight(Integer.max(getHeight(n2.LeftNode), getHeight(n2.RightNode))+1);
		n1.setHeight(Integer.max(getHeight(n1.LeftNode), getHeight(n2))+1);
		return n1;
	}
	
	private Node<AnyType> rotateWithRightNode(Node<AnyType> n1){
		Node n2 = n1.RightNode;
		n1.RightNode = n2.LeftNode;
		n2.LeftNode = n1;
		n1.setHeight(Integer.max(getHeight(n1.LeftNode), getHeight(n1.RightNode))+1);
		n2.setHeight(Integer.max(getHeight(n2.RightNode), getHeight(n1))+1);
		return n2;
	}
	
	private Node<AnyType> doubleWithLeftNode(Node<AnyType> n3){
		n3.LeftNode = rotateWithRightNode(n3.LeftNode);
		return rotateWithLeftNode(n3);
	}
	
	private Node<AnyType> doubleWithRightNode(Node<AnyType> n1){
		n1.RightNode= rotateWithLeftNode(n1.RightNode);
		return rotateWithRightNode(n1);
	}
	  
	public void printTree() {
		printTree(root);
	}
	
	private void printTree(Node check) {
		if(check.LeftNode!=null) {
			printTree(check.LeftNode);
		}
		System.out.print(check);
		if(check.RightNode!=null) {
			printTree(check.RightNode);
		}
	}
	
	public int getHeight(Node x) {
		if(x == null) {
			return -1;
		}
		return x.getHeight();
	}
	
	public void remove(AnyType x) {
		
		root = remove(x, root);
	}
	
	private Node remove(AnyType element, Node check ) {
		//if check is null, it means the element isn't in tree
		if(check == null) {
			return check;
		}
		//if element is less than current node, go left
		else if(element.compareTo(check.getItem()) <0) {
			check.LeftNode=remove(element, check.LeftNode);
			
		}
		//if element is greater than current node, go right
		else if(element.compareTo(check.getItem())>0) {
			check.RightNode=remove(element,check.RightNode);
		}
		//if node isnt null, greater or lesser than element, node must be the element
		else {
			//if there is an empty child of the found node, replace this node with its non-null child
			if(check.RightNode==null || check.LeftNode==null) {
				Node temp = null;
				if(check.LeftNode==null) {
					temp=check.RightNode;
				}
				else {
					temp=check.LeftNode;
				}
				
				//if both children were null this node becomes null
				if(temp==null) {
					//temp=check;
					check=null;
				}
				else {
					check=temp;
				}
				
			}
			else {
				Node temp = findMinNode(check.RightNode);
				check.setItem(temp.getItem());
				check.RightNode=remove((AnyType)temp.item, check.RightNode);
			}
		}
		
		if(check==null) {
			return check;
		}
		
		if(getHeight(check.LeftNode)-getHeight(check.RightNode)==2) {
			Node leftCheck = check.LeftNode;
			if(getHeight(leftCheck.LeftNode)-getHeight(leftCheck.RightNode)<0) {
				//double right
				check = doubleWithLeftNode(check);
			}else {
				//rotate right
				check = rotateWithLeftNode(check);
			}
		}
		else if(getHeight(check.RightNode)-getHeight(check.LeftNode)==2) {
			Node rightCheck = check.RightNode;
			if(getHeight(rightCheck.LeftNode)-getHeight(rightCheck.RightNode)>0) {
				//double left
				check =doubleWithRightNode(check);
			} else {
				//rotate left
				check =rotateWithRightNode(check);
			}
		}
		
		return check;
	}
	
	
	
	public Node findMinNode(Node<AnyType> find) {
		if(find.LeftNode==null) {
			return find;
		}
		else {
			return findMinNode(find.LeftNode);
		}
	}
	
	public String saveTree() {
		return saveTree(root);
	}
	
	private String saveTree(Node check) {
		
		String savedlist = check.item.toString();
		if(check.LeftNode!=null) {
			
			savedlist+=saveTree(check.LeftNode);
		}
		if(check.RightNode!=null) {
			
			savedlist+=saveTree(check.RightNode);
		}
		return savedlist;
	}
			

}
