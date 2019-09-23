package edu.cvtc.agile.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.cvtc.agile.dao.ShowDao;
import edu.cvtc.agile.model.Show;
import edu.cvtc.agile.util.DBUtility;

public class ShowDaoImpl implements ShowDao {
	
	private static final String SELECT_ALL_FROM_SHOWS = "select * from shows";

	@Override
	public List<Show> retrieveShows() throws ContentDaoException {
		
		final List<Show> shows = new ArrayList<>();
		
		Connection connection = null;
		Statement statement = null;
		
		try {
			
			connection = DBUtility.createConnection();
			statement = connection.createStatement();
			
			statement.setQueryTimeout(DBUtility.TIMEOUT);
			
			final ResultSet resultSet =  statement.executeQuery(SELECT_ALL_FROM_SHOWS);
			
			while (resultSet.next()) {
				
				final String name = resultSet.getString("Name");
				final Date releaseDate = resultSet.getDate("ReleaseDate");
				final Date streamDate = resultSet.getDate("StreamDate");
				final String ratingText = resultSet.getString("Rating");
				final String description = resultSet.getString("Description");
				final float ratingNumber = resultSet.getFloat("Rating");
				final String coverImgUrl = resultSet.getString("CoverImgUrl");
				final String trailerUrl = resultSet.getString("TrailerUrl");
				
				shows.add(new Show(name, releaseDate, streamDate, ratingText, description, ratingNumber, coverImgUrl, trailerUrl));
				
			}
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			throw new ContentDaoException("Error: Unable to retrieve shows from database.");
		} finally {
			DBUtility.closeConnections(connection, statement);
		}
		
		return shows;
	}

}
