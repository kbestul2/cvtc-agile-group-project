package edu.cvtc.agile.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.cvtc.agile.dao.ContentDao;
import edu.cvtc.agile.model.Content;
import edu.cvtc.agile.model.Music;
import edu.cvtc.agile.util.DBUtility;

public class MusicDaoImpl implements ContentDao {
	
	private static final String SELECT_ALL_FROM_MUSIC = "select * from music";

	@Override
	public List<Content> retrieveContent() throws ContentDaoException {
		
		final List<Content> music = new ArrayList<>();
		
		Connection connection = null;
		Statement statement = null;
		
		try {
			
			connection = DBUtility.createConnection();
			statement = connection.createStatement();
			
			statement.setQueryTimeout(DBUtility.TIMEOUT);
			
			final ResultSet resultSet =  statement.executeQuery(SELECT_ALL_FROM_MUSIC);
			
			while (resultSet.next()) {
				
				final String name = resultSet.getString("Name");
				final String releaseDate = resultSet.getString("ReleaseDate");
				final String streamDate = resultSet.getString("StreamDate");
				final String artist = resultSet.getString("Artist");
				final String album = resultSet.getString("Album");
				final int lengthInMinutes = resultSet.getInt("LengthInMinutes");
				final int lengthInSeconds = resultSet.getInt("LengthInSeconds");
				final float rating = resultSet.getFloat("Rating");
				final String coverImgUrl = resultSet.getString("CoverImgUrl");
				
				music.add(new Music(name, releaseDate, streamDate, artist, album, lengthInMinutes, lengthInSeconds, rating, coverImgUrl));
				
			}
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			throw new ContentDaoException("Error: Unable to retrieve music from database.");
		} finally {
			DBUtility.closeConnections(connection, statement);
		}
		
		return music;
	}

}
