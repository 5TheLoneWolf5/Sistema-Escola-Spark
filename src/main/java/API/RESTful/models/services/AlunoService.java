package API.RESTful.models.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import API.RESTful.models.domain.Aluno;

public class AlunoService {

	private static Map<Integer, Aluno> alunos = new HashMap<Integer, Aluno>();
	
	private static Integer id = 0;
	
	public static void incluir(Aluno aluno) {
		
		aluno.setId(++id);
		
		alunos.put(aluno.getId(), aluno);
	}
	
	public static void excluir(Integer id) {
		alunos.remove(id);
	}
	
	public static Collection<Aluno> obterLista() {
		return alunos.values();
	}
	
	public static Aluno obter(Integer id) {
		return alunos.get(id);
	}
	
	public static void atualizar(Integer indexAntigo, Aluno alunoAtualizacao) {
		
		if (alunos.containsKey(indexAntigo)) {
			excluir(indexAntigo);
			alunos.put(alunoAtualizacao.getId(), alunoAtualizacao);
		} else {
			System.out.println("\nAluno não existe.\n");
		}
	}

}
