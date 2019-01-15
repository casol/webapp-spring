package com.krisswebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.krisswebapp.login.LoginService;


@Controller
public class LoginController {
	
	LoginService service = new LoginService();
		
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String showLoginPage() {
		// name of the jsp file - InternalResourceViewResolver looks for the name in the todo-servlet.xml where the bean is define
		return "login";
	}
		
	@RequestMapping(value="/login", method=RequestMethod.POST)
	// Get parameters with @RequestParam and make available for the view by ModelMap 
	// Model -> passing between controller and view 
	public String handleLoginRequest(@RequestParam String name, ModelMap model, @RequestParam String password) {
		
		if(!service.validateUser(name, password)) {		
			model.put("errorMessage", "Invalid username or password");
			return "login";		
		} 
		model.put("name", name);
		model.put("password", password);
		return "welcome";
	}
	

}
