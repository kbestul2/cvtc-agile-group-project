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
import edu.cvtc.agile.model.Movie;

/**
 * Servlet implementation class MoviesController
 */
@WebServlet({"/Home", ""})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String target = null;
		
		target = "index.jsp";
		
//		try {
//			
//			put code for "featured" content here
//		
//			target = "index.jsp";
//			
//		} catch (ContentDaoException e) {
//			e.printStackTrace();
//			request.setAttribute("message", e.getMessage());
//			target = "error.jsp";
//		}
//		
		request.getRequestDispatcher(target).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
