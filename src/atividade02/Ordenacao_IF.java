package atividade02;

/*
 * Interface para implementação da classe "Ordenacao".
 * O método booleano deve retornar 'false' se 'pessoas' não estiver ordenado (crescente). 
 */
public interface Ordenacao_IF {
	
	boolean checaVetorOrdenado(Pessoa[] pessoas);
	
	long bubbleSort(Pessoa[] pessoas);
	
	long selectionSort(Pessoa[] pessoas);
	
	long insertionSort(Pessoa[] pessoas);
	
	long mergeSort(Pessoa[] pessoas);
	
	long mergeSort_Java(Pessoa[] pessoas);
	
	long quickSort(Pessoa[] pessoas);
	
	long random_quickSort(Pessoa[] pessoas);
	
	long countingSort(Pessoa[] pessoas);

}