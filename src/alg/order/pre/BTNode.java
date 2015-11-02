package alg.order.pre;

/**
 * Ê÷½Úµã
 * @author zhangzhiyun
 */
public class BTNode {
	private String data;
	private BTNode left;
	private BTNode right;
	
	public BTNode(String data) {
		this.data = data;
	}
	
	public BTNode(String data, BTNode left, BTNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public BTNode getLeft() {
		return left;
	}

	public void setLeft(BTNode left) {
		this.left = left;
	}

	public BTNode getRight() {
		return right;
	}

	public void setRight(BTNode right) {
		this.right = right;
	}
}
