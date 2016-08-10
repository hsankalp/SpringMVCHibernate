package io.hsankalp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.hsankalp.entity.Review;
import io.hsankalp.exception.EntityExistsException;
import io.hsankalp.service.ReviewService;

@RestController
@RequestMapping(value="/reviews")
public class ReviewController {
	
	@Autowired
	ReviewService service;
	
	@RequestMapping(value="/review/{title}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Review> findByMovieTitle(@PathVariable("title") String title){
		return service.findByMovieTitle(title);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Review create(@RequestBody Review review) throws EntityExistsException {
		return service.create(review);
	}
	
}
