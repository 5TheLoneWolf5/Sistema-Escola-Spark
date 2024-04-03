package API.RESTful.models.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import API.RESTful.models.domain.Professor;

public class ProfessorService {

	private static Map<Integer, Professor> professores = new HashMap<Integer, Professor>();
	
	private static Integer id = 0;
	
	public static void incluir(Professor professor) {
		
		professor.setId(++id);
		
		professores.put(professor.getId(), professor);
	}
	
	public static void excluir(Integer id) {
		professores.remove(id);
	}
	
	public static Collection<Professor> obterLista() {
		return professores.values();
	}
	
	public static Professor obter(Integer id) {
		return professores.get(id);
	}
	
	public static void atualizar(Professor professor) {
		professores.replace(professor.getId(), professor);
	}
	
}
