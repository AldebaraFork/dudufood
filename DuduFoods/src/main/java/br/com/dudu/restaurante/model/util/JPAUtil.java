package br.com.dudu.restaurante.model.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static final EntityManagerFactory duduFoods = Persistence.createEntityManagerFactory("DuduFoods");
    public static EntityManager getEntityManagerDuduFoods() {
        return duduFoods.createEntityManager();
    }
}
