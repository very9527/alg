package alg.order.pre;

import java.util.Stack;

public class BinTree {
	private BTNode root;
	public BinTree(BTNode root) {
		this.root = root;
	}
	
	public BTNode getRoot() {
		return this.root;
	}
	
	public static void visit(BTNode node) {
		System.out.println(node.getData());
	}
	
	public static BTNode init() {
		BTNode F = new BTNode("F");
		BTNode E = new BTNode("E");
		BTNode D = new BTNode("D", E, F);
		BTNode C = new BTNode("C", D, null);
		BTNode B = new BTNode("B");
		BTNode A = new BTNode("A", B, C);
		return A;
	}
	
	/**
	 *  先序遍历
	 * @param root
	 */
	public static void preorder(BTNode root) {
		Stack<BTNode> stack = new Stack<>();
		if(root!=null) {
			stack.push(root);
			while (!stack.empty()) {
				BTNode n = stack.pop();
				visit(n);
				if (n.getRight()!=null) {
					stack.push(n.getRight());
				}
				if (n.getLeft()!=null) {
					stack.push(n.getLeft());
				}
			}
		}
		
	}
	
	/**
	 * 中序遍历
	 * @param p
	 */
	public static void minOrder(BTNode p) {
		Stack<BTNode> stack = new Stack<>();
		BTNode node = p;
		while (node != null || stack.size() > 0) {
			while (node != null ) {
				stack.push(node);
				node = node.getLeft();
			}
			if (stack.size() > 0) {
				node = stack.pop();
				visit(node);
				node = node.getRight();
			}
		}
		
		
	}
	
	
	public static void main(String[] args) {
		BinTree t = new BinTree(init());
		BTNode root = t.getRoot();
		minOrder(root);
	}
}
