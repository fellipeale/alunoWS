package br.com.ufpr.ees.soa.alunows.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.ufpr.ees.soa.alunows.dao.HbnAlunoDao;
import br.com.ufpr.ees.soa.alunows.model.Aluno;

@Path("/aluno")
public class AlunoResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Aluno> buscarAlunos() {
		return HbnAlunoDao.getInstance().findAllAluno();
	}

	@GET
	@Path("/{nr}")
	@Produces(MediaType.APPLICATION_JSON)
	public Aluno buscarAlunoNR(@PathParam("nr") String nr) {
		return HbnAlunoDao.getInstance().findAlunoByNR(nr);
	}

	@GET
	@Path("/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Aluno buscarAlunoNR(@PathParam("id") Long id) {
		return HbnAlunoDao.getInstance().findById(id);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Aluno inserirAluno(Aluno aluno) {
		return HbnAlunoDao.getInstance().insertAluno(aluno);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Aluno atualizarAluno(Aluno aluno) {
		return HbnAlunoDao.getInstance().updateAluno(aluno);
	}

	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void removerAluno(@PathParam("id") Long id) {
		HbnAlunoDao.getInstance().removeAluno(id);
	}

}
