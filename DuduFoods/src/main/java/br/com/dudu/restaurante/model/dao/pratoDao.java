package br.com.dudu.restaurante.model.dao;

import br.com.dudu.restaurante.model.entity.Prato;

import javax.persistence.EntityManager;

public class pratoDao {

    private EntityManager entityManager;

    public pratoDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    //METODOS CRUD
    public void cadastrar(Prato prato){
        this.entityManager.persist(prato);
        System.out.println(prato.toString());
    }

    public Prato visualizar(final Integer id){
        return this.entityManager.find(Prato.class, id);
    }

    public void atualizar(final Prato prato){
        this.entityManager.merge(prato);
    }

    public void excluir(final Prato prato){
        this.entityManager.remove(prato);
    }
}
