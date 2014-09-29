package br.com.ufpr.ees.soa.alunows.helper;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import br.com.ufpr.ees.soa.alunows.model.Aluno;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;


public class AlunoWSHelper {
	
	private static String ALUNO_WS_ENDPOINT = "http://localhost:8080/alunoWS/rest/aluno";
	
	private static URI buildURI(String uri) {
		return UriBuilder.fromUri(uri).build();
	}

	private WebResource getWebResource(String uri) {
		ClientConfig config = new DefaultClientConfig();
	    Client client = Client.create(config);
		WebResource resource = client.resource(buildURI(uri));
		return resource;
	}
	
	public List<Aluno> buscarAlunos() {
		WebResource resource = getWebResource(ALUNO_WS_ENDPOINT);

		String result = resource.accept(MediaType.APPLICATION_JSON).get(String.class).toString();

		Gson gson = new GsonBuilder().create();
		Aluno[] alunos = gson.fromJson(result, Aluno[].class);

		return Arrays.asList(alunos);
	}
	
	public Aluno buscarAluno(String numeroMatricula) {
		WebResource resource = getWebResource(ALUNO_WS_ENDPOINT + "/" + numeroMatricula);

		String result = resource.accept(MediaType.APPLICATION_JSON).get(String.class).toString();

		return jsonToAlunoObject(result);
	}
	
	public Aluno inserirAluno(Aluno aluno) {
		WebResource resource = getWebResource(ALUNO_WS_ENDPOINT);

		// FIXME error when calling
		String result = resource.accept(MediaType.APPLICATION_JSON).post(String.class, aluno).toString();

		return jsonToAlunoObject(result);
	}

	public Aluno atualizarAluno(Aluno aluno) {
		WebResource resource = getWebResource(ALUNO_WS_ENDPOINT);

		// FIXME error when calling
		String result = resource.accept(MediaType.APPLICATION_JSON).put(String.class, aluno).toString();

		return jsonToAlunoObject(result);
	}

	public void removerAluno(Long id) {
		WebResource resource = getWebResource(ALUNO_WS_ENDPOINT + "/" + id);

		resource.delete();
	}

	private Aluno jsonToAlunoObject(String jsonObject) {
		Gson gson = new GsonBuilder().create();
		Aluno aluno = gson.fromJson(jsonObject, Aluno.class);
		return aluno;
	}

}
