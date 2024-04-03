package API.RESTful.controllers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import spark.Request;
import spark.Response;
import spark.Route;

public class ViaCepController {
	
	public static Route getAddress = (Request req, Response res) -> {
		
		String cep = req.params("cep");
		String url = "https://viacep.com.br/ws/" + cep + "/json";
		System.out.println(url);
		
		HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
		
		int responseCode = connection.getResponseCode();
		
		System.out.println(responseCode);
		
		if (responseCode == HttpURLConnection.HTTP_OK) {
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder responseBuilder = new StringBuilder();
			String line;
			
			while ((line = reader.readLine()) != null) {
				responseBuilder.append(line);
			}
			
			reader.close();
			
			return responseBuilder.toString();
			
		} else {
			return "Erro ao obter dados de endereço para o CEP " + cep;
		}
		
	};
}
