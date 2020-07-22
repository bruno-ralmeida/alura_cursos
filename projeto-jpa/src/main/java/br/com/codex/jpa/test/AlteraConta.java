package br.com.codex.jpa.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.codex.jpa.modelo.Conta;

public class AlteraConta {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");

		EntityManager em = emf.createEntityManager();
		Conta conta = em.find(Conta.class, 5L);
		
	
		conta.setSaldo(50.0);
		
		System.out.println(conta.getSaldo());
		
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
	}

}
