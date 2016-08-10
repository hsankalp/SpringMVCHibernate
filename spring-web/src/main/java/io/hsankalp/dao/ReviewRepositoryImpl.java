package io.hsankalp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.hsankalp.entity.Review;

@Repository
public class ReviewRepositoryImpl implements ReviewRepository{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Review> findByMovieTitle(String title) {
		TypedQuery<Review> query = em.createQuery("SELECT r FROM Review r WHERE r.title = :pTitle", Review.class);
		query.setParameter("pTitle", title);
		return query.getResultList();
		
	}

	@Override
	public Review findIfExists(String title, String email) {
		TypedQuery<Review> query = em.createQuery("SELECT r FROM Review r WHERE r.title = :pTitle and r.email= :pEmail", Review.class);
		query.setParameter("pEmail", email);
		query.setParameter("pTitle", title);
		List<Review> review = query.getResultList();
		if (review != null && review.size() == 1) {
			return review.get(0);
		} else {
			return null;
		}
	}

	@Override
	public Review create(Review review) {
		em.persist(review);
		return review;
	}

}
