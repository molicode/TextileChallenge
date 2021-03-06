package com.textile.challenge.pricecatalog.repository;

import com.textile.challenge.pricecatalog.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Luis Molina
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
