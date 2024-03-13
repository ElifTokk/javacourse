package com.test.javacourse.MarketPlace.repository;

import com.test.javacourse.MarketPlace.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Product saveProduct(Product product) {
        Product merge = entityManager.merge(product);
        return merge;

    }

}
