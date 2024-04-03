package API.RESTful.models.domain;

import java.util.List;

public class Turma {
	
	private int id;
	// private List<Aluno> alunos;
	private List<Professor> professores;
	private Escola escola;
	
	public Turma(int id, List<Professor> professores, Escola escola) {
		this.id = id;
		this.professores = professores;
		this.escola = escola;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Professor> getProfessores() {
		return professores;
	}
	public void setProfessor(List<Professor> professor) {
		this.professores = professor;
	}
	public Escola getEscola() {
		return escola;
	}
	public void setEscola(Escola escola) {
		this.escola = escola;
	}
	
	@Override
	public String toString() {
		return String.format("ID: %d, Professor(es): %s, Escola: %s", id, professores, escola);
	}
	
}
