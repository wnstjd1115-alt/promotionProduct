package com.example.promotionProduct.mapper;

import com.example.promotionProduct.domain.Promotion;
import com.example.promotionProduct.dto.PromotionResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PromotionMapper {

    @Mapping(source = "product.productName", target = "productName")
    PromotionResponseDto toDto(Promotion promotion);

    List<PromotionResponseDto> toDtoList(List<Promotion> promotions);
}
