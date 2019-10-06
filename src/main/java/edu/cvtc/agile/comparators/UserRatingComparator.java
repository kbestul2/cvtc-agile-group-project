package edu.cvtc.agile.comparators;

import java.util.Comparator;

import edu.cvtc.agile.model.Content;

public class UserRatingComparator implements Comparator<Content> {

	@Override
	public int compare(Content o1, Content o2) {
		return Float.compare(o1.getUserRating(), o2.getUserRating());
	}
	
}