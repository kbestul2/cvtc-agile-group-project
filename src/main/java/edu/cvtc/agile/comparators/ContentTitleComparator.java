package edu.cvtc.agile.comparators;

import java.util.Comparator;

import edu.cvtc.agile.model.Content;

public class ContentTitleComparator implements Comparator<Content> {

	@Override
	public int compare(Content o1, Content o2) {
		return o1.getTitle().compareTo(o2.getTitle());
	}

}