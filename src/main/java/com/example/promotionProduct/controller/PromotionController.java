package com.example.promotionProduct.controller;

import com.example.promotionProduct.dto.PromotionResponseDto;
import com.example.promotionProduct.servic.PromotionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/promotions")
@RequiredArgsConstructor
public class PromotionController {

    private final PromotionService promotionService;

    @GetMapping
    public ResponseEntity<List<PromotionResponseDto>> getPromotions() {
        return ResponseEntity.ok(
                promotionService.getActivePromotions()
        );
    }
}
