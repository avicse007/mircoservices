package com.avinash.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avinash.models.Rating;
import com.avinash.models.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResource {

	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {
		
		return new Rating(movieId,4);
	}
	
	
	@RequestMapping("/user/{userId}")
	public UserRating getRatingForUser(@PathVariable("userId") String userId) {
		   UserRating userRating = new UserRating();
		   userRating.setUserRating( Arrays.asList( new Rating("550", 4), new Rating("5678",5)));
		   
		return userRating;
	}
	
}
