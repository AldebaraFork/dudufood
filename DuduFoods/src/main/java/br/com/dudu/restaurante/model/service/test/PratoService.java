package br.com.dudu.restaurante.model.service.test;

import br.com.dudu.restaurante.model.entity.Prato;
import br.com.dudu.restaurante.model.util.JPAUtil;
import br.com.dudu.restaurante.model.dao.pratoDao;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class PratoService {

    public static void main(String[] args) {

        Prato macarrao = new Prato();
        macarrao.setNome("Macarrao ao molho branco");
        macarrao.setDescricao("Molho branco caseiro, com noz moscada e brócolis");
        macarrao.setDisponibilidade(true);
        macarrao.setPreco(BigDecimal.valueOf(12.50));

        Prato strogonoff = new Prato();


        EntityManager entityManager = JPAUtil.getEntityManagerDuduFoods();
        pratoDao pratoDao = new pratoDao(entityManager);
        entityManager.getTransaction().begin();
        pratoDao.cadastrar(macarrao);
        entityManager.flush();
        pratoDao.cadastrar(strogonoff);


        strogonoff.setPreco(BigDecimal.valueOf(12.50));
        pratoDao.atualizar(strogonoff);

        System.out.println("prato consultado: " + pratoDao.visualizar(2));





        strogonoff.setPreco(BigDecimal.valueOf(15.50));
        pratoDao.atualizar(strogonoff);

        System.out.println("prato consultado: " +pratoDao.visualizar(2));

        entityManager.close();
    }
}