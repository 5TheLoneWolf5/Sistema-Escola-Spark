package API.RESTful.models.domain;

public class Escola {
	
	private int id;
	private String nome;
	private Diretor diretor;
	// private List<Turma> turmas; NO BIDIRECTIONAL RELATIONSHIP BECAUSE OF JSON.
	// Objects serving as "FKs".
	
	public Escola(int id, String nome, Diretor diretor) {
		this.id = id;
		this.nome = nome;
		this.diretor = diretor;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Diretor getDiretor() {
		return diretor;
	}

	public void setDiretor(Diretor diretor) {
		this.diretor = diretor;
	}
	
	@Override
	public String toString() {
		return String.format("Id: %d\nNome: %s\nDiretor: %h", id, nome, diretor);
	}
	
}
