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
	 * 先序遍历
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
	
	public static void minOrder(BTNode p) {
		Stack<BTNode> stack = new Stack<>();
		
		while (p!=null) {
			// 先存储右子树，再存储局部root节点。
			while (p!=null) {
				if(p.getRight()!=null) {
					stack.push(p.getRight());
				}
				stack.push(p);
				p = p.getLeft();
			}
			
			// 第一轮遍历完成之后,将最后一次push的根节点pop进去。
			p = stack.pop();
			
			// 如果栈不为空并且当前节点的右子树等于null
			while(!stack.empty() && p.getRight() == null ) {
				visit(p);
				p = stack.pop();
			}
			
			// 如果发现有right节点，先访问当前节点，再进行下一轮对树的迭代。
			visit(p);
			
			if(!stack.empty()) {
				p = stack.pop();
			} else {
				p = null;
			}
		}
		
		
	}
	
	
	public void afterOrder(BTNode p) {
		BTNode q = p;
		Stack<BTNode> stack = new Stack<>();
		while(p!=null) {
			for (; p.getLeft()!=null; p = p.getLeft()) {
				stack.push(p);
			}
			while(p!=null &&(p.getRight()==null || p.getRight() == q)) {
				visit(p);
				q = p; // 记录最近输出的节点。
				if(stack.empty()){
					return;
				}
				p = stack.pop();
			}
		}
	}
	
	public static void main(String[] args) {
		BinTree t = new BinTree(init());
		BTNode root = t.getRoot();
		minOrder(root);
	}
}
