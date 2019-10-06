package edu.cvtc.agile.dao;

import java.util.List;

import edu.cvtc.agile.dao.impl.ShowDaoException;
import edu.cvtc.agile.model.Show;

public interface ShowDao {
	
	List<Show> retrieveShows() throws ShowDaoException;
	
}