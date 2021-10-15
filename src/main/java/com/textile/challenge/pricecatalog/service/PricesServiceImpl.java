package com.textile.challenge.pricecatalog.service;

import com.textile.challenge.pricecatalog.entity.Price;
import com.textile.challenge.pricecatalog.repository.PriceRepository;
import com.textile.challenge.pricecatalog.util.dtos.business.PriceDTO;
import com.textile.challenge.pricecatalog.util.exceptions.NotFoundExceptions;
import com.textile.challenge.pricecatalog.util.mapper.PriceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class PricesServiceImpl implements PricesService {

    @Autowired
    private PriceRepository priceRepository;

    @Autowired
    private PriceMapper priceMapper;


    @Override
    public PriceDTO getProductPrice(Long productId, Long brandId, LocalDateTime applyDate) throws NotFoundExceptions {
        List<Price> priceList = this.priceRepository.findByProductIdBrandIdAndApplyDate(brandId, productId, applyDate);

        if (CollectionUtils.isEmpty(priceList)) {
            System.out.println("Error ");
            //throw new PriceNotFoundException(String.format(PRICE_NOT_FOUND_MSG, productId));
        }

        if (priceList.size() == 1) {
            return priceMapper.priceToPriceDto(priceList.get(0), productId, brandId);
        } else {
            return getPriceMaxPriority(priceList);
        }

    }


    private PriceDTO getPriceMaxPriority(List<Price> priceList) {
        Price price = Collections.max(priceList, Comparator.comparingInt(Price::getPriority));
        return this.priceMapper.priceToPriceDto(price, price.getProduct().getProductId(), price.getBrand().getBrandId());
    }

}
