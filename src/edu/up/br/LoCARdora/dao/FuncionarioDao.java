package edu.up.br.LoCARdora.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.up.LoCARdora.entity.Funcionario;

public class FuncionarioDao {
	
	public void inserir(Funcionario funcionario) {
		
		EntityManager em = Conexao.getInstance().createEntityManager();
		em.getTransaction().begin();
		em.persist(funcionario);
		em.getTransaction().commit();
		
	}
	
	public Funcionario buscar(Integer id) {
		
		EntityManager em = Conexao.getInstance().createEntityManager();
		Funcionario funcionario = em.find(Funcionario.class, id);
		return funcionario;
		
	}	
	
	public Funcionario buscar(String email, String senha) {
		
		EntityManager em = Conexao.getInstance().createEntityManager();
		Query q = em.createQuery("select f from Funcionario f "
				+ "where f.email = :email and f.senha = :senha");
		q.setParameter("email", email);
		q.setParameter("senha", senha);
		
		try {
			
			return (Funcionario) q.getSingleResult();
			
		} catch (Exception ex) {
			
			return null;
			
		}
		
	}	
	
	@SuppressWarnings("unchecked")
	public ArrayList<Funcionario> listar() {
		
		EntityManager em = Conexao.getInstance().createEntityManager();
		Query q = em.createQuery("select j from Funcionario j");
		
		return new ArrayList<Funcionario>(q.getResultList());
		
	}
	
	public void alterar(Funcionario funcionario) {	
		
		EntityManager em = Conexao.getInstance().createEntityManager();
		em.getTransaction().begin();
		em.merge(funcionario);
		em.getTransaction().commit();
		
	}
	
	public void remover(Integer id) {	
		
		EntityManager em = Conexao.getInstance().createEntityManager();
		em.getTransaction().begin();
		Funcionario funcionario = em.find(Funcionario.class, id);		
		em.remove(funcionario);
		em.getTransaction().commit();
		
	}
	
}
