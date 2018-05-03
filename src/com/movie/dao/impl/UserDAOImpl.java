package com.movie.dao.impl;

import java.util.List;

import org.hibernate.Query;

import com.movie.dao.IUserDAO;
import com.movie.pojo.User;


public class UserDAOImpl extends BaseDAOImpl<User> implements IUserDAO { 
	public User login(String userName,String userPassword) throws Exception{
		Query q =getSession().createQuery("from User as u where u.userName=:abc and u.userPassword=:password");
		q.setString("abc", userName);
		q.setString("password", userPassword);
		return(User) q.uniqueResult();
	}

	@Override
	public List<User> findByName(String userName) {
		String hql = "from User where userName= '"+userName+"' ";
		Query query = getSession().createQuery(hql);
		List<User>list = query.list();
		System.out.println("list:"+list);
		return list;
	}
}
