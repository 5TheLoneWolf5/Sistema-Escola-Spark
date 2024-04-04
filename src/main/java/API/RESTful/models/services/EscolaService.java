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
	
	public static void atualizar(Integer indexAntigo, Escola escolaAtualizacao) {
		
		if (escolas.containsKey(indexAntigo)) {
			excluir(indexAntigo); // In case there happens an ID change. The updated object would otherwise just be floating around.
			escolas.put(escolaAtualizacao.getId(), escolaAtualizacao); // Not "replace", because "replace" does not change the key.
		} else {
			System.out.println("\nEscola não existe.\n");
		}
	}
	
}
