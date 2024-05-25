package atividade03;

public class Pessoa implements Comparable<Pessoa>  {
	
	private int idade;
	private long cpf;
	private String nome;
	
	public Pessoa(int idade, long cpf, String nome) {
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
	public long getCpf() {
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
		if(this.cpf < o.cpf) return -1;
		else if(cpf > o.cpf) return 1;
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return cpf == other.cpf;
	}

}
