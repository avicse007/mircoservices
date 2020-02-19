package com.avinash.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.avinash.models.CatalogItem;
import com.avinash.models.Movie;
import com.avinash.models.Rating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class MovieInfo {
	
	@Autowired
	private RestTemplate restTemplate;

	//These hystrix command will help us to implement the bulkhead pattern
	@HystrixCommand(fallbackMethod="getFallbackCatalogItem",
			threadPoolKey="movie-info-pool",
			threadPoolProperties= {
					@HystrixProperty(name="coreSize",value="20"),
					@HystrixProperty(name="maxAueueSize",value="10")
			}
			)
	public CatalogItem getCatalogItem(Rating rating) {
		Movie movie = restTemplate.getForObject("http://movie-info-service/movie/"+rating.getMovieId(),Movie.class);
		 return new CatalogItem(movie.getName(),movie.getDescription(), rating.getRating());
	}
	
	private CatalogItem getFallbackCatalogItem(Rating rating) {
		return new CatalogItem("Movie Name Not Found","Movie Description not found",rating.getRating());
	}

}
