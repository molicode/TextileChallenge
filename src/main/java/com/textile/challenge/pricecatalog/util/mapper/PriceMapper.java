package com.textile.challenge.pricecatalog.util.mapper;

import com.textile.challenge.pricecatalog.entity.Price;
import com.textile.challenge.pricecatalog.util.dtos.business.PriceDTO;
import org.mapstruct.Mapper;

@Mapper
public interface PriceMapper {

    PriceDTO priceToPriceDto(Price price, Long productId, Long brandId);

}
