package br.com.ufpr.ees.soa.alunows.util;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class Resources {

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunoWS-PU");

	@RequestScoped
	@PersistenceContext
	@Produces
	public EntityManager createEntityManager() {
		return factory.createEntityManager();
	}

}
