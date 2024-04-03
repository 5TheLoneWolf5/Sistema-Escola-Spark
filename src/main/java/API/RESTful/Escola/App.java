package API.RESTful.Escola;

import API.RESTful.controllers.AlunoController;
import API.RESTful.controllers.DiretorController;
import API.RESTful.controllers.EscolaController;
import API.RESTful.controllers.ProfessorController;
import API.RESTful.controllers.TurmaController;
import API.RESTful.controllers.ViaCepController;
import spark.Spark;

public class App 
{
    public static void main( String[] args )
    {
    	Spark.staticFiles.location("/static_files");
    	
        Spark.port(8080);
       
        Spark.get("/", (req, res) -> {
        	return App.class.getResourceAsStream("/static_files/index.html");
        });
        
        // Rotas de "Aluno".
        Spark.get("/aluno", AlunoController.home);
        Spark.post("/aluno/incluir", AlunoController.incluir);
        Spark.delete("/aluno/deletar/:id", AlunoController.excluir);
        Spark.get("/aluno/obter/:id", AlunoController.obter);
        Spark.get("/aluno/obter-lista", AlunoController.obterLista);
        Spark.put("/aluno/atualizar/:id", AlunoController.atualizar);
        
        // Rotas de "Professor".
        Spark.get("/professor", ProfessorController.home);
        Spark.post("/professor/incluir", ProfessorController.incluir);
        Spark.delete("/professor/deletar/:id", ProfessorController.excluir);
        Spark.get("/professor/obter/:id", ProfessorController.obter);
        Spark.get("/professor/obter-lista", ProfessorController.obterLista);
        Spark.put("/professor/atualizar/:id", ProfessorController.atualizar);
	        
	     // Rotas de "Turma".
        Spark.get("/turma", TurmaController.home);
        Spark.post("/turma/incluir", TurmaController.incluir);
        Spark.delete("/turma/deletar/:id", TurmaController.excluir);
        Spark.get("/turma/obter/:id", TurmaController.obter);
        Spark.get("/turma/obter-lista", TurmaController.obterLista);
        Spark.put("/turma/atualizar/:id", TurmaController.atualizar);
	        
	     // Rotas de "Diretor".
        Spark.get("/diretor", DiretorController.home);
        Spark.post("/diretor/incluir", DiretorController.incluir);
        Spark.delete("/diretor/deletar/:id", DiretorController.excluir);
        Spark.get("/diretor/obter/:id", DiretorController.obter);
        Spark.get("/diretor/obter-lista", DiretorController.obterLista);
        Spark.put("/diretor/atualizar/:id", DiretorController.atualizar);
	        
	     // Rotas de "Escola".
        Spark.get("/escola", EscolaController.home);
        Spark.post("/escola/incluir", EscolaController.incluir);
        Spark.delete("/escola/deletar/:id", EscolaController.excluir);
        Spark.get("/escola/obter/:id", EscolaController.obter);
        Spark.get("/escola/obter-lista", EscolaController.obterLista);
        Spark.put("/escola/atualizar/:id", EscolaController.atualizar);
        
         // Rota de "ViaCep".
        Spark.get("/viacep/:cep", ViaCepController.getAddress);
        
        // There needs to be at least 1 HTTP method in order for the program to run.
    }
}
