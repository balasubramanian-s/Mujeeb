package com.demo.abc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.abc.dao.UserDAO;
import com.demo.abc.model.User;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private UserDAO users;
	
	@GetMapping(value = "/get")
	public List<User> getall(){
		
		return users.get();
		
	}
	@GetMapping(value = "/get/{id}")
	public User getbyId(@PathVariable Long id) {
		return users.getbyId(id);
	}
	
	@PostMapping(value = "/save")
	public void save(@RequestBody User user) {
		users.saveUser(user);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable Long id) {
		users.deleteUser(id);
	}
	
}

