package com.textile.challenge.pricecatalog.repository;

import com.textile.challenge.pricecatalog.entity.PriceList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceListRepository extends JpaRepository<PriceList, Long> {
}
