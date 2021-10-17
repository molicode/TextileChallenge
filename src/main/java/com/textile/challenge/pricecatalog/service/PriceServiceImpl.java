package com.textile.challenge.pricecatalog.service;

import com.textile.challenge.pricecatalog.entity.Price;
import com.textile.challenge.pricecatalog.repository.PriceRepository;
import com.textile.challenge.pricecatalog.util.dtos.business.PriceDTO;
import com.textile.challenge.pricecatalog.util.dtos.errors.BusinessErrorMessage;
import com.textile.challenge.pricecatalog.util.exceptions.BrandNotFoundException;
import com.textile.challenge.pricecatalog.util.exceptions.PriceNotFoundException;
import com.textile.challenge.pricecatalog.util.exceptions.ProductNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.springframework.util.CollectionUtils.isEmpty;

@Service
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;
    private final BrandService brandService;
    private final ProductService productService;

    ModelMapper model = new ModelMapper();

    /**
     *
     * @param priceRepository
     * @param brandService
     * @param productService
     */
    @Autowired
    public PriceServiceImpl(PriceRepository priceRepository, BrandService brandService, ProductService productService) {
        this.priceRepository = priceRepository;
        this.brandService = brandService;
        this.productService = productService;
    }

    /**
     *
     * @param productId
     * @param brandId
     * @param applyDate
     * @return
     * @throws PriceNotFoundException
     * @throws BrandNotFoundException
     * @throws ProductNotFoundException
     */
    @Override
    public PriceDTO getProductPrice(Integer productId, Integer brandId, LocalDateTime applyDate) throws PriceNotFoundException, BrandNotFoundException, ProductNotFoundException {
        this.validateFields(brandId, productId);

        List<Price> priceList = this.priceRepository.findByProductIdBrandIdAndApplyDate(brandId, productId, applyDate);

        if (isEmpty(priceList)) {
            throw new PriceNotFoundException(String.format(BusinessErrorMessage.PRICE_NOT_FOUND_MESSAGE, productId));
        }

        return (priceList.size() == 1) ? model.map(priceList.get(0), PriceDTO.class) : getPriceMaxPriority(priceList);
    }

    /**
     *
     * @param brandId
     * @param productId
     * @throws BrandNotFoundException
     * @throws ProductNotFoundException
     */
    private void validateFields(Integer brandId, Integer productId) throws BrandNotFoundException, ProductNotFoundException {
        this.brandService.validateBrandId(brandId);
        this.productService.validateProductId(productId);
    }

    /**
     *
     * @param priceList
     * @return
     */
    private PriceDTO getPriceMaxPriority(List<Price> priceList) {
        return model.map(Collections.max(priceList, Comparator.comparingInt(Price::getPriority)), PriceDTO.class);
    }

}
