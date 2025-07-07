package com.duong.ss01.repository;

import com.duong.ss01.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepoImpl implements ProductRepo{
    @PersistenceContext
    private EntityManager em;

    @Override
    public boolean insert(Product product) {
        try {
            em.persist(product);
            return true;
        }catch (Exception e){
            System.err.println("ERROR" + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Product product) {
        try {
            em.merge(product);
            return true;
        }catch (Exception e){
            System.err.println("ERROR" + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(Product product) {
        Product p = em.find(Product.class, product.getId());
        if (p != null) {
            em.remove(p);
            return true;
        }
        return false;
    }

    @Override
    public List<Product> getAll() {
        return em.createQuery("from product", Product.class)
                .getResultList();
    }

}
