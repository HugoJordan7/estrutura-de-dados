package atividade02;

public class Pessoa implements Comparable<Pessoa>  {
	
	private int idade;
	private String nome;
	private int cpf;
	
	public Pessoa(int idade, int cpf, String nome) {
		this.idade = idade;
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public int getIdade() {
		return idade;
	}
	public String getNome() {
		return nome;
	}
	public int getCpf() {
		return cpf;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	@Override
	public int compareTo(Pessoa o) {
		if(idade < o.idade) return -1;
		else if(idade > o.idade) return 1;
		
		if(nome.compareTo(o.nome) > 0) return -1;
		else if(nome.compareTo(o.nome) < 0) return 1;
		
		if(this.cpf < o.cpf) return -1;
		else if(cpf > o.cpf) return 1;
		
		return 0;
	}

}
