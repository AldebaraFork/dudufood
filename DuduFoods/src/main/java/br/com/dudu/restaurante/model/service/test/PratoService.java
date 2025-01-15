package br.com.dudu.restaurante.model.service.test;

import br.com.dudu.restaurante.model.entity.Prato;
import br.com.dudu.restaurante.model.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class PratoService {
    public static void main(String[] args) {

        Prato macarrao = new Prato();
        macarrao.setNome("Macarrao ao molho branco");
        macarrao.setDescricao("Molho branco caseiro, com noz moscada e brócolis");
        macarrao.setDisponibilidade(true);
        macarrao.setPreco(BigDecimal.valueOf(12.50));

        JPAUtil.getEntityManagerDuduFoods();
        entityManager.getTransaction().begin();
        entityManager.persist(macarrao);
        entityManager.getTransaction().commit();
        entityManager.close();

        System.out.println(macarrao.toString());
    }
}