package atividade03;

public class BSTNode {
	
	private Pessoa data;
	private BSTNode parent;
	private BSTNode left;
	private BSTNode right;
	
	public BSTNode() {
		data = null;
		parent = null;
		left = null;
		right = null;
	}
	
	public BSTNode(Pessoa data) {
		this.data = data;
		parent = new BSTNode();
		left = new BSTNode();
		right = new BSTNode();
	}
	
	public BSTNode(Pessoa data, BSTNode parent, BSTNode left, BSTNode right) {
		super();
		this.data = data;
		this.parent = parent;
		this.left = left;
		this.right = right;
	}
	
	public boolean isNIL() {
		return (data == null && parent == null && left == null && right == null);
	}
	
	public Pessoa getData() {
		return data;
	}
	public BSTNode getParent() {
		return parent;
	}
	public BSTNode getLeft() {
		return left;
	}
	public BSTNode getRight() {
		return right;
	}
	public void setData(Pessoa data) {
		this.data = data;
	}
	public void setParent(BSTNode parent) {
		this.parent = parent;
	}
	public void setLeft(BSTNode left) {
		this.left = left;
	}
	public void setRight(BSTNode right) {
		this.right = right;
	}
	
	
}
