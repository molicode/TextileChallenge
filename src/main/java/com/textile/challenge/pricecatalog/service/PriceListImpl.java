package com.textile.challenge.pricecatalog.service;

import com.textile.challenge.pricecatalog.entity.PriceList;
import com.textile.challenge.pricecatalog.repository.PriceListRepository;
import com.textile.challenge.pricecatalog.util.dtos.errors.BusinessErrorMessage;
import com.textile.challenge.pricecatalog.util.exceptions.PriceListNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PriceListImpl implements PriceListService {

    private final PriceListRepository priceListRepository;

    @Autowired
    public PriceListImpl(PriceListRepository priceListRepository) {
        this.priceListRepository = priceListRepository;
    }

    @Override
    public void validatePriceListId(Integer priceListId) throws PriceListNotFoundException {
        Optional<PriceList> priceListOptional = priceListRepository.findById(priceListId);

        if (priceListOptional.isEmpty()) {
            throw new PriceListNotFoundException(String.format(BusinessErrorMessage.PRICE_LIST_NOT_FOUND_MESSAGE, priceListId));
        }
    }
}
