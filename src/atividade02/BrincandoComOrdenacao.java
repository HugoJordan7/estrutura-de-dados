package atividade02;

import java.util.Random;

public class BrincandoComOrdenacao {

	public static void main(String[] args) {
		
		Pessoa[] pessoas = gerarVetor(100);
        Ordenacao_IF ordenacao = new Ordenacao();

        System.out.println("Executando BubbleSort...");
        Pessoa[] clone1 = pessoas.clone();
        System.out.println("Vetor Original ordenado antes? "+ordenacao.checaVetorOrdenado(pessoas));
        System.out.println("Vetor Clone ordenado antes? "+ordenacao.checaVetorOrdenado(clone1));
        long tempoBubbleSort = ordenacao.bubbleSort(clone1);
        System.out.println("Vetor Original ordenado depois? "+ordenacao.checaVetorOrdenado(pessoas));
        System.out.println("Vetor Clone ordenado depois? "+ordenacao.checaVetorOrdenado(clone1));
        System.out.println("Tempo de execução do BubbleSort (em nanossegundos): " + tempoBubbleSort);

        System.out.println("\n\nExecutando SelectionSort...");
        Pessoa[] clone2 = pessoas.clone();
        System.out.println("Vetor Original ordenado antes? "+ordenacao.checaVetorOrdenado(pessoas));
        System.out.println("Vetor Clone ordenado antes? "+ordenacao.checaVetorOrdenado(clone2));
        long tempoSelectionSort = ordenacao.selectionSort(clone2);
        System.out.println("Vetor Original ordenado depois? "+ordenacao.checaVetorOrdenado(pessoas));
        System.out.println("Vetor Clone ordenado depois? "+ordenacao.checaVetorOrdenado(clone2));
        System.out.println("Tempo de execução do SelectionSort (em nanossegundos): " + tempoSelectionSort);
        
        System.out.println("\n\nExecutando InserctionSort...");
        Pessoa[] clone3 = pessoas.clone();
        System.out.println("Vetor Original ordenado antes? "+ordenacao.checaVetorOrdenado(pessoas));
        System.out.println("Vetor Clone ordenado antes? "+ordenacao.checaVetorOrdenado(clone3));
        long tempoInserctionSort = ordenacao.insertionSort(clone3);
        System.out.println("Vetor Original ordenado depois? "+ordenacao.checaVetorOrdenado(pessoas));
        System.out.println("Vetor Clone ordenado depois? "+ordenacao.checaVetorOrdenado(clone3));
        System.out.println("Tempo de execução do InserctionSort (em nanossegundos): " + tempoInserctionSort);
        
        System.out.println("\n\nExecutando MergeSort...");
        Pessoa[] clone4 = pessoas.clone();
        System.out.println("Vetor Original ordenado antes? "+ordenacao.checaVetorOrdenado(pessoas));
        System.out.println("Vetor Clone ordenado antes? "+ordenacao.checaVetorOrdenado(clone4));
        long tempoMergeSort = ordenacao.mergeSort(clone4);
        System.out.println("Vetor Original ordenado depois? "+ordenacao.checaVetorOrdenado(pessoas));
        System.out.println("Vetor Clone ordenado depois? "+ordenacao.checaVetorOrdenado(clone4));
        System.out.println("Tempo de execução do MergeSort (em nanossegundos): " + tempoMergeSort);
        
        System.out.println("\n\nExecutando MergeSortJava...");
        Pessoa[] clone5 = pessoas.clone();
        System.out.println("Vetor Original ordenado antes? "+ordenacao.checaVetorOrdenado(pessoas));
        System.out.println("Vetor Clone ordenado antes? "+ordenacao.checaVetorOrdenado(clone5));
        long tempoMergeSortJava = ordenacao.mergeSort_Java(clone5);
        System.out.println("Vetor Original ordenado depois? "+ordenacao.checaVetorOrdenado(pessoas));
        System.out.println("Vetor Clone ordenado depois? "+ordenacao.checaVetorOrdenado(clone5));
        System.out.println("Tempo de execução do MergeSortJava (em nanossegundos): " + tempoMergeSortJava);
        
        System.out.println("\n\nExecutando QuickSort...");
        Pessoa[] clone6 = pessoas.clone();
        //ordenacao.mergeSort(clone6);
        System.out.println("Vetor Original ordenado antes? "+ordenacao.checaVetorOrdenado(pessoas));
        System.out.println("Vetor Clone ordenado antes? "+ordenacao.checaVetorOrdenado(clone6));
        long tempoQuickSort = ordenacao.quickSort(clone6);
        System.out.println("Vetor Original ordenado depois? "+ordenacao.checaVetorOrdenado(pessoas));
        System.out.println("Vetor Clone ordenado depois? "+ordenacao.checaVetorOrdenado(clone6));
        System.out.println("Tempo de execução do QuickSort (em nanossegundos): " + tempoQuickSort);
        
        System.out.println("\n\nExecutando RandomQuickSort...");
        Pessoa[] clone7 = pessoas.clone();
        //ordenacao.mergeSort(clone7);
        System.out.println("Vetor Original ordenado antes? "+ordenacao.checaVetorOrdenado(pessoas));
        System.out.println("Vetor Clone ordenado antes? "+ordenacao.checaVetorOrdenado(clone7));
        long tempoRandomQuickSort = ordenacao.random_quickSort(clone7);
        System.out.println("Vetor Original ordenado depois? "+ordenacao.checaVetorOrdenado(pessoas));
        System.out.println("Vetor Clone ordenado depois? "+ordenacao.checaVetorOrdenado(clone7));
        System.out.println("Tempo de execução do RandomQuickSort (em nanossegundos): " + tempoRandomQuickSort);
        
        System.out.println("\n\nExecutando CoutingSort...");
        Pessoa[] clone8 = pessoas.clone();
        System.out.println("Vetor Original ordenado antes? "+ordenacao.checaVetorOrdenado(pessoas));
        System.out.println("Vetor Clone ordenado antes? "+ordenacao.checaVetorOrdenado(clone8));
        long tempoCoutingSort = ordenacao.countingSort(clone8);
        System.out.println("Vetor Original ordenado depois? "+ordenacao.checaVetorOrdenado(pessoas));
        System.out.println("Vetor Clone ordenado depois? "+ordenacao.checaVetorOrdenado(clone8));
        System.out.println("Tempo de execução do CoutingSort (em nanossegundos): " + tempoCoutingSort);
        
        imprimirPessoas(clone8);
	}
	
	public static Pessoa[] gerarVetor(int size) {
		Random random = new Random();
		Pessoa[] pessoas = new Pessoa[size];
		String[] nomes = new String[] {
				"Joao", "Maria", "Pedro", "Ana", "Jose"
		};
		for (int i = 0; i < size; i++) {
			int idade = random.nextInt(15,101);
			int cpf = random.nextInt(100000000,999999999);
			int indexDoNome = random.nextInt(0,5);
			String nome = nomes[indexDoNome];
			pessoas[i] = new Pessoa(idade,cpf,nome);
		}
		return pessoas;
	}
	
	public static void imprimirPessoas(Pessoa[] pessoas) {
		System.out.println("\n\n----------------------------------");
		for (Pessoa pessoa : pessoas) {
			System.out.println(pessoa.getIdade() + " " + pessoa.getNome() + " " + pessoa.getCpf());
		}
	}

}