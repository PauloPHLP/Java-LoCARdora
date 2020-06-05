package edu.up.br.LoCARdora.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.up.LoCARdora.entity.Veiculo;

public class VeiculoDao {
	
	public void inserir(Veiculo veiculo) {
		
		EntityManager em = Conexao.getInstance().createEntityManager();
		em.getTransaction().begin();
		em.persist(veiculo);
		em.getTransaction().commit();
		
	}
	
	public Veiculo buscar(Integer id) {
		
		EntityManager em = Conexao.getInstance().createEntityManager();
		Veiculo veiculo = em.find(Veiculo.class, id);
		return veiculo;
		
	}	
	
	@SuppressWarnings("unchecked")
	public ArrayList<Veiculo> listar() {
		
		EntityManager em = Conexao.getInstance().createEntityManager();
		Query q = em.createQuery("select j from Veiculo j");
		
		return new ArrayList<Veiculo>(q.getResultList());
		
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Veiculo> listarCarros(String tipo) {
		
		EntityManager em = Conexao.getInstance().createEntityManager();
		
		Query q = em.createQuery("select j from Veiculo j where j.tipo = :tipo");
		q.setParameter("tipo", tipo);
		
		return new ArrayList<Veiculo>(q.getResultList());
		
	}
	
	public void alterar(Veiculo veiculo) {	
		
		EntityManager em = Conexao.getInstance().createEntityManager();
		em.getTransaction().begin();
		em.merge(veiculo);
		em.getTransaction().commit();
		
	}
	
	public void remover(Integer id) {	
		
		EntityManager em = Conexao.getInstance().createEntityManager();
		em.getTransaction().begin();
		Veiculo veiculo = em.find(Veiculo.class, id);		
		em.remove(veiculo);
		em.getTransaction().commit();
		
	}

}
