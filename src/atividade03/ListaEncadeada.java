package atividade03;

public class ListaEncadeada implements ListaEncadeada_IF {
	
	private Node head;
	private int size = 0;
	
	public ListaEncadeada() {
		head = new Node();
	}

	@Override
	public boolean isEmpty() {
		return head.isNIL();
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void insert(Pessoa element) {
		Node newNode = new Node(element,head);
		head = newNode;
		size++;
	}

	@Override
	public void remove(Pessoa element) throws Exception {
		if(isEmpty()) throw new Exception("O elemento não existe!");
		if(head.getData().compareTo(element) == 0) {
			head = head.getNext();
			size--;
			return;
		}
		Node aux = head;
		while(!aux.getNext().isNIL() && aux.getNext().getData().compareTo(element) != 0) {
			aux = aux.getNext();
		}
		if(aux.getNext().isNIL()) throw new Exception("O elemento não existe!");
		aux.setNext(aux.getNext().getNext());
		size--;
	}

	@Override
	public Pessoa search(Pessoa element) throws Exception {
		if(isEmpty()) throw new Exception("O elemento não existe!");
		if(head.getData().compareTo(element) == 0) return head.getData();
		Node aux = head;
		while(!aux.getNext().isNIL() && aux.getNext().getData().compareTo(element) != 0) {
			aux = aux.getNext();
		}
		if(aux.getNext().isNIL()) throw new Exception("O elemento não existe!");
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
