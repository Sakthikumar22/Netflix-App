package com.chainsys.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.amazon.MovieDAO;
import com.chainsys.model.RegisterClass;
import com.chainsys.model.Validation;

/**
 * Servlet implementation class HelpController
 */
@WebServlet("/HelpController")
public class HelpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelpController() {
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
		// TODO Auto-generated method stub
		
		String email = request.getParameter("email");
		RegisterClass register;
		
		try {
			try {
				Validation.sendSimpleMail();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			register=MovieDAO.forget(email);
			System.out.println(register.getUsername());
			request.setAttribute("username", register.getUsername());
			request.setAttribute("password", register.getPassword());
			RequestDispatcher rd = request.getRequestDispatcher("Help.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
