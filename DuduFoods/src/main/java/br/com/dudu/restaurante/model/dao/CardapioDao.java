package br.com.dudu.restaurante.model.dao;

import br.com.dudu.restaurante.model.entity.Cardapio;

import javax.persistence.EntityManager;

public class CardapioDao {

    private EntityManager entityManager;

    public CardapioDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    //METODOS CRUD
    public void cadastrar(Cardapio cardapio){
        this.entityManager.persist(cardapio);
        System.out.println(cardapio.toString());
    }

    public Cardapio visualizar(final Integer id){
        return this.entityManager.find(Cardapio.class, id);
    }

    public void atualizar(final Cardapio cardapio){
        this.entityManager.merge(cardapio);
    }

    public void excluir(final Cardapio cardapio){
        this.entityManager.remove(cardapio);
    }
}
