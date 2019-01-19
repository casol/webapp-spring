package com.krisswebapp.todo;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.krisswebapp.login.LoginService;


@Controller
@SessionAttributes("name")
public class TodoController {
	
	// dependency injection 
	// Set the Service - Auto Wiring 
	@Autowired
	private TodoService service;
		 
	@RequestMapping(value="/list-todos", method=RequestMethod.GET)
	public String listTodos(ModelMap model) {
		
		model.addAttribute("todos", service.retrieveTodos("Kriss"));
		return "list-todos";
	}
	
	
	@RequestMapping(value="/add-todo", method=RequestMethod.GET)
	public String showTodosPage(ModelMap model) {
		model.addAttribute("todo", new Todo(0, "Kriss", "", new Date(), false));
		return "todo";
	}
	
	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

		if (result.hasErrors())
			return "todo";

		service.addTodo("Kriss", todo.getDesc(), new Date(),
				false);
		model.clear();// to prevent request parameter "name" to be passed
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
