package atividade03;

public class TabelaHash implements TabelaHash_IF {
	
	private ListaEncadeada[] tabela;
	private int size;
	
	public TabelaHash(int size) {
		tabela = new ListaEncadeada[size];
		for (int i = 0; i < tabela.length; i++) {
			tabela[i] = new ListaEncadeada();
		}
		this.size = size;
	}

	@Override
	public void insert(Pessoa element) {
		tabela[hash(element.getCpf())].insert(element);
	}

	@Override
	public void remove(Pessoa element) throws Exception {
		tabela[hash(element.getCpf())].remove(element);
	}

	@Override
	public Pessoa search(Pessoa element) throws Exception {
		return tabela[hash(element.getCpf())].search(element);
	}
	
	private int hash(long cpf) {
		return (int) (cpf % size);
	}
	
	public int size() {
		return size;
	}

	@Override
	public String print() {
		String result = "";
		for (int i = 0; i < tabela.length; i++) {
			result = result + i + ": ";
			Pessoa[] pessoas = tabela[i].toArray();
			for (int j = 0; j < tabela[i].size(); j++) {
				if(j != 0) {
					result = result + ", ";
				}
				result = result + pessoas[j].getCpf();
			}
			result = result + "\n";
		}
		return result;
	}
	
	public String completePrint() {
		String result = "";
		for (int i = 0; i < tabela.length; i++) {
			Pessoa[] array = tabela[i].toArray();
			for (Pessoa pessoa : array) {
				result = result + pessoa.toString() + "\n";
			}
		}
		return result;
	}

	public ListaEncadeada get(int i) {
		return tabela[i];
	}

}
