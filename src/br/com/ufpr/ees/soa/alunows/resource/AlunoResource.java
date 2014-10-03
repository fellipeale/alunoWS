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
import javax.ws.rs.core.Response;

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
	@Path("/")
//	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserirAluno(Aluno aluno) {
		try {
			HbnAlunoDao.getInstance().insertAluno(aluno);
			return Response.status(200).entity(aluno).build();
		} catch (Exception ex) {
			System.out.println(ex.toString());
			return Response.status(500).build();
		}
	}

	@PUT
	@Path("/")
//	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizarAluno(Aluno aluno) {
		try {
			HbnAlunoDao.getInstance().updateAluno(aluno);
			return Response.status(200).entity(aluno).build();
		} catch (Exception ex) {
			System.out.println(ex.toString());
			return Response.status(500).build();
		}
	}

	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void removerAluno(@PathParam("id") Long id) {
		HbnAlunoDao.getInstance().removeAluno(id);
	}

}
