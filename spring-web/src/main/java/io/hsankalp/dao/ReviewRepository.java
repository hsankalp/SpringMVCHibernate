package io.hsankalp.dao;

import java.util.List;

import io.hsankalp.entity.Review;

public interface ReviewRepository {

	public List<Review> findByMovieTitle(String title);

	public Review findIfExists(String title, String email);

	public Review create(Review review);

}
