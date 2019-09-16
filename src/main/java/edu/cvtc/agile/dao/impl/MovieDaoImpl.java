package edu.cvtc.agile.dao.impl;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import edu.cvtc.agile.dao.MovieDao;
import edu.cvtc.agile.model.Movie;
import edu.cvtc.agile.util.DBUtility;
import edu.cvtc.agile.util.WorkbookUtility;

public class MovieDaoImpl implements MovieDao {

	private static final String DROP_TABLE_MOVIE = "drop table if exists movie";
	private static final String CREATE_TABLE_MOVIE = "create table movie (id integer primary key autoincrement, title text, director text, length integer, genre text)";
	private static final String SELECT_ALL_FROM_MOVIE = "select * from movie";
	
	@Override
	public void populate(final String filePath) throws MovieDaoException {
		
		Connection connection = null;
		Statement statement = null;
		
		try {
			
			connection = DBUtility.createConnection();
			statement = connection.createStatement();
			
			statement.setQueryTimeout(DBUtility.TIMEOUT);
			
			statement.executeUpdate(DROP_TABLE_MOVIE);
			statement.executeUpdate(CREATE_TABLE_MOVIE);
			
			// Populate movie table using WorkbookUtility
			final File inputFile = new File(filePath);
			final List<Movie> movies = WorkbookUtility.retrieveMoviesFromWorkbook(inputFile);
			
			for (final Movie movie : movies) {
				final String insertValues = "insert into movie (title, director, length, genre) "
						+ "values ('" + movie.getTitle() + "', "
								+ "'" + movie.getDirector() + "', "
									  + movie.getLengthInMinutes() + ", "
							    + "'" + movie.getGenre() + "');";
				System.out.println(insertValues); // NOTES: Log a message to the Console so we can see the data being added to the database
			
				statement.executeUpdate(insertValues);
			}
			
		} catch (ClassNotFoundException | SQLException | InvalidFormatException | IOException e) {
			e.printStackTrace();
			throw new MovieDaoException("Error: Unable to populate the database.");
		} finally {
			DBUtility.closeConnections(connection, statement);
		}
		
	}

	@Override
	public List<Movie> retrieveMovies() throws MovieDaoException {
		
		final List<Movie> movies = new ArrayList<>();
		
		Connection connection = null;
		Statement statement = null;
		
		try {
			
			connection = DBUtility.createConnection();
			statement = connection.createStatement();
			
			statement.setQueryTimeout(DBUtility.TIMEOUT);
			
			final ResultSet resultSet =  statement.executeQuery(SELECT_ALL_FROM_MOVIE);
			
			while (resultSet.next()) {
				
				final String title = resultSet.getString("title");
				final String director = resultSet.getString("director");
				final int length = resultSet.getInt("length");
				final String genre = resultSet.getString("genre");
				
				movies.add(new Movie(title, director, length, genre));
				
			}
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			throw new MovieDaoException("Error: Unable to retrieve movies.");
		} finally {
			DBUtility.closeConnections(connection, statement);
		}
		
		return movies;
	}

	@Override
	public void insertMovie(final Movie movie) throws MovieDaoException {
		
		Connection connection = null;
		PreparedStatement insertStatement = null;
		
		try {
			
			connection = DBUtility.createConnection();
			
			final String sqlStatement = "insert into movie (title, director, length, genre) values (?, ?, ?, ?)";
			insertStatement = connection.prepareStatement(sqlStatement);
			
			insertStatement.setString(1, movie.getTitle());
			insertStatement.setString(2, movie.getDirector());
			insertStatement.setInt(3, movie.getLengthInMinutes());
			insertStatement.setString(4, movie.getGenre());
			
			insertStatement.setQueryTimeout(DBUtility.TIMEOUT);
			
			insertStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new MovieDaoException("Error: Unable to add this movie to the database.");
		} finally {
			DBUtility.closeConnections(connection, insertStatement);
		}

	}

}
