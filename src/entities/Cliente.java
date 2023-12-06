package entities;

public class Cliente {
	private String nome;
	private String cPF;
	private int idade;
	
	public Cliente() {
	}
	
	public Cliente(String nome, String cPF, int idade) {
		this.nome = nome;
		this.cPF = cPF;
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getcPF() {
		return cPF;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public String toString() {
		return "***DADOS PESSOAIS***\n\nNome: "
				+ nome
				+"\nIdade: "
				+ idade
				+ "\nCPF: "
				+ cPF;
	}
	
}
