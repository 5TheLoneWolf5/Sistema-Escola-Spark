package API.RESTful.controllers;

import com.google.gson.Gson;

import API.RESTful.models.domain.Escola;
import API.RESTful.models.domain.Turma;
import API.RESTful.models.services.EscolaService;
import API.RESTful.models.services.TurmaService;
import spark.Route;

public class TurmaController {

	public static Route home = (req, res) -> {
		
		String html = "<h2>Incluir:</h2>"
				+ "<h2>Remover:</h2>"
				+ "<h2>Obter:</h2>"
				+ "<h2>Obter Lista: </h2>"
				+ "<h2>Atualizar:</h2>";
		
		return html;
		
	};
	
	public static Route obterLista = (req, res) -> {
		
		return EscolaService.obterLista();
		
	};
	
	public static Route incluir = (req, res) -> {
		
		Escola escola = new Gson().fromJson(req.body(), Escola.class);
		
		EscolaService.incluir(escola);
		
		return escola.getNome();
	};
	
	public static Route excluir = (req, res) -> {
		
		Integer index = Integer.valueOf(req.params("id"));
		
		Escola escola = EscolaService.obter(index); // Getting this var before it is deleted.
		
		EscolaService.excluir(index);
		
		return "" + escola;
	};
	
	public static Route obter = (req, res) -> {
		
		Integer index = Integer.valueOf(req.params("id"));
		
		Escola escola = EscolaService.obter(index);
		
		return "" + escola;
	};
	
public static Route atualizar = (req, res) -> {
		
		Integer index = Integer.valueOf(req.params("id"));
		
		Turma turma = TurmaService.obter(index);
		
		TurmaService.atualizar(turma);
		
		return "" + turma;
	};
	
}
