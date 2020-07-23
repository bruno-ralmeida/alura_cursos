package br.com.codex.jpa.test;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.codex.jpa.modelo.Cliente;
import br.com.codex.jpa.modelo.Conta;

public class TesteClienteConta {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Conta conta = new Conta();
		conta.setId(3L);
		
		Cliente cliente = new Cliente();
		cliente.setNome("Bruno Rocha");
		cliente.setEndereco("Santo André/SP");
		cliente.setProfissao("Engenheiro de Software Itaú");
		cliente.setConta(conta);
		

		ArrayList<Object> transactions = new ArrayList<Object>();
		
		transactions.add(cliente);
		
		em.getTransaction().begin();

		for (Object p : transactions) {
			em.persist(p);
		
		} 

		em.getTransaction().commit();
		em.close();

	}
}
