package atividade01;

public class BrincandoComBusca {

	public static void main(String[] args) {
		
		Busca_IF b = new Busca();
		final int numeroParaBuscar = -1; 
		
		final int[] vetor = b.geraVetorNumericoOrdenado(10000);
		
		long antes, depois;
		
		antes = System.nanoTime(); 
		b.buscaLinear_iterativa(vetor, numeroParaBuscar);
		depois = System.nanoTime(); 
		System.out.println("buscaLinear_iterativa:\t"+(depois-antes)); 
		
		antes = System.nanoTime();
		b.buscaLinear_iterativa_duasPontas(vetor, numeroParaBuscar);
		depois = System.nanoTime();
		System.out.println("buscaLinear_iterativa2:\t"+(depois-antes));

		antes = System.nanoTime();
		b.buscaLinear_recursiva(vetor, numeroParaBuscar);
		depois = System.nanoTime();
		System.out.println("buscaLinear_recursiva:\t"+(depois-antes));
	
		antes = System.nanoTime();
		b.buscaBinaria_iterativa(vetor, numeroParaBuscar);
		depois = System.nanoTime();
		System.out.println("buscaBinaria_iterativa:\t"+(depois-antes));
		
		antes = System.nanoTime();
		b.buscaBinaria_recursiva(vetor, numeroParaBuscar);
		depois = System.nanoTime();
		System.out.println("buscaBinaria_recursiva:\t"+(depois-antes));
		
	}

}