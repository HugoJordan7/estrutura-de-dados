package atividade03;

public class TabelaHash implements TabelaHash_IF {
	
	ListaEncadeada[] tabela;
	int size;
	
	public TabelaHash(int size) {
		tabela = new ListaEncadeada[size];
		for (int i = 0; i < tabela.length; i++) {
			tabela[i] = new ListaEncadeada();
		}
		this.size = size;
	}

	@Override
	public void insert(Pessoa element) {
		tabela[(int) (element.getCpf()%size)].insert(element);
	}

	@Override
	public void remove(Pessoa element) throws Exception {
		tabela[(int) (element.getCpf()%size)].remove(element);
	}

	@Override
	public Pessoa search(Pessoa element) throws Exception {
		return tabela[(int) (element.getCpf()%size)].search(element);
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

}
