package com.textile.challenge.pricecatalog.service;

import com.textile.challenge.pricecatalog.entity.Brand;
import com.textile.challenge.pricecatalog.repository.BrandRepository;
import com.textile.challenge.pricecatalog.util.dtos.errors.BusinessErrorMessage;
import com.textile.challenge.pricecatalog.util.exceptions.BrandNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    /**
     *
     * @param brandRepository
     */
    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    /**
     *
     * @param brandId
     * @throws BrandNotFoundException
     */
    @Override
    public void validateBrandId(Integer brandId) throws BrandNotFoundException {
        Optional<Brand> brandOptional = brandRepository.findById(brandId);

        if (brandOptional.isEmpty()) {
            throw new BrandNotFoundException(String.format(BusinessErrorMessage.BRAND_NOT_FOUND_MESSAGE, brandId));
        }
    }
}


