package com.example.promotionProduct.servic;

import com.example.promotionProduct.dto.PromotionResponseDto;
import com.example.promotionProduct.repository.PromotionRepository;
import com.example.promotionProduct.repository.PromotionRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PromotionService {

    private final PromotionRepository promotionRepository;

    private final PromotionRepositoryCustom promotionRepositoryCustom;

    public List<PromotionResponseDto> getActivePromotions(LocalDateTime now) {
        return promotionRepository.findByStartDateTimeLessThanEqualAndEndDateTimeGreaterThanEqual(now, now)
                .stream().map(PromotionResponseDto::from)
                .toList();
    }


    public List<PromotionResponseDto> getActivePromotionsNative() {
        return promotionRepositoryCustom.findActivePromotions();
    }


}
