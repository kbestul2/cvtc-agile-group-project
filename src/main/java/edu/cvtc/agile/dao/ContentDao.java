package edu.cvtc.agile.dao;

import java.util.List;

import edu.cvtc.agile.dao.impl.ContentDaoException;
import edu.cvtc.agile.model.Content;

public interface ContentDao {
	
	List<Content> retrieveContent() throws ContentDaoException;
	
}
