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
				
				final String title = resultSet.getString("Name");
				final Date releaseDate = resultSet.getDate("ReleaseDate");
				final Date streamDate = resultSet.getDate("StreamDate");
				final String contentRating = "TEMP";//resultSet.getString("ContentRating");
				final int season = resultSet.getInt("Season");
				final int episodes = resultSet.getInt("Episodes");
				final String description = resultSet.getString("Description");
				final float userRating = 0.0f;//resultSet.getFloat("UserRating");
				final String coverImgUrl = resultSet.getString("CoverImgUrl");
				final String trailerUrl = "https://www.youtube.com/watch?v=" + "TEMP";//resultSet.getString("TrailerKey");
				final String platform = "TEMP";//resultSet.getString("Platform");
				
				shows.add(new Show(title, releaseDate, streamDate, contentRating, season, episodes, description, userRating, coverImgUrl, trailerUrl, platform));
				
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
