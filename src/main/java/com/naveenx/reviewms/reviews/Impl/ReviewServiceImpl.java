package com.naveenx.reviewms.reviews.Impl;

import com.naveenx.reviewms.reviews.Review;
import com.naveenx.reviewms.reviews.ReviewRepository;
import com.naveenx.reviewms.reviews.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public ReviewServiceImpl() {
        // Optional: Initialize fields here if needed
    }
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review getCompanyReviewById(Long reviewId) {

        return reviewRepository.findById(reviewId).orElse(null);
    }

    @Override
    public boolean createReview(Long companyId, Review review) {

        if (companyId != null) {
            review.setCompanyId(companyId);
            reviewRepository.save(review);
            return true;
        } else {
            return false;
        }
    }


    @Override
    public List<Review> getAllReviewsByCompanyId(Long companyId) {

        List<Review> reviews = reviewRepository.findByCompanyId(companyId);

        if (!reviews.isEmpty()) {
            return reviews;
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public boolean editReviewByCompanyIdReviewId(Long reviewId, Review updatedReview) {

        Review review = reviewRepository.findById(reviewId).orElse(null);

        if (review != null) {
            review.setReview(updatedReview.getReview());
            review.setRating(updatedReview.getRating());
            review.setCompanyId(updatedReview.getCompanyId());
            reviewRepository.save(review);
            return true;
        } else return false;
    }


    @Override
    public boolean deleteReviewByCompanyIdReviewId(Long reviewId) {

        Review review = reviewRepository.findById(reviewId).orElse(null);
        if (review != null) {
            reviewRepository.delete(review);
            return true;
        } else {
            return false;
        }
    }
}
