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
import edu.cvtc.agile.dao.MusicDao;
import edu.cvtc.agile.dao.impl.MusicDaoException;
import edu.cvtc.agile.dao.impl.MusicDaoImpl;
import edu.cvtc.agile.model.Music;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/MusicSearch")
public class MusicSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String target = null;
		
		try {
			
			final MusicDao musicDao = new MusicDaoImpl();
			final List<Music> music = musicDao.retrieveMusic();
			
			List<Music> filteredMusic = null;
			List<Music> filteredMusicTitles = null;
			List<Music> filteredMusicGenres = null;
			
			final String search = request.getParameter("music");
			
			if (search != null) {
				
				filteredMusicTitles = music
									   .stream()
									   .filter((album) -> album.getTitle().toLowerCase().contains(search.toLowerCase().trim()))
									   .collect(Collectors.toList());
				
				filteredMusicGenres = music
									   .stream()
									   .filter((album) -> album.getGenres().toLowerCase().contains(search.toLowerCase().trim()))
									   .collect(Collectors.toList());
				
				filteredMusicTitles.addAll(filteredMusicGenres);
				
				filteredMusic = filteredMusicTitles
									.stream()
									.distinct()
									.collect(Collectors.toList());
				
				Collections.sort(filteredMusic, new UserRatingComparator());
				Collections.reverse(filteredMusic); // Sort from best to worst
				
			}
			
			request.setAttribute("music", filteredMusic);
			target = "music.jsp";
			
		} catch (MusicDaoException e) {
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