package com.avinash.model;

public class Movie {

	private String movieId;
	private String name;
	private String description;
	
	
	
	public Movie(String movieId, String name,String desc) {
		super();
		this.movieId = movieId;
		this.name = name;
		this.description=desc;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	 
	 
}
