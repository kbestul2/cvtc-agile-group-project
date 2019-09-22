package edu.cvtc.agile.controllers;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.cvtc.agile.comparators.NameComparator;
import edu.cvtc.agile.dao.ContentDao;
import edu.cvtc.agile.dao.impl.ContentDaoException;
import edu.cvtc.agile.dao.impl.MovieDaoImpl;
import edu.cvtc.agile.model.Content;
import edu.cvtc.agile.model.Movie;

/**
 * Servlet implementation class MoviesController
 */
@WebServlet("/Movies")
public class MoviesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String target = null;
		
		try {
			
			final ContentDao movieDao = new MovieDaoImpl();
			final List<Content> movies = movieDao.retrieveContent();
			
//			final String sortType = request.getParameter("sortType");
//			
//			if (sortType != null) {
//				sortMovies(movies, sortType);
//			}
			
			request.setAttribute("movies", movies);
			
			target = "movies.jsp";
			
		} catch (ContentDaoException e) {
			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
			target = "error.jsp";
		}
		
		request.getRequestDispatcher(target).forward(request, response);
	}

//	private void sortMovies(final List<Movie> movies, final String sortType) {
//		switch(sortType) {
//		case "name":
//			Collections.sort(movies, new NameComparator());
//			break;
//		default:
//			break;
//		}
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
