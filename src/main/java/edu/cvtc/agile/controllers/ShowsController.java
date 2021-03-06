package edu.cvtc.agile.controllers;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.cvtc.agile.comparators.ReleaseDateComparator;
import edu.cvtc.agile.comparators.StreamDateComparator;
import edu.cvtc.agile.comparators.TitleComparator;
import edu.cvtc.agile.comparators.UserRatingComparator;
import edu.cvtc.agile.dao.ShowDao;
import edu.cvtc.agile.dao.impl.ShowDaoException;
import edu.cvtc.agile.dao.impl.ShowDaoImpl;
import edu.cvtc.agile.model.Show;

/**
 * Servlet implementation class ShowsController
 */

@WebServlet("/Shows")
public class ShowsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String target = null;
		
		try {
			
			final ShowDao showDao = new ShowDaoImpl();
			final List<Show> shows = showDao.retrieveShows();
			
			final String sortType = request.getParameter("sortType");
			
			if (sortType != null) {
				sortShows(shows, sortType);
			}
			
			request.setAttribute("shows", shows);
			
			target = "shows.jsp";
			
		} catch (ShowDaoException e) {
			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
			target = "error.jsp";
		}
		
		request.getRequestDispatcher(target).forward(request, response);
	}

	private void sortShows(final List<Show> shows, final String sortType) {
		
		switch(sortType) {
		case "streamDate":
			Collections.sort(shows, new StreamDateComparator());
			break;
		case "releaseDate":
			Collections.sort(shows, new ReleaseDateComparator());
			break;
		case "userRating":
			Collections.sort(shows, new UserRatingComparator());
			Collections.reverse(shows); // Sort from best to worst
			break;
		case "title":
			Collections.sort(shows, new TitleComparator());
			break;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
