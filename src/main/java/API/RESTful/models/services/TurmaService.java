package API.RESTful.models.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import API.RESTful.models.domain.Turma;

public class TurmaService {
	
	public static Map<Integer, Turma> turmas = new HashMap<Integer, Turma>();
	
	// private static Integer id = 0;
	
	public static void incluir(Turma turma) {
		
		// turma.setId(++id);
		
		turmas.put(Integer.valueOf(turma.getId()), turma); // Freedom to choose any ID the end-user wants.
	}
	
	public static void excluir(Integer id) {
		turmas.remove(id);
	}
	
	public static Collection<Turma> obterLista() {
		return turmas.values();
	}
	
	public static Turma obter(Integer id) {
		return turmas.get(id);
	}
	
	public static void atualizar(Integer indexAntigo, Turma turmaAtualizacao) {
		
		if (turmas.containsKey(indexAntigo)) {
			excluir(indexAntigo); // In case there happens an ID change. The updated object would otherwise just be floating around.
			turmas.put(turmaAtualizacao.getId(), turmaAtualizacao); // Not "replace", because "replace" does not change the key.
		} else {
			System.out.println("\nTurma não existe.\n");
		}
		
	}
}
