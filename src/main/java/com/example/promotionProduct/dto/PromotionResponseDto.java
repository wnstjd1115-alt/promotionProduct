package com.example.promotionProduct.dto;

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

}
