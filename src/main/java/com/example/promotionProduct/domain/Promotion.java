package com.example.promotionProduct.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "TB_PROMOTION")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Promotion {

    @Id
    @Column(name = "PROMOTION_CD")
    private String promotionCd;

    @Column(name = "PROD_CD", nullable = false)
    private String productCd;

    @Column(name = "PROMO_PRICE")
    private String promotionPrice;

    @Column(name = "START_DT")
    LocalDateTime startDateTime;

    @Column(name = "END_DT")
    LocalDateTime endDateTime;

}
