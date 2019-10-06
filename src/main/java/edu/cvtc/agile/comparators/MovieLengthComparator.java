package edu.cvtc.agile.comparators;

import java.util.Comparator;

import edu.cvtc.agile.model.Movie;

public class MovieLengthComparator implements Comparator<Movie> {

	@Override
	public int compare(Movie o1, Movie o2) {
		return Float.compare(o1.getLength(), o2.getLength());
	}

}