package API.RESTful.controllers;

import com.google.gson.Gson;

import API.RESTful.models.domain.Aluno;
import API.RESTful.models.services.AlunoService;
import spark.Route;

public class AlunoController {
	
	public static Route home = (req, res) -> {
		
		res.type("text/html");
		
		String html = "<h2>Incluir:</h2>"
				+  "<p>/aluno/incluir</p>"
				+ "<h2>Remover:</h2>"
				+ "<p>/aluno/deletar/:id</p>"
				+ "<h2>Obter:</h2>"
				+ "<p>/aluno/obter/:id</p>"
				+ "<h2>Obter Lista: </h2>"
				+ "<p>/aluno/obter-lista</p>"
				+ "<h2>Atualizar:</h2>"
				+ "<p>/aluno/atualizar/:id</p>";
		
		return html;
		
	};
	
	public static Route obterLista = (req, res) -> {
		
		return AlunoService.obterLista();
		
	};
	
	public static Route incluir = (req, res) -> {
		
		Aluno aluno = new Gson().fromJson(req.body(), Aluno.class);
		
		AlunoService.incluir(aluno);
		
		return aluno.getNome();
	};
	
	public static Route excluir = (req, res) -> {
		
		Integer index = Integer.valueOf(req.params("id"));
		
		Aluno aluno = AlunoService.obter(index); // Getting this variable before it is deleted.
		
		AlunoService.excluir(index);
		
		return "" + aluno;
	};
	
	public static Route obter = (req, res) -> {
		
		Integer index = Integer.valueOf(req.params("id"));
		
		Aluno aluno = AlunoService.obter(index);
		
		return "" + aluno;
	};
	
	public static Route atualizar = (req, res) -> {
		
		Integer index = Integer.valueOf(req.params("id"));
		
		Aluno aluno = AlunoService.obter(index);
		
		AlunoService.atualizar(aluno);
		
		return "" + aluno;
	};
	
}
