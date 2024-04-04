package API.RESTful.controllers;

import com.google.gson.Gson;

import API.RESTful.models.domain.Turma;
import API.RESTful.models.services.TurmaService;
import spark.Route;

public class TurmaController {

	public static Route home = (req, res) -> {
		
		String html = "<head>"
				+ "<meta charset=\"utf-8\" />"
				+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\" />"
				+ "<meta name=\"description\" content=\"\" />"
				+ "<meta name=\"author\" content=\"\" />"
				+ "<title>Turma</title>"
				+ "<link rel=\"icon\" type=\"image/x-icon\" href=\"./Infnet_Fundo_Branco.png\" />"
				+ "<link href=\"./styles.css\" rel=\"stylesheet\" />"
				+ "</head>"
				+ "<div class=\"container-links\"><h2>Incluir:</h2>"
				+  "<p>/turma/incluir</p>"
				+ "<h2>Remover:</h2>"
				+ "<p>/turma/deletar/:id</p>"
				+ "<h2>Obter:</h2>"
				+ "<p>/turma/obter/:id</p>"
				+ "<h2>Obter Lista: </h2>"
				+ "<p>/turma/obter-lista</p>"
				+ "<h2>Atualizar:</h2>"
				+ "<p>/turma/atualizar/:id</p></div>";
		
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
		
		Integer indexAntigo = Integer.valueOf(req.params("id"));
		
		// Turma turmaAntiga = TurmaService.obter(index);
		
		Turma turmaAtualizacao = new Gson().fromJson(req.body(), Turma.class);
		
		TurmaService.atualizar(indexAntigo, turmaAtualizacao);
		
		return "" + turmaAtualizacao;
	};
	
}
