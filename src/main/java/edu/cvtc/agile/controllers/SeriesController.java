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
import edu.cvtc.agile.dao.impl.SeriesDaoImpl;
import edu.cvtc.agile.model.Content;
import edu.cvtc.agile.model.Series;

/**
 * Servlet implementation class SeriesController
 */
@WebServlet("/Series")
public class SeriesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String target = null;
		
		try {
			
			final ContentDao seriesDao = new SeriesDaoImpl();
			final List<Content> series = seriesDao.retrieveContent();
			
//			final String sortType = request.getParameter("sortType");
//			
//			if (sortType != null) {
//				sortSeries(series, sortType);
//			}
			
			request.setAttribute("series", series);
			
			target = "tv.jsp";
			
		} catch (ContentDaoException e) {
			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
			target = "error.jsp";
		}
		
		request.getRequestDispatcher(target).forward(request, response);
	}

//	private void sortSeries(final List<Series> series, final String sortType) {
//		switch(sortType) {
//		case "name":
//			Collections.sort(series, new NameComparator());
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
