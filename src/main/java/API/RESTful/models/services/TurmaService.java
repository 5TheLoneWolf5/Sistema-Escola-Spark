package API.RESTful.models.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import API.RESTful.models.domain.Turma;

public class TurmaService {
	
	private static Map<Integer, Turma> turmas = new HashMap<Integer, Turma>();
	
	private static Integer id = 0;
	
	public static void incluir(Turma turma) {
		
		turma.setId(++id);
		
		turmas.put(turma.getId(), turma);
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
	
	public static void atualizar(Turma turma) {
		turmas.replace(turma.getId(), turma);
	}
}
