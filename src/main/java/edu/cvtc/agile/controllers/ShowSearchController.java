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
import edu.cvtc.agile.dao.ShowDao;
import edu.cvtc.agile.dao.impl.ShowDaoException;
import edu.cvtc.agile.dao.impl.ShowDaoImpl;
import edu.cvtc.agile.model.Show;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/ShowSearch")
public class ShowSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String target = null;
		
		try {
			
			final ShowDao showDao = new ShowDaoImpl();
			final List<Show> shows = showDao.retrieveShows();
			
			List<Show> filteredShows = null;
			List<Show> filteredShowsTitles = null;
			List<Show> filteredShowsGenres = null;
			
			final String search = request.getParameter("shows");
			
			if (search != null) {
				
				filteredShowsTitles = shows
									   .stream()
									   .filter((show) -> show.getTitle().toLowerCase().contains(search.toLowerCase().trim()))
									   .collect(Collectors.toList());
				
				filteredShowsGenres = shows
									   .stream()
									   .filter((show) -> show.getGenres().toLowerCase().contains(search.toLowerCase().trim()))
									   .collect(Collectors.toList());
				
				filteredShowsTitles.addAll(filteredShowsGenres);
				
				filteredShows = filteredShowsTitles
									.stream()
									.distinct()
									.collect(Collectors.toList());
				
				Collections.sort(filteredShows, new UserRatingComparator());
				Collections.reverse(filteredShows); // Sort from best to worst
				
			}
			
			request.setAttribute("shows", filteredShows);
			target = "shows.jsp";
			
		} catch (ShowDaoException e) {
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