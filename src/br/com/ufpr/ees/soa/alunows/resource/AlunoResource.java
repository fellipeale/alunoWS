package br.com.ufpr.ees.soa.alunows.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.ufpr.ees.soa.alunows.dao.AlunoDAO;
import br.com.ufpr.ees.soa.alunows.model.Aluno;

@Path("/aluno")
public class AlunoResource {

	@Inject
	private AlunoDAO dao;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Aluno> buscarAlunos() {
		return dao.findAllAluno();
	}

	@GET
	@Path("/{nr}")
	@Produces(MediaType.APPLICATION_JSON)
	public Aluno buscarAlunoNR(@PathParam("nr") String nr) {
		return dao.findAlunoByNR(nr);
	}

	@GET
	@Path("/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Aluno buscarAlunoNR(@PathParam("id") Long id) {
		return dao.findById(id);
	}

	@POST
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Aluno inserirAluno(Aluno aluno) {
		dao.insertAluno(aluno);
		return aluno;
	}

	@PUT
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Aluno atualizarAluno(Aluno aluno) {
		dao.updateAluno(aluno);
		return aluno;
	}

	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void removerAluno(@PathParam("id") Long id) {
		dao.removeAluno(id);
	}

}
