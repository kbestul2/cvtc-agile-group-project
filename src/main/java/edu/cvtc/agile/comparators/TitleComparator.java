package edu.cvtc.agile.comparators;

import java.util.Comparator;

import edu.cvtc.agile.model.Movie;

public class TitleComparator implements Comparator<Movie> {

	@Override
	public int compare(Movie movie1, Movie movie2) {
		return movie1.getTitle().compareTo(movie2.getTitle());
	}

}
