package edu.cvtc.agile.controllers;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.cvtc.agile.comparators.MovieLengthComparator;
import edu.cvtc.agile.comparators.ReleaseDateComparator;
import edu.cvtc.agile.comparators.StreamDateComparator;
import edu.cvtc.agile.comparators.TitleComparator;
import edu.cvtc.agile.comparators.UserRatingComparator;
import edu.cvtc.agile.dao.MusicDao;
import edu.cvtc.agile.dao.impl.MusicDaoException;
import edu.cvtc.agile.dao.impl.MusicDaoImpl;
import edu.cvtc.agile.model.Music;

/**
 * Servlet implementation class MusicController
 */
@SuppressWarnings("unused")
@WebServlet("/Music")
public class MusicController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String target = null;
		
		try {
			
			final MusicDao musicDao = new MusicDaoImpl();
			final List<Music> music = musicDao.retrieveMusic();
			
			final String sortType = request.getParameter("sortType");
			
			if (sortType != null) {
				sortMusic(music, sortType);
			}
			
			request.setAttribute("music", music);
			
			target = "music.jsp";
			
		} catch (MusicDaoException e) {
			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
			target = "error.jsp";
		}
		
		request.getRequestDispatcher(target).forward(request, response);
	}

	private void sortMusic(final List<Music> music, final String sortType) {
		
		switch(sortType) {
		case "streamDate":
			Collections.sort(music, new StreamDateComparator());
			break;
		case "releaseDate":
			Collections.sort(music, new ReleaseDateComparator());
			break;
		case "userRating":
			Collections.sort(music, new UserRatingComparator());
			Collections.reverse(music); // Sort from best to worst
			break;
		case "title":
			Collections.sort(music, new TitleComparator());
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
