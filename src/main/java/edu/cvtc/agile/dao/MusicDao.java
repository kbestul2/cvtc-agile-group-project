package edu.cvtc.agile.dao;

import java.util.List;

import edu.cvtc.agile.dao.impl.ContentDaoException;
import edu.cvtc.agile.model.Music;

public interface MusicDao {
	
	List<Music> retrieveMusic() throws ContentDaoException;
	
}
