package com.recommendation.controller;

import com.recommendation.model.Recommendation;
import com.recommendation.service.RecommendationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recommendations")
public class RecommendationController {

    private final RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @PostMapping("/")
    public ResponseEntity<Recommendation> createRecommendation(@RequestBody Recommendation recommendation) {
        Recommendation createdRecommendation = recommendationService.createRecommendation(recommendation);
        return new ResponseEntity<>(createdRecommendation, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recommendation> getRecommendationById(@PathVariable Long id) {
        Recommendation recommendation = recommendationService.getRecommendationById(id);
        if (recommendation != null) {
            return ResponseEntity.ok().body(recommendation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recommendation> updateRecommendation(@PathVariable Long id, @RequestBody Recommendation recommendation) {
        Recommendation updatedRecommendation = recommendationService.updateRecommendation(id, recommendation);
        if (updatedRecommendation != null) {
            return ResponseEntity.ok().body(updatedRecommendation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecommendation(@PathVariable Long id) {
        recommendationService.deleteRecommendation(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/")
    public ResponseEntity<List<Recommendation>> getAllRecommendations() {
        List<Recommendation> recommendations = recommendationService.getAllRecommendations();
        return ResponseEntity.ok().body(recommendations);
    }
}
