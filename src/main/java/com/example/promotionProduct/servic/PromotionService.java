package com.example.promotionProduct.servic;

import com.example.promotionProduct.dto.PromotionResponseDto;
import com.example.promotionProduct.mapper.PromotionMapper;
import com.example.promotionProduct.repository.PromotionRepository;
import com.example.promotionProduct.repository.PromotionRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PromotionService {

    private final PromotionRepository promotionRepository;
    private final PromotionRepositoryCustom promotionRepositoryCustom;
    private final PromotionMapper promotionMapper;

    public List<PromotionResponseDto> getActivePromotions(LocalDateTime now) {
        return promotionMapper.toDtoList(
                promotionRepository
                        .findByStartDateTimeLessThanEqualAndEndDateTimeGreaterThanEqual(now, now)
        );
    }

    public List<PromotionResponseDto> getActivePromotionsNative() {
        return promotionRepositoryCustom.findActivePromotions();
    }


}
