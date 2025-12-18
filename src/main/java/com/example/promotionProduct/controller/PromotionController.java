package com.example.promotionProduct.controller;

import com.example.promotionProduct.dto.PromotionResponseDto;
import com.example.promotionProduct.servic.PromotionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/promotions")
@RequiredArgsConstructor
public class PromotionController {

    private final PromotionService promotionService;

    @GetMapping
    public ResponseEntity<List<PromotionResponseDto>> getPromotion() {
        return ResponseEntity.ok(
                promotionService.getActivePromotions(LocalDateTime.now())
        );
    }

    @GetMapping("/native")
    public ResponseEntity<List<PromotionResponseDto>> getPromotionsNative() {
        return ResponseEntity.ok(
                promotionService.getActivePromotionsNative()
        );
    }





}
