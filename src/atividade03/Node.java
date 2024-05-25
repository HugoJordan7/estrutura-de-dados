package atividade03;

public class Node {
	private Pessoa data;
	private Node next;
	
	public Node() {
		data = null;
		next = null;
	}
	
	public Node(Pessoa data, Node next) {
		this.data = data;
		this.next = next;
	}
	
	public boolean isNIL() {
		return (data == null && next == null);
	}

	public Pessoa getData() {
		return data;
	}

	public Node getNext() {
		return next;
	}

	public void setData(Pessoa data) {
		this.data = data;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
	
}
