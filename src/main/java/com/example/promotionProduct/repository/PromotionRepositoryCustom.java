package com.example.promotionProduct.repository;

import com.example.promotionProduct.dto.PromotionResponseDto;

import java.util.List;

public interface PromotionRepositoryCustom {
    List<PromotionResponseDto> findActivePromotions();
}
