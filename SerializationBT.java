import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Jie Chen
 *
 */

class TreeNode {
	int val;
	TreeNode left, right;
	public TreeNode(int val) {
		this.val = val;
	}
}

public class BinaryTree {
	/**
	 * Serialization
	 * 
	 * @param root - Binary Tree root
	 * @return - serialization list
	 */
	public List<Integer> serialize(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if(root == null) return res;
		serialize(res, root);
		
		return res;
	}
	
	private void serialize(List<Integer> res, TreeNode root) {
		if(root==null) {
			res.add(-1);
		} else {
			res.add(root.val);
			serialize(res, root.left);
			serialize(res, root.right);
		}
	}
	
	/**
	 * Deserialization
	 * 
	 * @param in - Input serialized binary tree stream
	 * @return - Binary tree root
	 */
	private int idx = 0;
	public TreeNode deserialize(List<Integer> in) {
		return deserialize(in, idx);
	}
	
	private TreeNode deserialize(List<Integer> in, int depth) {
		if(depth >= in.size()) return null;
		
		if(in.get(depth) != -1) {
			TreeNode root = new TreeNode(in.get(depth));
			root.left = deserialize(in, ++idx);
			root.right = deserialize(in, ++idx);
			
			return root;
		} else {
			return null;
		}
	}
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		
		TreeNode root = new TreeNode(30);
		root.left = new TreeNode(10);
		root.left.left = new TreeNode(50);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(45);
		root.right.right = new TreeNode(35);
		
		List<Integer> ret = bt.serialize(root);
		TreeNode newRoot = bt.deserialize(ret);
	}
	
}







