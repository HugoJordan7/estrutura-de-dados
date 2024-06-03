package atividade03;
import java.util.Scanner;

public class Main {
	public static Scanner scanner = new Scanner(System.in);
	public static Scanner scannerText = new Scanner(System.in);
	
	public static BST agenda = new BST();
	public static ListaEncadeada_IF recentes = new ListaEncadeada();
	public static TabelaHash favoritos = new TabelaHash(10);
	
	public static void main(String[] args) {
		int comando;
		do {
			System.out.println("\n		- Agenda de Contatos -");
			System.out.println("******************************************************");       
			System.out.println("0 - Parar o programa");
			System.out.println("1 - Adicionar um novo contato");
			System.out.println("2 - Adicionar um contato aos favoritos");
			System.out.println("3 - Remover contato");
			System.out.println("4 - Remover um contato dos favoritos");
			System.out.println("5 - Buscar contato");
			System.out.println("6 - Imprimir contatos da agenda");
			System.out.println("7 - Imprimir contatos recentes");
			System.out.println("8 - Imprimir contatos favoritos");
			System.out.println("******************************************************");   
			System.out.print("Informe um comando: ");
			comando = scanner.nextInt();
			switch(comando) {
				case 0:
					System.out.println("- Programa encerrado -");
					break;
				case 1:
					adicionarContato();
					break;
				case 2:
					adicionarFavorito();
					break;
				case 3:
					removerContato();
					break; 
				case 4:
					removerFavorito();
					break; 
				case 5:
					buscarContato();
					break; 
				case 6:
					imprimirAgenda();
					break; 
				case 7:
					imprimirRecentes();
					break; 
				case 8:
					imprimirFavoritos();
					break; 
				default:
					System.out.println("Comando invalido!");
			}
			if(comando != 0) clearScreen();
		} while(comando != 0);
	}
	
	private static void imprimirFavoritos() {
		System.out.println("\n- Imprimindo contatos favoritos -");
		System.out.println(favoritos.completePrint());
	}

	private static void removerFavorito() {
		System.out.print("Informe o numero que deseja remover dos favoritos: ");
		long numero = scannerText.nextLong();
		try {
			Pessoa pessoa = new Pessoa(0,numero,"");
			favoritos.remove(pessoa);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void adicionarFavorito() {
		System.out.print("Informe o numero que deseja adicionar aos favoritos: ");
		long numero = scannerText.nextLong();
		try {
			Pessoa pessoa = agenda.search(new Pessoa(0,numero,""));
			favoritos.insert(pessoa);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void adicionarContato() {
		System.out.println("\n - Informe os dados do contato -");
		System.out.print("Nome: ");
		String nome = scannerText.nextLine();
		System.out.print("Numero: ");
		long numero = scannerText.nextLong();
		System.out.print("Idade: ");
		int idade = scannerText.nextInt();
		Pessoa pessoa = new Pessoa(idade,numero,nome);
		agenda.insert(pessoa);
		recentes.insert(pessoa);
	}
	
	public static void removerContato() {
		try {
			System.out.println("Informe o número do contato que deve ser removido: ");
			long numero = scanner.nextInt();
			agenda.remove(new Pessoa(0,numero,""));
		} catch(Exception e) {
			System.out.println("Erro ao remover contato da lista!");
		}
	}
	
	public static void buscarContato() {
		try {
			System.out.println("Informe o número do contato que deve ser buscado: ");
			long numero = scanner.nextInt();
			Pessoa pessoa = agenda.search(new Pessoa(0,numero,""));
			System.out.println(pessoa.toString());
		} catch(Exception e) {
			System.out.println("Erro ao buscar contato da lista!");
		}
	}
	
	public static void imprimirAgenda() {
		if(agenda.size() == 0) {
			System.out.println("A agenda esta vazia!");
		} else{
			System.out.println("\n- Imprimindo contatos -");
			Pessoa[] pessoas = agenda.order();
			for(int i = 0; i < pessoas.length; i++) {
				System.out.println(pessoas[i].toString());
			}
		}
	}
	
	public static void imprimirRecentes() {
		if(recentes.isEmpty()) {
			System.out.println("o historico de contatos esta vazio!");
		} else{
			Pessoa[] pessoas = recentes.toArray();
			System.out.println("\n- Imprimindo aba de recentes -");
			for(int i = 0; i < recentes.size(); i++) {
				System.out.println(pessoas[i].toString());
			}
			System.out.print("\nLimpar historico de contatos recentes (sim/nao): ");
			String limparRecentes = scannerText.nextLine();
			if(limparRecentes.equalsIgnoreCase("sim")) {
				recentes = new ListaEncadeada();
			}
		}
	}
	
	public static void clearScreen() {
		System.out.println("\nPressione enter para continuar...");
		scannerText.nextLine();
        System.out.println("\n".repeat(50)); //repete o conteúdo da string N vezes
    }

}