package edu.cvtc.agile.model;

import java.sql.Date;

public abstract class Content {
	
	public abstract String getTitle();
	
	public abstract Date getReleaseDate();

	public abstract Date getStreamDate();
	
	//public abstract float getRating();
	
	public abstract String toString();
	
}