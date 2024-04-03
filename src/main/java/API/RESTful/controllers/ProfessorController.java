package API.RESTful.controllers;

import com.google.gson.Gson;

import API.RESTful.models.domain.Professor;
import API.RESTful.models.services.ProfessorService;
import spark.Route;

public class ProfessorController {
	
	public static Route home = (req, res) -> {
		
		String html = "<h2>Incluir:</h2>"
				+  "<p>/professor/incluir</p>"
				+ "<h2>Remover:</h2>"
				+ "<p>/professor/deletar/:id</p>"
				+ "<h2>Obter:</h2>"
				+ "<p>/professor/obter/:id</p>"
				+ "<h2>Obter Lista: </h2>"
				+ "<p>/professor/obter-lista</p>"
				+ "<h2>Atualizar:</h2>"
				+ "<p>/professor/atualizar/:id</p>";
		
		return html;
		
	};
	
	public static Route obterLista = (req, res) -> {
		
		return ProfessorService.obterLista();
		
	};
	
	public static Route incluir = (req, res) -> {
		
		// String nome = req.params("nome");
		
		Professor professor = new Gson().fromJson(req.body(), Professor.class);
		
		ProfessorService.incluir(professor);
		
		return professor.getNome();
	};
	
	public static Route excluir = (req, res) -> {
		
		Integer index = Integer.valueOf(req.params("id"));
		
		Professor funcionario = ProfessorService.obter(index); // Getting this var before it is deleted.
		
		ProfessorService.excluir(index);
		
		return "" + funcionario;
	};
	
	public static Route obter = (req, res) -> {
		
		Integer index = Integer.valueOf(req.params("id"));
		
		Professor professor = ProfessorService.obter(index);
		
		return "" + professor;
	};
	
	public static Route atualizar = (req, res) -> {
		
		Integer index = Integer.valueOf(req.params("id"));
		
		Professor professor = ProfessorService.obter(index);
		
		ProfessorService.atualizar(professor);
		
		return "" + professor;
	};
	
}
