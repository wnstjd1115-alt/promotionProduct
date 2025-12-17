package com.example.promotionProduct.servic;

import com.example.promotionProduct.dto.PromotionResponseDto;
import com.example.promotionProduct.repository.PromotionRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PromotionService {

    private final PromotionRepositoryCustom promotionRepository;


    public List<PromotionResponseDto> getActivePromotions() {
        return promotionRepository.findActivePromotions();
    }
}
