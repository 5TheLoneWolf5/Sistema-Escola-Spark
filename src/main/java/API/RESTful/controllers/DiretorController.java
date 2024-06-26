package API.RESTful.controllers;

import com.google.gson.Gson;

import API.RESTful.models.domain.Diretor;
import API.RESTful.models.services.DiretorService;
import spark.Route;

public class DiretorController {
	
	public static Route home = (req, res) -> {
		
		String html = "<head>"
				+ "<meta charset=\"utf-8\" />"
				+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\" />"
				+ "<meta name=\"description\" content=\"\" />"
				+ "<meta name=\"author\" content=\"\" />"
				+ "<title>Diretor</title>"
				+ "<link rel=\"icon\" type=\"image/x-icon\" href=\"./Infnet_Fundo_Branco.png\" />"
				+ "<link href=\"./styles.css\" rel=\"stylesheet\" />"
				+ "</head>"
				+ "<div class=\"container-links\"><h2>Incluir:</h2>"
				+  "<p>/diretor/incluir</p>"
				+ "<h2>Remover:</h2>"
				+ "<p>/diretor/deletar/:id</p>"
				+ "<h2>Obter:</h2>"
				+ "<p>/diretor/obter/:id</p>"
				+ "<h2>Obter Lista: </h2>"
				+ "<p>/diretor/obter-lista</p>"
				+ "<h2>Atualizar:</h2>"
				+ "<p>/diretor/atualizar/:id</p></div>";
		
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
		
		Integer indexAntigo = Integer.valueOf(req.params("id"));
		
		// Diretor diretorAntigo = DiretorService.obter(index);
		
		Diretor diretorAtualizacao = new Gson().fromJson(req.body(), Diretor.class);
		
		DiretorService.atualizar(indexAntigo, diretorAtualizacao);
		
		return "" + diretorAtualizacao;
	};
}
