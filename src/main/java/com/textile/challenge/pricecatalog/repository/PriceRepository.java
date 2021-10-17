package com.textile.challenge.pricecatalog.repository;

import com.textile.challenge.pricecatalog.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Luis Molina
 */
@Repository
public interface PriceRepository extends JpaRepository<Price, Integer> {

    /**
     *  Consulta que devuelve el precio a aplicar en una tarifca determinada
     *
     * @param brandId
     * @param productId
     * @param aplicationDate
     * @return
     */
    @Query("SELECT p FROM Price p "
            + "WHERE p.brand.brandId = :brandId "
            + "AND p.product.productId = :productId "
            + "AND :aplicationDate BETWEEN p.startDate AND p.endDate")
    List<Price> findByProductIdBrandIdAndApplyDate(Integer brandId, Integer productId, LocalDateTime aplicationDate);
}
