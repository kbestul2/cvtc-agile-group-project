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
import edu.cvtc.agile.dao.impl.MusicDaoImpl;
import edu.cvtc.agile.model.Content;
import edu.cvtc.agile.model.Music;

/**
 * Servlet implementation class MusicController
 */
@WebServlet("/Music")
public class MusicController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String target = null;
		
		try {
			
			final ContentDao musicDao = new MusicDaoImpl();
			final List<Content> music = musicDao.retrieveContent();
			
//			final String sortType = request.getParameter("sortType");
//			
//			if (sortType != null) {
//				sortMusic(music, sortType);
//			}
			
			request.setAttribute("music", music);
			
			target = "music.jsp";
			
		} catch (ContentDaoException e) {
			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
			target = "error.jsp";
		}
		
		request.getRequestDispatcher(target).forward(request, response);
	}

//	private void sortMusic(final List<Music> music, final String sortType) {
//		switch(sortType) {
//		case "name":
//			Collections.sort(music, new NameComparator());
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
