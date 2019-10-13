package edu.cvtc.agile.controllers;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.cvtc.agile.comparators.UserRatingComparator;
import edu.cvtc.agile.dao.MovieDao;
import edu.cvtc.agile.dao.impl.MovieDaoException;
import edu.cvtc.agile.dao.impl.MovieDaoImpl;
import edu.cvtc.agile.model.Movie;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/MovieSearch")
public class MovieSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String target = null;
		
		try {
			
			final MovieDao movieDao = new MovieDaoImpl();
			final List<Movie> movies = movieDao.retrieveMovies();
			
			List<Movie> filteredMovies = null;
			List<Movie> filteredMovieTitles = null;
			List<Movie> filteredMovieGenres = null;
			
			final String search = request.getParameter("movies");
			
			if (search != null) {
				
				filteredMovieTitles = movies
									   .stream()
									   .filter((movie) -> movie.getTitle().toLowerCase().contains(search.toLowerCase().trim()))
									   .collect(Collectors.toList());
				
				filteredMovieGenres = movies
									   .stream()
									   .filter((movie) -> movie.getGenres().toLowerCase().contains(search.toLowerCase().trim()))
									   .collect(Collectors.toList());
				
				filteredMovieTitles.addAll(filteredMovieGenres);
				
				filteredMovies = filteredMovieTitles
									.stream()
									.distinct()
									.collect(Collectors.toList());
				
				Collections.sort(filteredMovies, new UserRatingComparator());
				
			}
			
			request.setAttribute("movies", filteredMovies);
			target = "movies.jsp";
			
		} catch (MovieDaoException e) {
			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
			target = "error.jsp";
		}
		
		request.getRequestDispatcher(target).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}