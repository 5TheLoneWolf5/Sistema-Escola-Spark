package API.RESTful.models.domain;

public class Diretor extends Pessoa {
	
	private double salario;
	private int premiacoes;
	private String[] objetivos;
	
	public Diretor(int id, String nome, int idade, double salario, int premiacoes, String[] objetivos) {
		super(id, nome, idade);
		this.salario = salario; 
		this.premiacoes = premiacoes;
		this.objetivos = objetivos;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public int getPremiacoes() {
		return premiacoes;
	}

	public void setPremiacoes(int premiacoes) {
		this.premiacoes = premiacoes;
	}
	
	public String[] getObjetivos() {
		return objetivos;
	}

	public void setObjetivos(String[] objetivos) {
		this.objetivos = objetivos;
	}
	
	@Override
	public String toString() {
		return String.format("ID: %d, Nome: %s, Idade: %d, Salário: %f, Premiações: %d, Objetivos: %s", super.getId(), super.getNome(), super.getIdade(), salario, premiacoes, String.join(", ", objetivos));
	}
	
}
