package edu.cvtc.agile.dao;

import java.util.List;

import edu.cvtc.agile.dao.impl.MovieDaoException;
import edu.cvtc.agile.model.Movie;

public interface MovieDao {

	void populate(String filePath) throws MovieDaoException;
	
	List<Movie> retrieveMovies() throws MovieDaoException;
	
	void insertMovie(Movie movie) throws MovieDaoException;
	
}
