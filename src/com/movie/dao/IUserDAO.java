package com.movie.dao;
import java.util.List;

import com.movie.pojo.User;
public interface IUserDAO extends IBaseDAO<User> {
	public User login(String userName,String userPassword) throws Exception;
	public List<User> findByName(String userName);
}
