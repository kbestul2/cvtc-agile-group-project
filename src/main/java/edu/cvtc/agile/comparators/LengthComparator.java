package edu.cvtc.agile.comparators;

import java.util.Comparator;

import edu.cvtc.agile.model.Movie;

public class LengthComparator implements Comparator<Movie> {

	@Override
	public int compare(Movie movie1, Movie movie2) {
		return movie1.getLengthInMinutes().compareTo(movie2.getLengthInMinutes());
	}

}
