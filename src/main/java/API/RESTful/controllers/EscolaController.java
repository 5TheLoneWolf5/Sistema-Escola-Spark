package API.RESTful.controllers;

import com.google.gson.Gson;

import API.RESTful.models.domain.Escola;
import API.RESTful.models.services.EscolaService;
import spark.Route;

public class EscolaController {

public static Route home = (req, res) -> {
		
		String html = "<h2>Incluir:</h2>"
				+  "<p>/escola/incluir</p>"
				+ "<h2>Remover:</h2>"
				+ "<p>/escola/deletar/:id</p>"
				+ "<h2>Obter:</h2>"
				+ "<p>/escola/obter/:id</p>"
				+ "<h2>Obter Lista: </h2>"
				+ "<p>/escola/obter-lista</p>"
				+ "<h2>Atualizar:</h2>"
				+ "<p>/escola/atualizar/:id</p>";
		
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
		
		/* IDEA: String[] test = turma.toString().split(",");
		
		String resultado = <br />;
		
		for (int i = 0; i < test.length; i++) {
			String[] currentField = test[i].split(":");
			resultado = "<h2>" + currentField + "</h2><hr />";
		}
		
		return turma; */
		
		return "" + escola;
	};
	
	public static Route atualizar = (req, res) -> {
		
		Integer indexAntigo = Integer.valueOf(req.params("id"));
		
		// Escola escolaAntiga = EscolaService.obter(index);
		
		Escola escolaAtualizacao = new Gson().fromJson(req.body(), Escola.class);
		
		EscolaService.atualizar(indexAntigo, escolaAtualizacao);
		
		return "" + escolaAtualizacao;
	};
	
}
