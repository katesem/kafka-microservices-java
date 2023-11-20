package com.recommendation.service;

import com.recommendation.model.Recommendation;
import com.recommendation.repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationService {

    private final RecommendationRepository recommendationRepository;

    @Autowired
    public RecommendationService(RecommendationRepository recommendationRepository) {
        this.recommendationRepository = recommendationRepository;
    }

    public Recommendation getRecommendationById(Long recommendationId) {
        return recommendationRepository.findById(recommendationId).orElse(null);
    }

    public Recommendation createRecommendation(Recommendation recommendation) {
        return recommendationRepository.save(recommendation);
    }

    public Recommendation updateRecommendation(Long recommendationId, Recommendation recommendation) {
        Recommendation existingRecommendation = recommendationRepository.findById(recommendationId).orElse(null);
        if (existingRecommendation != null) {
            // Set updated fields of existingRecommendation using recommendation
            existingRecommendation.setTitle(recommendation.getTitle());
            existingRecommendation.setDescription(recommendation.getDescription());
            // Set other fields as needed
            return recommendationRepository.save(existingRecommendation);
        }
        return null; // or throw an exception for not found
    }

    public void deleteRecommendation(Long recommendationId) {
        recommendationRepository.deleteById(recommendationId);
    }

    public List<Recommendation> getAllRecommendations() {
        return recommendationRepository.findAll();
    }
}
