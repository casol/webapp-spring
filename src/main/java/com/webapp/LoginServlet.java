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
		// Get parameter from the URL e.g http://mysite.com/?name=TEST
		String name = request.getParameter("name");
		// Set the attribute to be available for jsp  
		request.setAttribute("name", name);
		
		// Method getRequestDispatcher() convert jsp file to Servlet (jsp is like template in django)
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);

	}

}