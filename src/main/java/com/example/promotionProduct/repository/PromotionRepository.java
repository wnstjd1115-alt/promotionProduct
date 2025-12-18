package com.example.promotionProduct.repository;

import com.example.promotionProduct.domain.Promotion;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface PromotionRepository extends JpaRepository<Promotion, String> {

    @EntityGraph(attributePaths = "product")
    List<Promotion> findByStartDateTimeLessThanEqualAndEndDateTimeGreaterThanEqual(LocalDateTime now, LocalDateTime now1);
}
