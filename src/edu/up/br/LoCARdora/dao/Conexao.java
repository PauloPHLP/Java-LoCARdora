package edu.up.br.LoCARdora.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexao {

	static EntityManagerFactory emf;

	public static EntityManagerFactory getInstance() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("Locardora");
		}
		return emf;

	}

}
