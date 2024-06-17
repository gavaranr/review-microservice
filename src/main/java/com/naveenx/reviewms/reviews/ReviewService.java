package com.naveenx.reviewms.reviews;

import java.util.List;


public interface ReviewService {

    Review getCompanyReviewById(Long id);

    boolean createReview(Long companyId, Review review);

    List<Review> getAllReviewsByCompanyId(Long companyId);

    boolean editReviewByCompanyIdReviewId(Long reviewId, Review review);

    boolean deleteReviewByCompanyIdReviewId(Long reviewId);
}
