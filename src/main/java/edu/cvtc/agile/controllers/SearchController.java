package edu.cvtc.agile.controllers;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.cvtc.agile.dao.MovieDao;
import edu.cvtc.agile.dao.impl.MovieDaoException;
import edu.cvtc.agile.dao.impl.MovieDaoImpl;
import edu.cvtc.agile.model.Movie;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/Search")
public class SearchController extends HttpServlet {
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
			
			String titleSearchButton = request.getParameter("titleSearch");
			String directorSearchButton = request.getParameter("directorSearch");
			
			if (titleSearchButton != null) {
				
				final String title = request.getParameter("title");
				
				filteredMovies = movies
									   .stream()
									   .filter((movie) -> movie.getTitle().equalsIgnoreCase(title))
									   .collect(Collectors.toList());
				
			} else if (directorSearchButton != null) {
				
				final String director = request.getParameter("director");
				
				filteredMovies = movies
									   .stream()
									   .filter((movie) -> movie.getDirector().equalsIgnoreCase(director))
									   .collect(Collectors.toList());
				
			}
			
			request.setAttribute("movies", filteredMovies);
			
			target = "view-all.jsp";
			
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
