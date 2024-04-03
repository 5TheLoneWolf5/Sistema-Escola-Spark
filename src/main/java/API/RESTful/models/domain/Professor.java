package API.RESTful.models.domain;

import java.util.List;

public class Professor extends Pessoa {
	
	private String periodo;
	// private List<Turma> turmas;
	private double salario;
	private List<String> materias; 
	
	public Professor(int id, String nome, int idade, String periodo, double salario, List<String> materias) {
		super(id, nome, idade);
		this.periodo = periodo;
		this.salario = salario;
		this.materias = materias;
	}
	
	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public List<String> getMaterias() {
		return materias;
	}

	public void setMaterias(List<String> materias) {
		this.materias = materias;
	}
	
	@Override
	public String toString() {
		return String.format("ID: %d, Nome: %s, Idade: %d, Período: %s, Salário: %f, Matérias: %s", super.getId(), super.getNome(), super.getIdade(), periodo, salario, materias);
	}
	
}