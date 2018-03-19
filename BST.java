
public class BST<E extends Comparable<E>>{
	//Root of tree.
	Node root;
	//Size of tree.
	int size;

	BST(){
		root = null;
		size = 0;
	}

	class Node {
		Node left;
		Node right;
		E data;

		Node(){
			left = null;
			right = null;
			data = null;
		}
	}
	
		//Add a new node.
		public void add(E item) {

			Node newNode = new Node();//Initializing a node

			//Check for root and, if none exists, creating one.
			if (root == null) {

				newNode.data = item;
				root = newNode;
				return;

			}

			//code for add, maybe useful to have recursive helper method.
			addHelper(root, item);

		}

		public boolean addHelper(Node root, E item) {

			Node newNode = new Node();//Initializing a node

			//Check the data to see if already in tree.
			int value =  item.compareTo(root.data);

			if(value == 0) {

				return false;
			}

			if(value < 0) {
				//Check to see if left child node exists if not...
				if(root.left == null) {

					root.left = newNode;//Create left child.
					newNode.data = item;//Set its value.

				}else {

					//If left child already exists continue going left.
					addHelper(root.left, item);
				}

			}else { 

				//Check to see if right child node exists if not...
				if(root.right == null) {

					root.right = newNode;//New right child node.
					newNode.data = item;//Set its value.

				}else{

					//If left child already exists continue going right.
					addHelper(root.right, item);
				}
			}

			return true;
		}

		//Find element with name item in tree.
		public void search(E item) {
			
			Node found = searchHelper(root, item);
			
			if(found == null) {
				
				System.out.println(item +" not in tree.");
			}
			else {
				
				System.out.println("Found: " + found.data);
			}
		}

		private Node searchHelper(Node root, E item) {

			if(root == null || root.data == item) {

				return root;
			}

			if(root.data.compareTo(item) > 0) {

				return searchHelper(root.left, item);

			}

			return searchHelper(root.right, item);
		}

		//number of elements inside tree.
		public void size() {
			
			System.out.println("Tree size: " + sizeHelper(root));
		}
		
		private int sizeHelper(Node root) {

			// If it doesn't exist, return 0.
			if (root == null) return 0;

			// count root, left child and right child.
			return 1 + sizeHelper(root.left) + sizeHelper(root.right);
		}


		//Height of tree.
		
		public void height() {
			
			System.out.println("Tree height: " + heightHelper(root));
		}
		
		private int heightHelper(Node root) {

			if(root == null) {
				return 0;
			}
			return 1 + Math.max(heightHelper(root.right), heightHelper(root.left));

		}

	//Minimum of subtree starting at root.
	public void min() {
		System.out.println("Min: " + minHelper(root));
	}
	
	private E minHelper(Node node) {

	       //Go down the left
	        while (node.left != null) {
	            node = node.left;
	        }
	        return (node.data);
	}

	//Maximum of subtree starting at root.
	public void max() {
		System.out.println("Max: " + maxHelper(root));
	}
	
	private E maxHelper(Node node) {

	       //Go down the left
	        while (node.right != null) {
	            node = node.right;
	        }
	        return (node.data);
	}

	//Successor of node with element item and the head of the subtree is at root
	public void successor(E item) {
		
		Node found = searchHelper(root, item);
		
		if(found == null) {
			
			System.out.println(item +" not in tree.");
		}else {
		
		successorHelper(root, item);
		
		System.out.println("Successor of " + item + " is: "+ root.data);
		
		}
	}
	
	private Node successorHelper(Node root, E item) {
		
		//Initializing a node.
		Node newNode = new Node();
		
		//Using search method to locate the node in question.
		Node successor = searchHelper(root, item);
		
		//Check if tree is empty.
		if(successor == null) {
			return null;
		}
		
		//Node has a right subtree
		if(successor.right != null) {
			
			newNode = successor.right;
			
			//Finding successor by going through the left of subtree
			while(newNode.left != null) {
				
//				return (BST<E>.Node) minHelper(newNode.right);
				newNode = newNode.left;
				return newNode;
			}
		}else{   //No right subtree
			
			Node ancestor = new Node();
			ancestor = root;
			
			while(ancestor != successor) {
				if(ancestor.left != null) {
					newNode = ancestor; //This is the successor.
					ancestor = ancestor.left;
				}else {
					ancestor = ancestor.right;
				}
			}
			return newNode;
		}
		return newNode;
	}

