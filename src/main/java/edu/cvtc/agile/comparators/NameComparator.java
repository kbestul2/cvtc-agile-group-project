package edu.cvtc.agile.comparators;

import java.util.Comparator;

import edu.cvtc.agile.model.Movie;

public class NameComparator implements Comparator<Movie> {

	@Override
	public int compare(Movie movie1, Movie movie2) {
		return movie1.getName().compareTo(movie2.getName());
	}

}