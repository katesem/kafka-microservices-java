package com.recommendation.repository;

import com.recommendation.model.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Using Spring Data JPA to interact with the database
//This interface allows creating, read, update, and delete Recommendation objects
@Repository
public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {

}