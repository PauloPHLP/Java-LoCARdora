package edu.up.br.LoCARdora.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.up.LoCARdora.entity.Cliente;

public class ClienteDao {
	
	public void inserir(Cliente cliente) {
		
		EntityManager em = Conexao.getInstance().createEntityManager();
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		
	}
	
	public Cliente buscar(Integer id) {
		
		EntityManager em = Conexao.getInstance().createEntityManager();
		Cliente cliente = em.find(Cliente.class, id);
		return cliente;
		
	}	
	
	public Cliente buscar(String email, String senha) {
		
		EntityManager em = Conexao.getInstance().createEntityManager();
		Query q = em.createQuery("select c from Cliente c "
				+ "where c.email = :email and c.senha = :senha");
		q.setParameter("email", email);
		q.setParameter("senha", senha);
		
		try {
			
			return (Cliente) q.getSingleResult();
			
		} catch (Exception ex) {
			
			return null;
			
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Cliente> listar() {
		
		EntityManager em = Conexao.getInstance().createEntityManager();
		Query q = em.createQuery("select j from Cliente j");
		
		return new ArrayList<Cliente>(q.getResultList());
		
	}
	
	public void alterar(Cliente cliente) {	
		
		EntityManager em = Conexao.getInstance().createEntityManager();
		em.getTransaction().begin();
		em.merge(cliente);
		em.getTransaction().commit();
		
	}
	
	public void remover(Integer id) {	
		
		EntityManager em = Conexao.getInstance().createEntityManager();
		em.getTransaction().begin();
		Cliente cliente = em.find(Cliente.class, id);		
		em.remove(cliente);
		em.getTransaction().commit();
		
	}

}
