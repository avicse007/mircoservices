package com.avinash.resource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.avinash.models.CatalogItem;
import com.avinash.models.Movie;
import com.avinash.models.Rating;
import com.avinash.models.UserRating;
import com.avinash.service.MovieInfo;
import com.avinash.service.UserRatingInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private MovieInfo movieInfo;
	
	@Autowired
	private UserRatingInfo userRatingOnfo;
	
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		UserRating userRatings = userRatingOnfo.getUserRating(userId);
		return userRatings.getUserRating().stream().map(rating->{
			 return movieInfo.getCatalogItem(rating);
		}).collect(Collectors.toList());
	}
	

	
	
	
	public List<CatalogItem> getFallbackCatalog(@PathVariable("userId") String userId){
		return Arrays.asList(new CatalogItem("No Movie", "No description", 0));
	}
	
}
