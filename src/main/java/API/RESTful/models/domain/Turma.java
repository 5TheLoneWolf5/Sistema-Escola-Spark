package API.RESTful.models.domain;

import java.util.List;

public class Turma {
	
	private int id;
	// private List<Aluno> alunos;
	private List<Professor> professor;
	private Escola escola;
	
	public Turma(int id, List<Professor> professor, Escola escola) {
		this.id = id;
		this.professor = professor;
		this.escola = escola;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Professor> getProfessor() {
		return professor;
	}
	public void setProfessor(List<Professor> professor) {
		this.professor = professor;
	}
	public Escola getEscola() {
		return escola;
	}
	public void setEscola(Escola escola) {
		this.escola = escola;
	}
	
	@Override
	public String toString() {
		return String.format("ID: %d\nProfessor(es): %h\nEscola: %h", id, professor, escola);
	}
	
}
