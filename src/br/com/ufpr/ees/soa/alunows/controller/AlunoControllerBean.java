package br.com.ufpr.ees.soa.alunows.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.ufpr.ees.soa.alunows.helper.AlunoWSHelper;
import br.com.ufpr.ees.soa.alunows.model.Aluno;
import br.com.ufpr.ees.soa.alunows.model.Endereco;

@ManagedBean
@SessionScoped
public class AlunoControllerBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nr;

	private Aluno aluno;
	private List<Aluno> alunos;

	private AlunoWSHelper wsHelper;

	public AlunoControllerBean() {
		this.wsHelper = new AlunoWSHelper();
	}

	public String getNr() {
		return nr;
	}

	public void setNr(String nr) {
		this.nr = nr;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public String visualizarAluno(Long alunoId) {
		this.aluno = wsHelper.buscarAlunoPorId(alunoId);
		return "dadosAluno.xhtml";
	}

	public String buscarAlunos() {
		this.alunos = wsHelper.buscarAlunos();
		return "listarAlunos.xhtml";
	}

	public String buscarAlunoNR() {
		this.alunos = Arrays.asList(wsHelper.buscarAlunoNR(this.nr));
		return "listarAlunos.xhtml";
	}

	public String novoAluno() {
		this.aluno = new Aluno();
		this.aluno.setEndereco(new Endereco());
		return "inserirAluno.xhtml";
	}

	public String salvarAluno() {
		if (this.aluno.getId() == null) {
			this.aluno = wsHelper.inserirAluno(this.aluno);
		} else {
			this.aluno = wsHelper.atualizarAluno(this.aluno);
		}

		return "dadosAluno.xhtml";
	}

	public String removerAluno(Long alunoId) {
		wsHelper.removerAluno(alunoId);
		this.alunos = wsHelper.buscarAlunos();
		return "listarAlunos.xhtml";
	}

}
