package br.com.codex.jpa.test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.codex.jpa.modelo.Conta;
import br.com.codex.jpa.modelo.Movimentacao;
import br.com.codex.jpa.modelo.TipoMovimentacao;

public class TesteRelacionamento {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		Conta conta = new Conta();

		conta.setAgencia(001);
		conta.setNumero(004);
//		conta.setTitular("Marcelo");
		conta.setSaldo(500.0);

		Movimentacao movimentacao = new Movimentacao();
	
		movimentacao.setData(LocalDateTime.now());
		movimentacao.setDescricao("Churrascaria Irineu");
		movimentacao.setValor(new BigDecimal(153.35));
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setConta(conta);

		em.getTransaction().begin();
		em.persist(conta);
		em.persist(movimentacao);
		em.getTransaction().commit();
		em.close();

	}

}
