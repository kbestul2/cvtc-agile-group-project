package edu.cvtc.agile.dao;

import java.util.List;

import edu.cvtc.agile.dao.impl.ContentDaoException;
import edu.cvtc.agile.model.Movie;

public interface MovieDao {
	
	List<Movie> retrieveMovies() throws ContentDaoException;
	
}
