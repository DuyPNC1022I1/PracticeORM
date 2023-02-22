package com.example.demoorm.reponsity;

import com.example.demoorm.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class ProductReponsitory {
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private EntityManager entityManager;

    public List<Product> findAll() {
        String query = "SELECT p FROM Product AS p";
        TypedQuery<Product> strQuery = entityManager.createQuery(query, Product.class);
        return strQuery.getResultList();
    }

    public Product findById(int id) {
        String query = "SELECT p FROM Product AS p WHERE p.id = :id";
        TypedQuery<Product> strQuery = entityManager.createQuery(query, Product.class);
        strQuery.setParameter("id", id);
        return strQuery.getSingleResult();
    }

    public void create(Product product) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(product);
        transaction.commit();
        session.close();
    }

    public void update(Product product) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(product);
        transaction.commit();
        session.close();
    }

    public void delete(Product product) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(product);
        transaction.commit();
        session.close();
    }
}
