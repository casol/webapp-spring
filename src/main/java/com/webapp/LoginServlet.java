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
	// Instance of UserValidationService calass
	private LoginService service = new LoginService();
	
	// Method doGet() from HttpServlet class doc
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
     throws ServletException, IOException {
		// Method getRequestDispatcher() convert jsp file to Servlet 
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);

	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		     throws ServletException, IOException {
		
				String name = request.getParameter("name");
				String password = request.getParameter("password");
				// Use class  method to validate is users and password is correct 
				boolean isValidUser = service.validateUser(name, password);

				// if true setAttriubte and redirect to welcome.jsp
				if(isValidUser) {
					request.setAttribute("name", name);	
					request.setAttribute("password", password);
					// Method getRequestDispatcher() convert jsp file to Servlet 
					request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
				} else {
					request.setAttribute("errorMessage", "Invalid username or password");	
					request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
				}			
			}
}
