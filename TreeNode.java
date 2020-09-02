/**
 * This generic class is used in the MorseCodeTree classes.  The class consists of a reference to the data and a reference
 *  to the left and right child. 
 *  @author Walid Boutellis */
public class TreeNode<T> {
	
	protected T data;
	protected TreeNode<T> left;
	protected TreeNode<T> right;
	
	/**Parameterized Constructor
	 * @param dataNode-  the data to be stored in the TreeNode*/
	public TreeNode(T dataNode) {
		this.data= dataNode;
		this.left= null;
		this.right= null;
	}
	
	/**Parameterized Constructor used to make deep copies
	 * @param node- node to make copy of*/
	public TreeNode(TreeNode<T> node) {
		this.data= node.data;
		this.left= node.left;
		this.right= node.right;
		
	}
	
	/**Getter method to return the data within this TreeNode
	 * @return Data in the node */
	public T getData() {
		return this.data;
	}

}
