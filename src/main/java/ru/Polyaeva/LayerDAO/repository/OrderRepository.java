package ru.Polyaeva.LayerDAO.repository;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.Polyaeva.LayerDAO.entities.Order;



@Repository
public class OrderRepository {
    private final EntityManager entityManager;

    @Autowired
    public OrderRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public String getProductName(String name) {
        String jpql = "SELECT o FROM Order o WHERE o.customer.name = :customerName";
        return entityManager.createQuery(jpql, Order.class)
                .setParameter("customerName", name)
                .getResultList()
                .getFirst()
                .productName;
    }
}