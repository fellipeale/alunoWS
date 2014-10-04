package br.com.ufpr.ees.soa.alunows.dao;

import java.util.List;

import br.com.ufpr.ees.soa.alunows.model.Aluno;

public interface AlunoDAO {

	public Aluno insertAluno(Aluno aluno);
	public Aluno updateAluno(Aluno aluno);
	public void removeAluno(Long id);
	public Aluno findById(Long id);
	public Aluno findAlunoByNR(String nr);
	public List<Aluno> findAllAluno();

}
