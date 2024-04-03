package API.RESTful.models.domain;

public class Aluno extends Pessoa {
	
	private boolean precisaAcomodacoes;
	private Turma turma;
	private String[] competencias;
	
	public Aluno(int id, String nome, int idade, boolean precisaAcomodacoes, Turma turma, String[] competencias) {
		super(id, nome, idade);
		this.precisaAcomodacoes = precisaAcomodacoes;
		this.turma = turma;
		this.competencias = competencias;
	}
	
	public boolean getPrecisaAcomodacoes() {
		return precisaAcomodacoes;
	}

	public void setPrecisaAcomodacoes(boolean precisaAcomodacoes) {
		this.precisaAcomodacoes = precisaAcomodacoes;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public String[] getCompetencias() {
		return competencias;
	}

	public void setCompetencias(String[] competencias) {
		this.competencias = competencias;
	}
	
	@Override
	public String toString() {
		return String.format("ID: %d, Nome: %s, Idade: %d, Precisa de Acomodações: %b, Turma: %h, Competências: %s", super.getId(), super.getNome(), super.getIdade(), precisaAcomodacoes, turma, String.join(", ", competencias));
	}
	
}
