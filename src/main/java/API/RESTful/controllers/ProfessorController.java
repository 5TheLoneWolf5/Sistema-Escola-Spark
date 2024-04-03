package API.RESTful.controllers;

import com.google.gson.Gson;

import API.RESTful.models.domain.Professor;
import API.RESTful.models.services.ProfessorService;
import spark.Route;

public class ProfessorController {
	
	public static Route home = (req, res) -> {
		
		String html = "<h2>Incluir:</h2>"
				+ "<h2>Remover:</h2>"
				+ "<h2>Obter:</h2>"
				+ "<h2>Obter Lista: </h2>"
				+ "<h2>Atualizar:</h2>";
		
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
