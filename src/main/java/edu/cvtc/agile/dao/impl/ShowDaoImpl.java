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
	
	private static final String SELECT_ALL_FROM_SHOWS 	= "SELECT ShowID, "
															+ "s.Name, "
															+ "ReleaseDate, "
															+ "StreamDate, "
															+ "Season, "
															+ "Episodes, "
															+ "Description, "
															+ "s.Rating AS UserRating, "
															+ "CoverImgUrl, "
															+ "TrailerKey, "
															+ "Platform, "
															+ "r. Rating AS ContentRating, "
															+ "GROUP_CONCAT(g.Name SEPARATOR ', ') AS Genre "
														+ "FROM shows s "
															+ "INNER JOIN ratings r USING (RatingID) "
															+ "INNER JOIN show_genre sg USING (SHOWID) "
															+ "INNER JOIN genres g USING (GenreID) "
														+ "GROUP BY s.ShowID";
	
	private static final String[] INSERT_SIZE = {"w92", "w154", "w185", "w342", "w500", "w780", "original"};

	@Override
	public List<Show> retrieveShows() throws ShowDaoException {
		
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
				final int season = resultSet.getInt("Season");
				final int episodes = resultSet.getInt("Episodes");
				final String description = resultSet.getString("Description");
				final String genres = resultSet.getString("Genre");
				final String contentRating = resultSet.getString("ContentRating");
				final float userRating = resultSet.getFloat("UserRating");
				
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
				
				shows.add(new Show(title, releaseDate, streamDate, season, episodes, description, genres, 
						contentRating, userRating, coverImgUrl, trailerUrl, platform));
				
			}
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			throw new ShowDaoException("Error: Unable to retrieve shows from database.");
		} finally {
			DBUtility.closeConnections(connection, statement);
		}
		
		return shows;
	}

}
