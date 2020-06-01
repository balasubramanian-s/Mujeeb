package com.demo.abc.dao;

import java.util.List;

import com.demo.abc.model.User;

public interface UserDAO {

	public List<User> get();
	
	public User getbyId(Long id);
	
	public void saveUser(User user);
	
	public void deleteUser(Long id);
}