	public Node preduccessor(Node root, E item) {
		return null;//Have to return something, not null.
	}

	///////////////// Different tree traversals (preorder, inorder and postorder) /////////////////
	
	//Start from root and read from left to right (top down).
	public void preorder() {
		
		System.out.println("Preorder:");
		
		if(root == null) {
			
			System.out.println("Tree is empty!");
		}
		
		preorderHelper(root);
	}
	
	private void preorderHelper(Node root) {
		
		if(root != null) {
			
			System.out.println(root.data);
			preorderHelper(root.left);
			preorderHelper(root.right);
			
		}
	}
	
	//Start on the left side go to root and down right.
	public void inorder() {
		
		System.out.println("Inorder:");
		
		if(root == null) {
			
			System.out.println("Tree is empty!");
		}
		
		inorderHelper(root);
	}
	
	private void inorderHelper(Node root) {
		
		if(root != null) {
			
			inorderHelper(root.left);
			System.out.println(root.data);
			inorderHelper(root.right);
		}
	}
	
	//Start at the left, then the right and finish at root.
	public void postorder() {

		System.out.println("Postorder:");

		if(root == null) {

			System.out.println("Tree is empty!");
		}

		postorderHelper(root);

	}
	private void postorderHelper(Node root) {

		if(root != null) {

			postorderHelper(root.left);
			postorderHelper(root.right);
			System.out.println(root.data);
		}
	}

	public void delete(E item) {
		
		deleteHelper(root, item);
		System.out.println(item + " deleted.");
	}
	
	//Deletes the item from the tree.
	private Node deleteHelper(Node root, E item) {

		Node newNode = new Node();
		//If tree is empty
		if(root == null ) {
			return null;
		}else if(root.left != null ){ //Delete left

			deleteHelper(root.left, item);
			return root.left;

		}else if(root.right != null){ //Delete right

			deleteHelper(root.right, item);
			return root.right;
		}else {

			//Delete leaf nodes (No Child)
			if(root.left == null && root.right ==null) {

				root = null;

			}else if(root.left == null) { //Delete node with only one child (right child).

				newNode = root;
				root = root.right;
				newNode = null;

			}else if(root.right == null) { //Delete node with only one child (left child).

				newNode = root;
				root = root.left;
				newNode = null;

			}else { //Delete node with two children.

				newNode = (BST<E>.Node) minHelper(root.right);
				root.data = newNode.data;
				root.right = null;
				newNode.data = null;
			}
			
			return root;

		}
	}

	//Remove everything from tree.
	public void clearAll() {
		
		System.out.println("Clearing things up...");
		
		if(root != null) {
			
			root.left = null;
			root.right = null;
			root = null;
		}
	}

	//Check if tree is empty.
	public void isEmpty() {
	
		if(root == null) {
			
			System.out.println("Tree is empty!");
			
		}else {
			System.out.println("There is something here...");
		}
	
		return;
	}

public static void main(String[] args) {
	//check each of the methods using at least 2 different tests
	//edge cases, all situations
	//BONUS: implement GUI version	

	BST <Integer> tree = new BST<Integer>();
	
	tree.isEmpty();
	tree.add(Integer.valueOf(4));
	tree.add(Integer.valueOf(13));
	tree.add(Integer.valueOf(9));
	tree.add(Integer.valueOf(10));
	tree.add(Integer.valueOf(2));
	tree.add(Integer.valueOf(6));
	tree.add(Integer.valueOf(78));
	
	tree.inorder();
	
	tree.search(Integer.valueOf(3));
	tree.search(Integer.valueOf(100));
	
	tree.delete(13);
	tree.successor(2);
	
	tree.preorder();
	tree.size();
	tree.height();
	tree.min();
	tree.max();
	
	tree.postorder();
	tree.isEmpty();
	tree.clearAll();
	tree.isEmpty();

	
}

}
