package io.hsankalp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.hsankalp.dao.ReviewRepository;
import io.hsankalp.entity.Review;
import io.hsankalp.exception.EntityExistsException;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService{

	@Autowired
	private ReviewRepository repo;

	@Override
	public List<Review> findByMovieTitle(String title){
		return repo.findByMovieTitle(title);
	}

	@Override
	public Review create(Review review) throws EntityExistsException {
		Review existing = repo.findIfExists(review.getTitle(), review.getEmail());
		if (existing != null) {
			throw new EntityExistsException();
		}
		return repo.create(review);
	
	}

}
