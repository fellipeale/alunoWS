package br.com.ufpr.ees.soa.alunows.dao;

import java.util.List;

import javax.ejb.Stateful;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.ufpr.ees.soa.alunows.model.Aluno;

@Alternative
@Stateful
public class AlunoHibernate implements AlunoDAO {

	@Inject
	private EntityManager entityManager;
	
	@Override
	public Aluno insertAluno(Aluno aluno) {
		entityManager.persist(aluno);
//		entityManager.flush();
		return aluno;
	}

	@Override
	public Aluno updateAluno(Aluno aluno) {
		entityManager.merge(aluno);
//		entityManager.flush();
		return aluno;
	}

	@Override
	public void removeAluno(Long id) {
		Aluno aluno = entityManager.find(Aluno.class, id);
		entityManager.remove(aluno);
	}

	@Override
	public Aluno findById(Long id) {
		return entityManager.find(Aluno.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Aluno findAlunoByNR(String nr) {
		Query query = entityManager.createQuery("FROM Aluno a WHERE a.matricula = :nr");
		query.setParameter("nr", nr);
		List<Aluno> result = query.getResultList();

		if (result == null || result.isEmpty()) {
			return null;
		}
		return result.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Aluno> findAllAluno() {
		return entityManager.createQuery("FROM Aluno a ORDER BY a.nome").getResultList();
	}

}
