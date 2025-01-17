package br.com.dudu.restaurante.model.service.test;

import br.com.dudu.restaurante.model.entity.Cardapio;
import br.com.dudu.restaurante.model.util.JPAUtil;
import br.com.dudu.restaurante.model.dao.CardapioDao;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CardapioService {

    public static void main(String[] args) {

        Cardapio macarrao = new Cardapio();
        macarrao.setNome("Macarrao ao molho branco");
        macarrao.setDescricao("Molho branco caseiro, com noz moscada e brócolis");
        macarrao.setDisponibilidade(true);
        macarrao.setPreco(BigDecimal.valueOf(12.50));

        Cardapio strogonoff = new Cardapio();


        EntityManager entityManager = JPAUtil.getEntityManagerDuduFoods();
        CardapioDao CardapioDao = new CardapioDao(entityManager);
        entityManager.getTransaction().begin();
        CardapioDao.cadastrar(macarrao);
        entityManager.flush();
        CardapioDao.cadastrar(strogonoff);


        strogonoff.setPreco(BigDecimal.valueOf(12.50));
        CardapioDao.atualizar(strogonoff);

        System.out.println("prato consultado: " + CardapioDao.visualizar(2));





        strogonoff.setPreco(BigDecimal.valueOf(15.50));
        CardapioDao.atualizar(strogonoff);

        System.out.println("prato consultado: " + CardapioDao.visualizar(2));

        entityManager.close();
    }
}