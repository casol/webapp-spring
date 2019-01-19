package com.krisswebapp.todo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class TodoController {
	
	// dependency injection 
	// Set the Service - Auto Wiring 
	@Autowired
	private TodoService service;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}
		 
	@RequestMapping(value="/list-todos", method=RequestMethod.GET)
	public String listTodos(ModelMap model) {
		
		model.addAttribute("todos", service.retrieveTodos(retrieveLoggedUserName()));
		return "list-todos";
	}
	
		
	private String retrieveLoggedUserName() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		
		if (principal instanceof UserDetails)
			return ((UserDetails) principal).getUsername();
		
		return principal.toString();
	}
	
	
	@RequestMapping(value="/add-todo", method=RequestMethod.GET)
	public String showTodosPage(ModelMap model) {
		model.addAttribute("todo", new Todo(0, retrieveLoggedUserName(), "", new Date(), false));
		return "todo";
	}
	
	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

		if (result.hasErrors())
			return "todo";

		service.addTodo(retrieveLoggedUserName(), todo.getDesc(), new Date(),
				false);
		model.clear();// to prevent request parameter "name" to be passed
		return "redirect:/list-todos";
	}
	
	@RequestMapping(value="/update-todo", method=RequestMethod.GET)
	public String updateTdo(ModelMap model, @RequestParam int id) {
		
		Todo todo = service.retrieveTodo(id);
		model.addAttribute("todo", todo);
		//model.clear();
		return "todo";
	}
	
	@RequestMapping(value="/update-todo", method=RequestMethod.POST)
	public String updateTdo(ModelMap model, @Valid Todo todo, BindingResult result) {
		// Update to do

		if (result.hasErrors()) {
			return "todo";
			}
		todo.setUser(retrieveLoggedUserName());
		service.updateTodo(todo);
		return "redirect:/list-todos";
	}
	
	
	
	@RequestMapping(value="/delete-todo", method=RequestMethod.GET)
	public String deleteTodo(ModelMap model, @RequestParam int id) {
		// Delete To Do
		service.deleteTodo(id);
		model.clear();
		return "redirect:list-todos";
	}

}
