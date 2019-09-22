//package edu.cvtc.agile.controllers;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import edu.cvtc.agile.dao.ContentDao;
//import edu.cvtc.agile.dao.impl.ContentDaoException;
//import edu.cvtc.agile.dao.impl.MovieDaoImpl;
//import edu.cvtc.agile.model.Movie;
//
///**
// * Servlet implementation class SearchController
// */
//@WebServlet("/Search")
//public class SearchController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		String target = null;
//		
//		try {
//			
//			final ContentDao movieDao = new MovieDaoImpl();
//			final List<Movie> movies = movieDao.retrieveContent();
//			
//			List<Movie> filteredMovies = null;
//			
//			String titleSearchButton = request.getParameter("nameSearch");
//			
//			if (titleSearchButton != null) {
//				
//				final String title = request.getParameter("name");
//				
//				filteredMovies = movies
//									   .stream()
//									   .filter((movie) -> movie.getName().equalsIgnoreCase(title))
//									   .collect(Collectors.toList());
//				
//			}
//			
//			request.setAttribute("movies", filteredMovies);
//			
//			target = "search.jsp";
//			
//		} catch (ContentDaoException e) {
//			e.printStackTrace();
//			request.setAttribute("message", e.getMessage());
//			target = "error.jsp";
//		}
//		
//		request.getRequestDispatcher(target).forward(request, response);
//		
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}
//
//}
