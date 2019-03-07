package com.chainsys.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.amazon.MovieDAO;
import com.chainsys.model.RegisterClass;



/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
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
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();

		if(email.equalsIgnoreCase("admin@gmail.com")&& password.equalsIgnoreCase("admin"))
		{
			out.println("success");
			RequestDispatcher rd = request.getRequestDispatcher("Home.html");
			rd.forward(request, response);
		}
		else
		{
			try {
				RegisterClass registerClass=MovieDAO.search(email,password);
				out.print(registerClass.getId());
				if(registerClass.getId()>0){
					RequestDispatcher rd = request.getRequestDispatcher("Search.html");
					rd.forward(request, response);
				}else{
					RequestDispatcher rd = request.getRequestDispatcher("Back.html");
					rd.forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}

