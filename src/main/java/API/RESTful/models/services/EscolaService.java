package API.RESTful.models.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import API.RESTful.models.domain.Escola;

public class EscolaService {
	
	private static Map<Integer, Escola> escolas = new HashMap<Integer, Escola>();
	
	private static Integer id = 0;
	
	public static void incluir(Escola escola) {
		
		escola.setId(++id);
		
		escolas.put(escola.getId(), escola);
	}
	
	public static void excluir(Integer id) {
		escolas.remove(id);
	}
	
	public static Collection<Escola> obterLista() {
		return escolas.values();
	}
	
	public static Escola obter(Integer id) {
		return escolas.get(id);
	}
	
	public static void atualizar(Escola escola) {
		escolas.replace(escola.getId(), escola);
	}
	
}
