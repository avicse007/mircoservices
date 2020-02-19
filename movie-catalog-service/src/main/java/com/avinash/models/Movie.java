package com.avinash.models;

public class Movie {

	private String movieId;
	private String name;
	private String description;
	
	public Movie() {
		
	}
	
	
	public Movie(String movieId2, String name,String description) {
		super();
		this.movieId = movieId2;
		this.name = name;
		this.description=description;
	}
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getMovieId() {
		return movieId;
	}
	public String getName() {
		return name;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public void setName(String name) {
		this.name = name;
	}
	 
	 
}
