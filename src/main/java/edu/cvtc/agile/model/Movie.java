package edu.cvtc.agile.model;

import java.io.Serializable;

public class Movie implements Serializable {

	private static final long serialVersionUID = 6763824524233477194L;
	
	private String title;
	private String director;
	private Integer lengthInMinutes;
	private String genre;
	
	public Movie () {
		
	}
	
	public Movie(final String title, final String director, final Integer lengthInMinutes, final String genre) {
		this.title = title;
		this.director = director;
		this.lengthInMinutes = lengthInMinutes;
		this.genre = genre;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public Integer getLengthInMinutes() {
		return lengthInMinutes;
	}

	public void setLengthInMinutes(Integer lengthInMinutes) {
		this.lengthInMinutes = lengthInMinutes;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", director=" + director + ", lengthInMinutes=" + lengthInMinutes + ", genre="
				+ genre + "]";
	}
	
}
