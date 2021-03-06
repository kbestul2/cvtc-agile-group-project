package edu.cvtc.agile.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.cvtc.agile.dao.MusicDao;
import edu.cvtc.agile.model.Music;
import edu.cvtc.agile.util.DBUtility;

public class MusicDaoImpl implements MusicDao {
	
	private static final String SELECT_ALL_FROM_MUSIC 	= "SELECT AlbumID, "
															+ "Album, "
															+ "Artist, "
															+ "ReleaseDate, "
															+ "RecordLabel, "
															+ "Explicit, "
															+ "Rating, "
															+ "CoverImgUrl, "
															+ "GROUP_CONCAT(g.Name SEPARATOR ', ') AS Genre "
														+ "FROM music m "
															+ "INNER JOIN album_genre AS ag USING (AlbumID) "
															+ "INNER JOIN genres AS g USING (GenreID)"
														+ "GROUP BY m.AlbumID";
	
	@Override
	public List<Music> retrieveMusic() throws MusicDaoException {
		
		final List<Music> music = new ArrayList<>();
		
		Connection connection = null;
		Statement statement = null;
		
		try {
			
			connection = DBUtility.createConnection();
			statement = connection.createStatement();
			
			statement.setQueryTimeout(DBUtility.TIMEOUT);
			
			final ResultSet resultSet =  statement.executeQuery(SELECT_ALL_FROM_MUSIC);
			
			while (resultSet.next()) {
				
				final String title = resultSet.getString("Album");
				final String artist = resultSet.getString("Artist");
				final Date releaseDate = resultSet.getDate("ReleaseDate");
				final Date streamDate = resultSet.getDate("ReleaseDate");
				final String genres = resultSet.getString("Genre");
				final String contentWarning = (resultSet.getInt("Explicit") == 1) ? "Explicit" : "None";
				final float userRating = resultSet.getFloat("Rating");
				final String recordLabel = resultSet.getString("RecordLabel");
				
				String coverImgUrlString;
				if (resultSet.getString("CoverImgUrl").equals("-1") || resultSet.getString("CoverImgUrl").isEmpty()) {
					coverImgUrlString = "assets/images/ImageUnavailable.png";
				} else {
					coverImgUrlString = resultSet.getString("CoverImgUrl");
				}
				final String coverImgUrl = coverImgUrlString;
				
				music.add(new Music(title, artist, releaseDate, streamDate, genres, 
						contentWarning, userRating, recordLabel, coverImgUrl));
				
			}
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			throw new MusicDaoException("Error: Unable to retrieve music from database.");
		} finally {
			DBUtility.closeConnections(connection, statement);
		}
		
		return music;
	}

}
