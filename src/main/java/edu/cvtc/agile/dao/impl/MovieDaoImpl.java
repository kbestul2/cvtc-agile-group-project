package edu.cvtc.agile.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.cvtc.agile.dao.MovieDao;
import edu.cvtc.agile.model.Movie;
import edu.cvtc.agile.util.DBUtility;

public class MovieDaoImpl implements MovieDao {
	
	private static final String SELECT_ALL_FROM_MOVIES = "SELECT Title, ReleaseDate, StreamDate, ratings.Rating AS ContentRating, Length, Description, UserRating, CoverImgUrl, TrailerKey, Platform FROM StreamLINE.movies INNER JOIN ratings USING (RatingID)";

	@Override
	public List<Movie> retrieveMovies() throws ContentDaoException {
		
		final List<Movie> movies = new ArrayList<>();
		
		Connection connection = null;
		Statement statement = null;
		
		try {
			
			connection = DBUtility.createConnection();
			statement = connection.createStatement();
			
			statement.setQueryTimeout(DBUtility.TIMEOUT);
			
			final ResultSet resultSet =  statement.executeQuery(SELECT_ALL_FROM_MOVIES);
			
			while (resultSet.next()) {
				
				final String title = resultSet.getString("Title");
				final Date releaseDate = resultSet.getDate("ReleaseDate");
				final Date streamDate = resultSet.getDate("StreamDate");
				final String contentRating = resultSet.getString("ContentRating");
				final int length = resultSet.getInt("Length");
				final String description = resultSet.getString("Description");
				final float userRating = resultSet.getFloat("UserRating");
				final String coverImgUrl = resultSet.getString("CoverImgUrl");
				final String trailerUrl = "https://www.youtube.com/watch?v=" + resultSet.getString("TrailerKey");
				final String platform = resultSet.getString("Platform");
				
				if (title != null) {
					movies.add(new Movie(title, releaseDate, streamDate, contentRating, length, description, userRating, coverImgUrl, trailerUrl, platform));
				}
				
			}
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			throw new ContentDaoException("Error: Unable to retrieve movies from database.");
		} finally {
			DBUtility.closeConnections(connection, statement);
		}
		
		return movies;
	}

}
