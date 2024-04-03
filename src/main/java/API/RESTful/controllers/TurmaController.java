package API.RESTful.controllers;

import com.google.gson.Gson;

import API.RESTful.models.domain.Turma;
import API.RESTful.models.services.TurmaService;
import spark.Route;

public class TurmaController {

	public static Route home = (req, res) -> {
		
		String html = "<h2>Incluir:</h2>"
				+  "<p>/turma/incluir</p>"
				+ "<h2>Remover:</h2>"
				+ "<p>/turma/deletar/:id</p>"
				+ "<h2>Obter:</h2>"
				+ "<p>/turma/obter/:id</p>"
				+ "<h2>Obter Lista: </h2>"
				+ "<p>/turma/obter-lista</p>"
				+ "<h2>Atualizar:</h2>"
				+ "<p>/turma/atualizar/:id</p>";
		
		return html;
		
	};
	
	public static Route obterLista = (req, res) -> {
		
		return TurmaService.obterLista();
		
	};
	
	public static Route incluir = (req, res) -> {
		
		Turma turma = new Gson().fromJson(req.body(), Turma.class);
		
		TurmaService.incluir(turma);
		
		return turma.getId();
	};
	
	public static Route excluir = (req, res) -> {
		
		Integer index = Integer.valueOf(req.params("id"));
		
		Turma escola = TurmaService.obter(index); // Getting this var before it is deleted.
		
		TurmaService.excluir(index);
		
		return "" + escola;
	};
	
	public static Route obter = (req, res) -> {
		
		Integer index = Integer.valueOf(req.params("id"));
		
		Turma turma = TurmaService.obter(index);
		
		return turma.toString();
	};
	
public static Route atualizar = (req, res) -> {
		
		Integer index = Integer.valueOf(req.params("id"));
		
		Turma turma = TurmaService.obter(index);
		
		TurmaService.atualizar(turma);
		
		return "" + turma;
	};
	
}
