package com.example.promotionProduct.dto;

import com.example.promotionProduct.domain.Promotion;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class PromotionResponseDto {

    private String promotionCd;
    private String productCd;
    private String productName;
    private String promotionPrice;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    public static  PromotionResponseDto from(Promotion promotion) {
        return new PromotionResponseDto(
                promotion.getPromotionCd(),
                promotion.getProductCd(),
                promotion.getProduct() != null ? promotion.getProduct().getProductName() : null,
                promotion.getPromotionPrice(),
                promotion.getStartDateTime(),
                promotion.getEndDateTime()
        );
    }

}
