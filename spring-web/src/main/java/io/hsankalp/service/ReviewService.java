package io.hsankalp.service;

import java.util.List;

import io.hsankalp.entity.Review;
import io.hsankalp.exception.EntityExistsException;

public interface ReviewService {

	public List<Review> findByMovieTitle(String title);
	public Review create(Review review) throws EntityExistsException;

}
