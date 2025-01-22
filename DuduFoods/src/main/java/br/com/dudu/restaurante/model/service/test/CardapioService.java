package br.com.dudu.restaurante.model.service.test;

import br.com.dudu.restaurante.model.dao.CategoriaDao;
import br.com.dudu.restaurante.model.entity.Cardapio;
import br.com.dudu.restaurante.model.entity.Categoria;
import br.com.dudu.restaurante.model.util.JPAUtil;
import br.com.dudu.restaurante.model.dao.CardapioDao;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CardapioService {

    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerDuduFoods();
        Categoria pratoPrincipal = new Categoria("Prato Principal");
        CadastrarProdutoCardapio(entityManager, pratoPrincipal);


    }

    private static Categoria CadastrarCategoria(EntityManager entityManager) {

        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        Categoria pratoPrincipal = new Categoria("Prato Principal");
        entityManager.getTransaction().begin();
        categoriaDao.cadastrar(pratoPrincipal);
        entityManager.getTransaction().commit();
        entityManager.clear();
        return pratoPrincipal;
    }

    private static void  CadastrarProdutoCardapio(EntityManager entityManager, Categoria categoria ) {
        Cardapio macarrao = new Cardapio();
        Cardapio strogonoff = new Cardapio();



        macarrao.setNome("Macarrao");
        macarrao.setDescricao("macarrao a bolonhesa");
        macarrao.setPreco(BigDecimal.valueOf(12.5));
        macarrao.setDisponibilidade(true);
        macarrao.setCategoria(categoria);

        strogonoff.setNome("strogonoff");
        strogonoff.setDescricao("strogonoff de frango");
        strogonoff.setPreco(BigDecimal.valueOf(15.5));
        strogonoff.setDisponibilidade(true);
        strogonoff.setCategoria(categoria);

        CardapioDao cardapioDao = new CardapioDao(entityManager);
        entityManager.getTransaction().begin();

        cardapioDao.cadastrar(macarrao);
        cardapioDao.cadastrar(strogonoff);
        System.out.println("Prato consultado: " + cardapioDao.visualizar(1));
        System.out.println("Prato consultado: " + cardapioDao.visualizar(2));

        entityManager.close();

    }
}