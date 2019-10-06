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

import edu.cvtc.agile.comparators.TitleComparator;
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
			
			final String search = request.getParameter("movies");
			
			if (search != null) {
				
				filteredMovies = movies
									   .stream()
									   .filter((movie) -> movie.getTitle().toLowerCase().contains(search.toLowerCase()))
									   .collect(Collectors.toList());
				
				Collections.sort(filteredMovies, new TitleComparator());
				
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

//import java.util.Collections;
//import java.util.Comparator;
//import java.util.List;
//
//import edu.cvtc.agile.comparators.StreamDateComparator;
//import edu.cvtc.agile.model.Movie;

//	Comparator<Person> comparator = Comparator.comparing(person -> person.name);
//    comparator = comparator.thenComparing(Comparator.comparing(person -> person.age));

//private void sortMovies(final List<Movie> movies, final String sortType) {
//		
//	Comparator<Movie> comparator = Comparator.comparing(Movie::getTitle);
//	
//	switch(sortType) {
//	case "streamDate":
//		Collections.sort(movies, new StreamDateComparator());
//		break;
//	case "releaseDate":
//		break;
//	case "userRating":
//		break;
//	case "length":
//		break;
//	case "title":
//		//Collections.sort(movies, new TitleComparator());
//		comparator = comparator.thenComparing(Movie::getTitle);
//		break;
//	}
//	
//	Collections.sort(movies, comparator);
//	
//}
