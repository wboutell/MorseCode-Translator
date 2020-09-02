import java.util.ArrayList;

/**
 * A generic linked binary tree which inherits from the LinkedConverterTreeInterface. 
 * The class uses an external generic TreeNode class parameterized as a String: TreeNode<String>. 
 * This class uses the private member of root.  Nodes are added based on their morse code value. 
 * A ‘.’ (dot) means to traverse left and a ‘-‘ (dash) means to traverse right.
 * The constructor will call the method to “build the tree”.  
 * @author Walid Boutellis*/
public class MorseCodeTree implements LinkedConverterTreeInterface<String> {

	private TreeNode<String> root= null;
	private String alpha;
	
	/**
	 * Default constructor
	 * Initializes the alphabet tree*/
	public MorseCodeTree() {
		buildTree();
	}
	
	/**
	 * Returns a reference to the root
	 * @return reference to root*/
	@Override
	public TreeNode<String> getRoot() {
		return this.root;
	}

	/**
     * sets the root of the of the MorseCodeTree
     * @param newNode a copy of newNode will be the new root*/
	@Override
	public void setRoot(TreeNode<String> newNode) {
		this.root= newNode;
	}

	/**
	 * Adds element to the correct position in the tree based on the code This method will call the recursive method addNode 
	 * @param code- the code for the new node to be added, example ".-."
	 * @param result- the letter for the corresponding code, example "r" 
	 * @return the MorseCodeTree with the new node added
	 * */
	@Override
	public MorseCodeTree insert(String code, String result) {
		//Make a call to the recursive method to add nodes to the tree
		addNode(root, code, result);
		return this;
	}

	/**
	 * This is a recursive method that adds element to the correct position in the tree based on the code. A '.' (dot) means traverse to the left. A "-" (dash) means traverse to the right. The code ".-" would be stored as the right child of the left child of the root Algorithm for the recursive method:
		1. if there is only one character
			a. if the character is '.' (dot) store to the left of the current root
			b. if the character is "-" (dash) store to the right of the current root
			c. return
		2. if there is more than one character
			a. if the first character is "." (dot) new root becomes the left child
			b. if the first character is "-" (dash) new root becomes the right child
			c. new code becomes all the remaining charcters in the code (beyond the first character)
			d. call addNode(new root, new code, letter)
		@param root- the root of the tree for this particular recursive instance of addNode
		@param code- the code for this particular recursive instance of addNode
		@param letter- the data of the new TreeNode to be added
		*/
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		//Recursion: Base Case
		if(code.length() == 1) {
			//if Morse Code character is a dot, store it to the left of the tree
			if(code.equals(".")) {
				root.left= new TreeNode<String>(letter);
			}
			//if Morse Code character is not a dot (we assume it is a hyphen in this case)
			//Store it to the right of the tree
			else {
				root.right= new TreeNode<String>(letter);
			}
			return;
		}
		//Recursion: Recursive Case
		else {
			//
			if(code.substring(0, 1).equals(".")) {
				addNode(root.left,code.substring(1), letter);
			}
			//
			else {
				addNode(root.right,code.substring(1), letter);
			}
		}
	}

	/**
     * Fetch the data in the tree based on the code
     * This method will call the recursive method fetchNode
     * @param code- the code that describes the traversals within the tree
     * @return the string (letter) that corresponds to the code*/
	@Override
	public String fetch(String code) {
		return fetchNode(root, code);
	}

	/**
     * This is the recursive method that fetches the data of the TreeNode that corresponds with the code
     * A '.' (dot) means traverse to the left. A "-" (dash) means traverse to the right.
     * The code ".-" would fetch the data of the TreeNode stored as the right child of the left child of the root
     * @param root the root of the tree for this particular recursive instance of addNode
     * @param code the code for this particular recursive instance of fetchNode
     * @return the string (letter) corresponding to the code*/
	public String fetchNode(TreeNode<String> root, String code) {
		if(code.length() == 1) {
			//if Morse Code character is a dot, get character from left child
			if(code.equals(".")) {
				alpha= root.left.getData();
			}
			//if Morse Code character is not a dot (we assume it is a hyphen in this case)
			//get character from right child
			else {
				alpha= root.right.getData();
			}
		}
		//Recursion: Recursive Case
		else {
			//
			if(code.substring(0, 1).equals(".")) {
				fetchNode(root.left,code.substring(1));
			}
			//
			else {
				fetchNode(root.right,code.substring(1));
			}
		}
		return alpha;
	}

	@Override
	public MorseCodeTree delete(String data) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MorseCodeTree update() throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
     * This method builds the MorseCodeTree by inserting the nodes of the tree level by level based on the code.
     * The root will have a value of "" (empty string)
     * level one: insert(".", "e"); insert("-", "t");
     * level two: insert("..", "i"); insert(".-", "a"); insert("-.", "n"); insert("--", "m"); etc.
     * Look at the tree and the table of codes to letters in the assignment description.*/
	@Override
	public void buildTree() {
		//Insert nodes using level order
		//Level 0
		setRoot(new TreeNode<String>(""));
		
		//Level 1
		insert(".", "e");
		insert ("-", "t");
		
		//Level 2
		insert("..", "i");
		insert(".-", "a");
		
		insert ("-.", "n");
		insert ("--", "m");
		
		//Level 3
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");
		
		//Level 4
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		
		insert(".-..", "l");
		
		insert(".--.", "p");
		insert(".---", "j");
		
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		
		insert("--..", "z");
		insert("--.-", "q");
	}

   /**
    * Returns an ArrayList of the items in the linked Tree in LNR (Inorder) Traversal order. 
    * Used for testing to make sure tree is built correctly
    * @return an ArrayList of the items in the linked Tree*/
	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> temp= new ArrayList();
		LNRoutputTraversal(this.root, temp);
		return temp;
	}

	/**
     * The recursive method to put the contents of the tree in an ArrayList in LNR (Inorder)
     * @param root the root of the tree for this particular recursive instance
     * @param list the ArrayList that will hold the contents of the tree in LNR order*/
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		//Recursion: Base Case
		if(root == null) {
			return;
		}
		//Recursion: Recursive Case
		else {
			LNRoutputTraversal(root.left, list);
			list.add(root.getData());
			LNRoutputTraversal(root.right, list);
			
		}
	}

}
