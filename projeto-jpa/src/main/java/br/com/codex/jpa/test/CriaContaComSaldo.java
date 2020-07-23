package br.com.codex.jpa.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.codex.jpa.modelo.Conta;

public class CriaContaComSaldo {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");

		EntityManager em = emf.createEntityManager();
		Conta conta = new Conta();
		
		conta.setAgencia(001);
		conta.setNumero(002);
//		conta.setTitular("Ana");
		conta.setSaldo(500.0);
		
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
	}

}
