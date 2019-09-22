package edu.cvtc.agile.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.cvtc.agile.dao.ContentDao;
import edu.cvtc.agile.model.Content;
import edu.cvtc.agile.model.Series;
import edu.cvtc.agile.util.DBUtility;

public class SeriesDaoImpl implements ContentDao {
	
	private static final String SELECT_ALL_FROM_SERIES = "select * from shows";

	@Override
	public List<Content> retrieveContent() throws ContentDaoException {
		
		final List<Content> series = new ArrayList<>();
		
		Connection connection = null;
		Statement statement = null;
		
		try {
			
			connection = DBUtility.createConnection();
			statement = connection.createStatement();
			
			statement.setQueryTimeout(DBUtility.TIMEOUT);
			
			final ResultSet resultSet =  statement.executeQuery(SELECT_ALL_FROM_SERIES);
			
			while (resultSet.next()) {
				
				final String name = resultSet.getString("Name");
				final String releaseDate = resultSet.getString("ReleaseDate");
				final String streamDate = resultSet.getString("StreamDate");
				final String ratingText = resultSet.getString("Rating");
				final int length = resultSet.getInt("Length");
				final String description = resultSet.getString("Description");
				final float ratingNumber = resultSet.getFloat("Rating");
				final String coverImgUrl = resultSet.getString("CoverImgUrl");
				final String trailerUrl = resultSet.getString("TrailerUrl");
				
				series.add(new Series(name, releaseDate, streamDate, ratingText, length, description, ratingNumber, coverImgUrl, trailerUrl));
				
			}
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			throw new ContentDaoException("Error: Unable to retrieve series from database.");
		} finally {
			DBUtility.closeConnections(connection, statement);
		}
		
		return series;
	}

}