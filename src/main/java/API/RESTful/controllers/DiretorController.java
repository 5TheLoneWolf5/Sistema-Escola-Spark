package API.RESTful.controllers;

import com.google.gson.Gson;

import API.RESTful.models.domain.Diretor;
import API.RESTful.models.services.DiretorService;
import spark.Route;

public class DiretorController {
	
	public static Route home = (req, res) -> {
		
		String html = "<h2>Incluir:</h2>"
				+ "<h2>Remover:</h2>"
				+ "<h2>Obter:</h2>"
				+ "<h2>Obter Lista: </h2>"
				+ "<h2>Atualizar:</h2>";
		
		return html;
		
	};
	
	public static Route obterLista = (req, res) -> {
		
		return DiretorService.obterLista();
		
	};
	
	public static Route incluir = (req, res) -> {
		
		Diretor diretor = new Gson().fromJson(req.body(), Diretor.class);
		
		DiretorService.incluir(diretor);
		
		return diretor.getNome();
	};
	
	public static Route excluir = (req, res) -> {
		
		Integer index = Integer.valueOf(req.params("id"));
		
		Diretor diretor = DiretorService.obter(index); // Getting this var before it is deleted.
		
		DiretorService.excluir(index);
		
		return "" + diretor;
	};
	
	public static Route obter = (req, res) -> {
		
		Integer index = Integer.valueOf(req.params("id"));
		
		Diretor diretor = DiretorService.obter(index);
		
		return "" + diretor;
	};
	
public static Route atualizar = (req, res) -> {
		
		Integer index = Integer.valueOf(req.params("id"));
		
		Diretor diretor = DiretorService.obter(index);
		
		DiretorService.atualizar(diretor);
		
		return "" + diretor;
	};
}
