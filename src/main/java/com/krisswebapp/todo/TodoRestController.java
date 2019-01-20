package com.krisswebapp.todo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoRestController {
	@Autowired
	TodoService service;
	
	@RequestMapping(path="/todos")
	public java.util.List<Todo> retrieveAllTodos(){
		return service.retrieveTodos("Kriss");
		
	}
	
	@RequestMapping(path="/todos/{id}")
	public Todo retrieveTodos(@PathVariable int id){
		return service.retrieveTodo(id);
		
	}
	
	
}
