package com.example.promotionProduct.repository;

import com.example.promotionProduct.dto.PromotionResponseDto;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PromotionRepositoryImpl implements PromotionRepositoryCustom{

    private final EntityManager em;

    @Override
    public List<PromotionResponseDto> findActivePromotions() {

        String sql = """
                SELECT
                    p.PROMOTION_CD,
                    p.PROD_CD,
                    pr.PROD_NM,
                    p.PROMO_PRICE,
                    p.START_DT,
                    p.END_DT
                FROM TB_PROMOTION p
                JOIN TB_PRODUCT pr
                    ON p.PROD_CD= pr.PROD_CD
                WHERE pr.USE_YN = 'Y'
                    AND p.START_DT <= CURRENT_TIMESTAMP
                    AND p.END_DT >= CURRENT_TIMESTAMP
                """;

        List<Object[]> result = em.createNativeQuery(sql).getResultList();

        return result.stream()
                .map(row -> new PromotionResponseDto(
                        (String) row[0],
                        (String) row[1],
                        (String) row[2],
                        (String) row[3],
                        (LocalDateTime) row[4],
                        (LocalDateTime) row[5]
                )
        ) .toList();
    }
}
