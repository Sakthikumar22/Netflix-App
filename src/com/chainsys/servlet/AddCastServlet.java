package com.chainsys.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.amazon.MovieDAO;
import com.chainsys.model.Movie;

/**
 * Servlet implementation class AddCastServlet
 */
@WebServlet("/AddCastServlet")
public class AddCastServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCastServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		Movie movie=new Movie();
	
		
		try
		{
			movie.setName(request.getParameter("moviename"));
			movie=MovieDAO.selectMovie(movie.getName());
			movie.setCastname(request.getParameter("castname"));
			movie.setCastrole(request.getParameter("castrole"));
			MovieDAO.addMovieCast(movie.getId(), movie.getCastname(), movie.getCastrole());
		
			
		}
	catch(Exception e)
		{
		
		}
		
		
		
		
		
		
				
			
		
		// TODO Auto-generated method stub
	}

}
