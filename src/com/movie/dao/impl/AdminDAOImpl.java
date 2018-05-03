package com.movie.dao.impl;

import org.hibernate.Query;

import com.movie.dao.AdminDAO;
import com.movie.pojo.Adminse;

public class AdminDAOImpl extends BaseDAOImpl<Adminse> implements AdminDAO {
	@Override
	public Adminse login(String account, String adminPassword) {
		Query query = getSession().createQuery("from Adminse as u where u.account=:adcd and u.adminPassword=:password");
		query.setString("adcd", account);
		query.setString("password", adminPassword);
		return (Adminse) query.uniqueResult();
	}

}
