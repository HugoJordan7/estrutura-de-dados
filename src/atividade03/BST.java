package atividade03;

public class BST implements BST_IF{

	private BSTNode root;
	private int size = 0;
	private int indexDePercurso = 0;
	
	public BST() {
		root = new BSTNode();
	}
	
	@Override
	public void insert(Pessoa element) {
		BSTNode newNode = new BSTNode(element);
		
		if(root.isNIL()) {
			root = newNode;
			size++;
			return;
		}
		
		BSTNode parent = new BSTNode();
		BSTNode aux = root;
		
		while(!aux.isNIL()) {
			parent = aux;
			if(element.compareTo(aux.getData()) < 0) aux = aux.getLeft();
			else aux = aux.getRight();
		}
		
		newNode.setParent(parent);
		
		if(element.compareTo(parent.getData()) < 0) {
			parent.setLeft(newNode);
		} else {
			parent.setRight(newNode);
		}
		size++;
	}
	
	@Override
	public void remove(Pessoa element) throws Exception {
		if(root.isNIL()) throw new Exception("A árvore está vazia!");
		
		BSTNode elementNode = searchNode(element), deletedNode, chieldMoved; 
		
		if (elementNode.getLeft().isNIL() || elementNode.getRight().isNIL()) {
			deletedNode = elementNode;
		} else {
			deletedNode = treeSuccessor(elementNode);
		}
		
		if(!deletedNode.getLeft().isNIL()) {
			chieldMoved = deletedNode.getLeft();
		} else {
			chieldMoved = deletedNode.getRight();
		}
		
		if(!chieldMoved.isNIL()) {
			chieldMoved.setParent(deletedNode.getParent());
		}
		
		if(deletedNode.getParent().isNIL()) {
			root = chieldMoved;
		} else if(deletedNode.getData().equals(deletedNode.getParent().getLeft().getData())) {
			deletedNode.getParent().setLeft(chieldMoved);
		} else {
			deletedNode.getParent().setRight(chieldMoved);
		}
		
		if(!deletedNode.getData().equals(elementNode.getData())) {
			elementNode.setData(deletedNode.getData());
		}
		size--;
	}
	
	private BSTNode treeSuccessor(BSTNode node) {
		if(!node.getRight().isNIL()) {
			return minimum(node.getRight());
		} 
		BSTNode parent = node.getParent();
		while(!parent.isNIL() && node.getData().equals(parent.getRight().getData())) {
			node = parent;
			parent = parent.getParent();
		}
		return parent;
	}
	
	private BSTNode minimum(BSTNode node) {
		BSTNode aux = node;
		while(!aux.getLeft().isNIL()) {
			aux = aux.getLeft();
		}
		return aux;
	}
	
	private BSTNode searchNode(Pessoa element) throws Exception{
		if(root.isNIL()) throw new Exception("A arvore esta vazia!");
		BSTNode aux = root;
		while(!aux.isNIL()) {
			if(aux.getData().compareTo(element) == 0) {
				return aux;
			} else if(aux.getData().compareTo(element) > 0) {
				aux = aux.getLeft();
			} else {
				aux = aux.getRight();
			}
		}
		throw new Exception("Elemento não encontrado!");
	}
	
	@Override
	public Pessoa search(Pessoa element) throws Exception {
		return searchNode(element).getData();
	}

	@Override
	public Pessoa[] preOrder() {
		Pessoa[] pessoas = new Pessoa[size];
		preOrder(root, pessoas);
		indexDePercurso++;
		return pessoas;
	}
	
	private void preOrder(BSTNode node, Pessoa[] pessoas) {
		if(!node.isNIL()) {
			visit(node.getData(),pessoas);
			preOrder(node.getLeft(),pessoas);
			preOrder(node.getRight(),pessoas);
		}
	}

	@Override
	public Pessoa[] order() {
		Pessoa[] pessoas = new Pessoa[size];
		order(root, pessoas);
		indexDePercurso++;
		return pessoas;
	}
	
	private void order(BSTNode node, Pessoa[] pessoas) {
		if(!node.isNIL()) {
			order(node.getLeft(),pessoas);
			visit(node.getData(),pessoas);
			order(node.getRight(),pessoas);
		}
	}
	
	@Override
	public Pessoa[] postOrder() {
		Pessoa[] pessoas = new Pessoa[size];
		postOrder(root, pessoas);
		indexDePercurso = 0;
		return pessoas;
	}
	
	private void postOrder(BSTNode node, Pessoa[] pessoas) {
		if(!node.isNIL()) {
			postOrder(node.getLeft(),pessoas);
			postOrder(node.getRight(),pessoas);
			visit(node.getData(),pessoas);
		}
	}
	
	private void visit(Pessoa pessoa, Pessoa[] pessoas) {
		pessoas[indexDePercurso] = pessoa;
		indexDePercurso++;
	}
	
	public int height() {
		return height(root)-1;
	}
	
	private int height(BSTNode node) {
		if(node.isNIL()) return 0;
		int heightLeft = height(node.getLeft()) +1;
		int heightRight = height(node.getRight()) +1;
		if(heightLeft > heightRight) return heightLeft;
		return heightRight;
	}

	@Override
	public boolean isComplete() {
		int h = height();
		return (size == valorElevadoAoExpoente(2, h+1)-1);
	}
	
	private int valorElevadoAoExpoente(int valor, int expoente) {
		int resultado = valor;
		for(int i = 0; i<expoente-1; i++) {
			resultado = resultado * valor;
		}
		return resultado;
	}
	
	/*
	private boolean isComplete(BSTNode aux) {
		if(aux.getLeft().isNIL() && aux.getLeft().isNIL()) {
			return false;
		} else if(!aux.getLeft().isNIL()) {
			return isComplete(aux.getLeft());
		} else if(!aux.getRight().isNIL()) {
			return isComplete(aux.getRight());
		} else {
			boolean leftIsLeaf = aux.getLeft().isLeaf();
			boolean rightIsLeaf = aux.getRight().isLeaf();
			if(leftIsLeaf && !rightIsLeaf) return false;
			else if(!leftIsLeaf && rightIsLeaf) return false;
			else {
				isComplete(aux.getLeft());
				isComplete(aux.getRight());
			}
		}
		return true;
	}
	
	private boolean isCompleteTest() {
		if(root.isNIL()) return false;
		BSTNode aux = root;
		while(!aux.isNIL()) {
			if(aux.getLeft().isNIL() && aux.getLeft().isNIL()) {
				return false;
			} else if(!aux.getLeft().isNIL()) {
				aux = aux.getLeft();
			} else if(!aux.getRight().isNIL()) {
				aux = aux.getRight();
			} else {
				if(!aux.getLeft().isLeaf() && aux.getRight().isLeaf()) {
					return false;
				} else if(aux.getLeft().isLeaf() && !aux.getRight().isLeaf()) {
					return false;
				}
			}
		}
	}*/

}