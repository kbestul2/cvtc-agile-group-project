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
	
	private static final String SELECT_ALL_FROM_MOVIES 	= "SELECT MovieID, "
															+ "Title, "
															+ "ReleaseDate, "
															+ "StreamDate, "
															+ "Length, "
															+ "Description, "
															+ "UserRating, "
															+ "CoverImgUrl, "
															+ "TrailerKey, "
															+ "Platform, "
															+ "r.Rating AS ContentRating, "
															+ "GROUP_CONCAT(g.Name SEPARATOR ', ') AS Genre "
														+ "FROM movies m "
															+ "INNER JOIN ratings r USING (RatingID) "
															+ "INNER JOIN movie_genre mg USING (MovieID) "
															+ "INNER JOIN genres g USING (GenreID) "
														+ "GROUP BY m.MovieID";
	
	private static final String[] INSERT_SIZE = {"w92", "w154", "w185", "w342", "w500", "w780", "original"};
			
	@Override
	public List<Movie> retrieveMovies() throws MovieDaoException {
		
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
				final String description = resultSet.getString("Description");
				final String genres = resultSet.getString("Genre");
				final String contentRating = resultSet.getString("ContentRating");
				final float userRating = resultSet.getFloat("UserRating");
				final int length = resultSet.getInt("Length");
				
				String coverImgUrlString;
				if (resultSet.getString("CoverImgUrl").equals("-1")) {
					coverImgUrlString = "assets/images/ImageUnavailable.png";
				} else {
					coverImgUrlString = "https://image.tmdb.org/t/p/" + INSERT_SIZE[4] + resultSet.getString("CoverImgUrl");
				}
				final String coverImgUrl = coverImgUrlString;
				
				String trailerUrlString;
				if (resultSet.getString("TrailerKey").equals("-1")) {
					trailerUrlString = "error404.jsp";
				} else {
					trailerUrlString = "https://www.youtube.com/watch?v=" + resultSet.getString("TrailerKey");
				}
				final String trailerUrl = trailerUrlString;
				
				final String platform = resultSet.getString("Platform");
				
				movies.add(new Movie(title, releaseDate, streamDate, description, genres, 
						contentRating, userRating, length, coverImgUrl, trailerUrl, platform));
			
			}
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			throw new MovieDaoException("Error: Unable to retrieve movies from database.");
		} finally {
			DBUtility.closeConnections(connection, statement);
		}
		
		return movies;
	}

}
