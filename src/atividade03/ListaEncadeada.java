package atividade03;

public class ListaEncadeada implements ListaEncadeada_IF {
	
	private Node head;
	
	public ListaEncadeada() {
		head = new Node();
	}

	@Override
	public boolean isEmpty() {
		return head.isNIL();
	}

	@Override
	public int size() {
		int size = 0;
		Node aux = head;
		while(!aux.isNIL()) {
			size++;
			aux = aux.getNext();
		}
		return size;
	}

	@Override
	public void insert(Pessoa element) {
		Node newNode = new Node(element,head);
		head = newNode;
	}

	@Override
	public void remove(Pessoa element) throws Exception {
		if(isEmpty()) throw new Exception("A lista está vazia!");
		if(head.getData().compareTo(element) == 0) {
			head = head.getNext();
			return;
		}
		Node aux = head;
		while(!aux.getNext().isNIL() && aux.getNext().getData().compareTo(element) != 0) {
			aux = aux.getNext();
		}
		if(aux.getNext().isNIL()) throw new Exception("O elemento não está na lista!");
		aux.setNext(aux.getNext().getNext());
	}

	@Override
	public Pessoa search(Pessoa element) throws Exception {
		if(isEmpty()) throw new Exception("A lista está vazia!");
		if(head.getData().compareTo(element) == 0) return head.getData();
		Node aux = head;
		while(!aux.getNext().isNIL() && aux.getNext().getData().compareTo(element) != 0) {
			aux = aux.getNext();
		}
		if(aux.getNext().isNIL()) throw new Exception("O elemento não está na lista!");
		return aux.getNext().getData();
	}

	@Override
	public Pessoa[] toArray() {
		int tam = size();
		Pessoa[] pessoas = new Pessoa[tam];
		Node aux = head;
		for (int i = 0; i < tam; i++) {
			pessoas[i] = aux.getData();
			aux = aux.getNext();
		}
		return pessoas;
	}

}
