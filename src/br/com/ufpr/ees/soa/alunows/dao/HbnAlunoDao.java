package br.com.ufpr.ees.soa.alunows.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.ufpr.ees.soa.alunows.model.Aluno;


public class HbnAlunoDao {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private static HbnAlunoDao instance;

	private HbnAlunoDao() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory("alunoWS-PU");
	}

	public static HbnAlunoDao getInstance() {
		if (instance == null) {
			instance = new HbnAlunoDao();
		}
		return instance;
	}

	public EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}

	public Aluno findById(Long id) {
		entityManager = getEntityManager();
		Aluno aluno = entityManager.find(Aluno.class, id);
		entityManager.close();
		return aluno;
	}

	public List<Aluno> findAllAluno() {
		entityManager = getEntityManager();
		List<Aluno> result = entityManager.createQuery("FROM Aluno a ORDER BY a.nome").getResultList();
		entityManager.close();
		return result;
	}

	public Aluno findAlunoByNR(String nr) {
		entityManager = getEntityManager();
		Query query = entityManager.createQuery("FROM Aluno a WHERE a.matricula = :nr");
		query.setParameter("nr", nr);
		List<Aluno> result = query.getResultList();
		entityManager.close();

		if (result == null || result.isEmpty()) {
			return null;
		}
		return result.get(0);
	}

	public Aluno insertAluno(Aluno aluno) {
		entityManager = getEntityManager();
		entityManager.persist(aluno);
		entityManager.flush();
		return aluno;
	}

	public Aluno updateAluno(Aluno aluno) {
		entityManager = getEntityManager();
		entityManager.merge(aluno);
		entityManager.flush();
		return aluno;
	}

	public void removeAluno(Long id) {
		entityManager = getEntityManager();
		Aluno aluno = entityManager.find(Aluno.class, id);
		entityManager.remove(aluno);
		entityManager.close();
	}

}
