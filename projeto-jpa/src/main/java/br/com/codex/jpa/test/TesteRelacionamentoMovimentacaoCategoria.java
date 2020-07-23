package br.com.codex.jpa.test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.codex.jpa.modelo.Categoria;
import br.com.codex.jpa.modelo.Conta;
import br.com.codex.jpa.modelo.Movimentacao;
import br.com.codex.jpa.modelo.TipoMovimentacao;

public class TesteRelacionamentoMovimentacaoCategoria {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Conta conta = new Conta();
		conta.setId(4L);
		
		Categoria categoria = new Categoria("Viagem");
		Categoria categoria2 = new Categoria("Negócios");
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setDescricao("Viagem à SP");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setData(LocalDateTime.now());
		movimentacao.setValor(new BigDecimal(299.99));
		movimentacao.setCategorias(Arrays.asList(categoria, categoria2));
		movimentacao.setConta(conta);
		
		Movimentacao movimentacao2 = new Movimentacao();
		movimentacao2.setDescricao("Viagem ao RJ");
		movimentacao2.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao2.setData(LocalDateTime.now());
		movimentacao2.setValor(new BigDecimal(329.87));
		movimentacao.setCategorias(Arrays.asList(categoria, categoria2));
		movimentacao.setConta(conta);
		
		ArrayList<Object> transactions = new ArrayList<Object>();
		
		transactions.add(categoria);
		transactions.add(categoria2);
		transactions.add(movimentacao);
		transactions.add(movimentacao2);
		
		em.getTransaction().begin();
		
		for (Object p : transactions) {
			em.persist(p);
		}
		
		em.getTransaction().commit();
		em.close();
		
	}

}
