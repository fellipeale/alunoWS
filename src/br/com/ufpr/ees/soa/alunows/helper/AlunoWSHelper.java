package br.com.ufpr.ees.soa.alunows.helper;

import java.net.URI;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import br.com.ufpr.ees.soa.alunows.model.Aluno;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
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
		return resource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).get(new GenericType<List<Aluno>>() {});
	}
	
	public Aluno buscarAlunoNR(String numeroMatricula) {
		WebResource resource = getWebResource(ALUNO_WS_ENDPOINT + "/" + numeroMatricula);
		return resource.accept(MediaType.APPLICATION_JSON).get(Aluno.class);
	}
	
	public Aluno buscarAlunoPorId(Long id) {
		WebResource resource = getWebResource(ALUNO_WS_ENDPOINT + "/id/" + id);
		return resource.accept(MediaType.APPLICATION_JSON).get(Aluno.class);
	}

	public Aluno inserirAluno(Aluno aluno) {
		WebResource resource = getWebResource(ALUNO_WS_ENDPOINT);
		return resource.accept(MediaType.APPLICATION_JSON).post(Aluno.class, aluno);
	}

	public Aluno atualizarAluno(Aluno aluno) {
		WebResource resource = getWebResource(ALUNO_WS_ENDPOINT);
		return resource.accept(MediaType.APPLICATION_JSON).put(Aluno.class, aluno);
	}

	public void removerAluno(Long id) {
		WebResource resource = getWebResource(ALUNO_WS_ENDPOINT + "/" + id);
		resource.type(MediaType.APPLICATION_JSON).delete(Aluno.class, id);
	}

}
