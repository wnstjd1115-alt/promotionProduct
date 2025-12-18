package com.example.promotionProduct.domain;

import com.example.promotionProduct.common.enums.UseYn;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "TB_PRODUCT")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {

    @Id
    @Column(name = "PROD_CD")
    private String productCd;

    @Column(name = "PROD_NM")
    private String productName;

    @Enumerated(EnumType.STRING)
    @Column(name = "USE_YN", length = 1)
    private UseYn useYn;

}
