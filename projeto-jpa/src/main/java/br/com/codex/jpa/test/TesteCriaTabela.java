package br.com.codex.jpa.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteCriaTabela {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		
		EntityManager createEntityManager = emf.createEntityManager();
		
		emf.close();
	}
}
