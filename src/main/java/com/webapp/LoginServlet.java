package com.webapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns="/login.do")
public class LoginServlet extends HttpServlet{
	// Method doGet() from HttpServlet class doc
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
     throws ServletException, IOException {
		// Method getRequestDispatcher() convert jsp file to Servlet 
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);

	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		     throws ServletException, IOException {
		
				request.setAttribute("name", request.getParameter("name"));
				// Method getRequestDispatcher() convert jsp file to Servlet 
				request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);

			}
	

}
