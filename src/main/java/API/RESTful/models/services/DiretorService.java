package API.RESTful.models.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import API.RESTful.models.domain.Diretor;

public class DiretorService {

private static Map<Integer, Diretor> diretores  = new HashMap<Integer, Diretor>();
	
	private static Integer id = 0;
	
	public static void incluir(Diretor diretor) {
		
		diretor.setId(++id);
		
		diretores.put(diretor.getId(), diretor);
	}
	
	public static void excluir(Integer id) {
		diretores.remove(id);
	}
	
	public static Collection<Diretor> obterLista() {
		return diretores.values();
	}
	
	public static Diretor obter(Integer id) {
		return diretores.get(id);
	}
	
	public static void atualizar(Diretor diretor) {
		diretores.replace(diretor.getId(), diretor);
	}
	
}
