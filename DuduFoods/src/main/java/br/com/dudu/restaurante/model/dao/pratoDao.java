package br.com.dudu.restaurante.model.dao;

import br.com.dudu.restaurante.model.entity.Prato;

import javax.persistence.EntityManager;

public class pratoDao {

    private EntityManager entityManager;

    public pratoDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Prato prato){
        this.entityManager.persist(prato);
        System.out.println(prato.toString());
    }
}
