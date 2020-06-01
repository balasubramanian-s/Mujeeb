package com.demo.abc.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.abc.model.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private EntityManager entityManager;
	//changes test
	@Override
	public List<User> get() {
		Session curentSession = entityManager.unwrap(Session.class);
		Query<User> query = curentSession.createQuery("from User", User.class);
		List<User> list = query.getResultList();
		return list;
	}

	@Override
	public User getbyId(Long id) {
		Session curentSession = entityManager.unwrap(Session.class);
		User user = curentSession.get(User.class, id);
		return user;
	}

	@Override
	public void saveUser(User user) {
		Session curentSession = entityManager.unwrap(Session.class);
		curentSession.saveOrUpdate(user);
	}

	@Override
	public void deleteUser(Long id) {
		Session curentSession = entityManager.unwrap(Session.class);
		User user = curentSession.get(User.class, id);

		curentSession.delete(user);
		
	}

}
