
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
			right =null;
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
		
		minHelper(root);
		System.out.println(root.left.data);
	}
	
	private E minHelper(Node root) {

		Node newNode = new Node();
		//Check the data to see if already in tree.
		int value =  root.data.compareTo(root.left.data);

		if(value <= 0) {
			//Check to see if left child node exists if not...
			if(root.left == null) {

				return root.data;

			}else {

				//If left child already exists continue going left.
				minHelper(root.left);
			}
		}
		
		return root.left.data;//Have to return data of the least value.
		
	}


	//Maximum of subtree starting at root.
	public E max(Node root) {
		
		
			
		return null;//Have to return something, not null.
	}

	//Successor of node with element item and the head of the subtree is at root
	public Node successor(Node root, E item) {
		return null;//Have to return something, not null.
	}

	public Node preduccessor(Node root, E item) {
		return null;//Have to return something, not null.
	}

	///////////////// Different tree traversals (preorder, inorder and postorder) /////////////////
	
	//Start from root and read from left to right (top down).
	public void preorder() {
		
		System.out.println("Preorder:");
		
		if(root == null) {
			
			System.out.println("root null");
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
			
			System.out.println("root null");
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

	}

	//Deletes the item from the tree.
	public void delete(E item) {

	}

	//Remove everything from tree.
	public void clearAll() {

	}

	//Check if tree is empty.
	public void isEmpty() {

	}

public static void main(String[] args) {
	//check each of the methods using at least 2 different tests
	//edge cases, all situations
	//BONUS: implement GUI version	

	BST <Integer> tree = new BST<Integer>();
	
	tree.add(Integer.valueOf(4));
	tree.add(Integer.valueOf(3));
	tree.add(Integer.valueOf(5));
	tree.add(Integer.valueOf(1));
	tree.add(Integer.valueOf(2));
	tree.add(Integer.valueOf(6));
	tree.add(Integer.valueOf(7));
	
	tree.inorder();
	
	tree.search(Integer.valueOf(3));
	tree.search(Integer.valueOf(100));
	
	tree.preorder();
	tree.size();
	tree.height();
	tree.min();
	

}

}