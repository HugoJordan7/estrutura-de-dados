package atividade02;

import java.util.Arrays;
import java.util.Random;

public class Ordenacao implements Ordenacao_IF {
	
	private Random random = new Random();

	@Override
	public boolean checaVetorOrdenado(Pessoa[] pessoas) {
		for (int i = 0; i < pessoas.length-1; i++) {
			for (int j = i+1; j < pessoas.length; j++) {
				if(pessoas[i].compareTo(pessoas[j]) > 0 ) return false;
			}
		}
		return true;
	}
	
	@Override
	public long bubbleSort(Pessoa[] pessoas) {
		long antes = System.nanoTime();
		for (int i = 0; i < pessoas.length-1; i++) {
			for (int j = i+1; j < pessoas.length; j++) {
				if(pessoas[i].compareTo(pessoas[j]) > 0 ) {
					swap(pessoas, i, j);
				}
			}
		}
		long depois = System.nanoTime();
		return (depois-antes);
	}
	
	@Override 
	public long selectionSort(Pessoa[] pessoas) {
		long antes = System.nanoTime();
		for (int i = 0; i < pessoas.length-1; i++) {
			int min = i;
			for (int j = i+1; j < pessoas.length; j++) {
				if(pessoas[j].compareTo(pessoas[min]) < 0 ) {
					min = j;
				}
			}
			swap(pessoas, i, min);
		}
		long depois = System.nanoTime();
		return (depois-antes);
	}

	@Override
	public long insertionSort(Pessoa[] pessoas) {
		long antes = System.nanoTime();
		for (int j = 1; j < pessoas.length; j++) {
			Pessoa key = pessoas[j];
			int i = j-1;
			while(i > 0 && pessoas[i].compareTo(key) > 0) {
				pessoas[i+1] = pessoas[i];
				i--;
			}
			pessoas[i+1] = key;
		}
		long depois = System.nanoTime();
		return (depois-antes);
	}

	@Override
	public long mergeSort(Pessoa[] pessoas) {
		long antes = System.nanoTime();
		
		if(pessoas.length > 1) {
			int meio = pessoas.length/2;
			Pessoa[] left = new Pessoa[meio];
			Pessoa[] right = new Pessoa[pessoas.length-meio];
			for (int i = 0; i < meio; i++) {
				left[i] = pessoas[i];
			}
			for (int i = 0; i < pessoas.length-meio; i++) {
				right[i] = pessoas[i + meio];
			}
			mergeSort(left);
			mergeSort(right);
			merge(pessoas, left, right);
		}	
		
		long depois = System.nanoTime();
		return (depois-antes);
	}
	
	public void merge(Pessoa[] pessoas, Pessoa[] left, Pessoa[] right) {
		int i = 0, l = 0, r = 0;
		while(l < left.length && r < right.length) {
			if(left[l].compareTo(right[r]) <= 0) {
				pessoas[i] = left[l];
				l++;
			} else {
				pessoas[i] = right[r];
				r++;
			}
			i++;
		}
		
		while(l < left.length) {
			pessoas[i] = left[l];
			i++;
			l++;
		}
		
		while(r < right.length) {
			pessoas[i] = right[r];
			i++;
			r++;
		}
	}

	@Override
	public long mergeSort_Java(Pessoa[] pessoas) {
		long antes = System.nanoTime();
		Arrays.sort(pessoas);
		long depois = System.nanoTime();
		return (depois-antes);
	}

	@Override
	public long quickSort(Pessoa[] pessoas) {
		long antes = System.nanoTime();
		quickSortRecursivo(pessoas, 0, pessoas.length-1);
		long depois = System.nanoTime();
		return (depois-antes);
	}
	
	public void quickSortRecursivo(Pessoa[] pessoas, int left, int right) {
		if(left<right) {
			int pivot = partition(pessoas, left, right);;
			quickSortRecursivo(pessoas, left, pivot-1);
			quickSortRecursivo(pessoas, pivot+1, right);
		}
	}
	
	private int partition(Pessoa[] pessoas, int left, int right) {
		Pessoa pivot = pessoas[right];
		int i = left-1;
		for(int j = left; j<right; j++) {
			if(pessoas[j].compareTo(pivot) <= 0) {
				i++;
				swap(pessoas, i, j);
			}
		}
		swap(pessoas,right,i+1);
		return i+1;
	}

	@Override
	public long random_quickSort(Pessoa[] pessoas) {
		long antes = System.nanoTime();
		randomQuickSort(pessoas,0,pessoas.length-1);
		long depois = System.nanoTime();
		return (depois-antes);
	}
	
	public void randomQuickSort(Pessoa[] pessoas, int left, int right) {
		if(left<right) {
			int pivot = randomPartition(pessoas,left,right);
			randomQuickSort(pessoas, left, pivot-1);
			randomQuickSort(pessoas, pivot+1, right);
		}
	}
	
	public int randomPartition(Pessoa[] pessoas, int left, int right) {
		int pos = random.nextInt(right-left)+left;
		swap(pessoas,right,pos);
		
		Pessoa pivot = pessoas[right];
		int i = left-1;
		for(int j = left; j<right; j++) {
			if(pessoas[j].compareTo(pivot) <= 0) {
				i++;
				swap(pessoas, i, j);
			}
		}
		swap(pessoas,right,i+1);
		return i+1;
	}

	@Override
	public long countingSort(Pessoa[] pessoas) {
		long antes = System.nanoTime();
		
		Pessoa[] B = new Pessoa[pessoas.length];
		int maior = pessoas[0].getIdade();
		for (int i = 0; i < pessoas.length; i++) {
			if(maior < pessoas[i].getIdade()) maior = pessoas[i].getIdade();
		}
		
		int[] C = new int[maior+1];
		for (int i = 0; i < pessoas.length; i++) {
			C[pessoas[i].getIdade()]++;
		}
		for (int i = 1; i < C.length; i++) {
			C[i] = C[i] + C[i-1];
		}
		for (int i = 0; i < B.length; i++) {
			B[C[pessoas[i].getIdade()]-1] = pessoas[i];
			C[pessoas[i].getIdade()]--;
		}
		
		System.arraycopy(B, 0, pessoas, 0, pessoas.length);
		long depois = System.nanoTime();
		return (depois-antes);
	}
	
	private void swap(Pessoa[] pessoas, int i, int j) {
		Pessoa aux = pessoas[i];
		pessoas[i] = pessoas[j];
		pessoas[j] = aux;
	}

}
