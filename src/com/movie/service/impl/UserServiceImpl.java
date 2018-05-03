package com.movie.service.impl;

import java.util.List;

import com.movie.dao.IUserDAO;
import com.movie.pojo.User;
import com.movie.service.IUserService;

public class UserServiceImpl implements IUserService {
	private IUserDAO userDAO;

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public User getUser(String id) {
		// TODO Auto-generated method stub
		return userDAO.ger(id);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userDAO.list();
	}

	@Override
	public void addUser(User user) {
		userDAO.add(user);

	}

	@Override
	public boolean delUser(String id) {
		// TODO Auto-generated method stub
		userDAO.delete(id);
		return true;
	}

	@Override
	public boolean updateUser(User user) {
		userDAO.update(user);
		return true;
	}

	@Override
	public User login(String userName, String userPassword) {
		User user = new User();
		try {
			user = userDAO.login(userName, userPassword);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public List<User> findByName(String userName) {
		return userDAO.findByName(userName);
	}

}
