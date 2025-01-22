package br.com.dudu.restaurante.model.dao;


import br.com.dudu.restaurante.model.entity.Cardapio;
import br.com.dudu.restaurante.model.entity.Categoria;

import javax.persistence.EntityManager;

public class CategoriaDao {

    private EntityManager entityManager;

    public CategoriaDao(EntityManager em) {

    }


    //METODOS CRUD
    public void cadastrar( Categoria categoria){
        entityManager.persist(categoria);
        System.out.println(categoria.toString());
    }
    public Categoria visualizar(final Integer id){
        return this.entityManager.find(Categoria.class, id);
    }
    public void atualizar(final Categoria categoria){
        this.entityManager.merge(categoria);
    }
    public void excluir(final Categoria categoria){
        this.entityManager.remove(categoria);
    }

}
