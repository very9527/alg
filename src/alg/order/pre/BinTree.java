package alg.order.pre;

import java.util.Stack;

import alg.order.domain.BTNode;

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
	 * �������
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
			// �ȴ洢���������ٴ洢�ֲ�root�ڵ㡣
			while (p!=null) {
				if(p.getRight()!=null) {
					stack.push(p.getRight());
				}
				stack.push(p);
				p = p.getLeft();
			}
			
			// ��һ�ֱ������֮��,�����һ��push�ĸ��ڵ�pop��ȥ��
			p = stack.pop();
			
			// ���ջ��Ϊ�ղ��ҵ�ǰ�ڵ������������null
			while(!stack.empty() && p.getRight() == null ) {
				visit(p);
				p = stack.pop();
			}
			
			// ���������right�ڵ㣬�ȷ��ʵ�ǰ�ڵ㣬�ٽ�����һ�ֶ����ĵ�����
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
				q = p; // ��¼�������Ľڵ㡣
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
