package com.movie.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.movie.dao.IBaseDAO;

public class BaseDAOImpl<T> implements IBaseDAO<T> {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Class<T> clazz;

	@SuppressWarnings("unchecked")
	public BaseDAOImpl() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.clazz = (Class) type.getActualTypeArguments()[0];
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(T entity) {
		getSession().save(entity);

	}

	@Override
	public void delete(String id) {
		Object object = getSession().get(clazz, id);
		getSession().delete(object);

	}

	@Override
	public void update(T entity) {
		getSession().update(entity);

	}

	@Override
	public T ger(String id) {
		// TODO Auto-generated method stub
		return (T) getSession().get(clazz, id);
	}

	@Override
	public List<T> list() {
		return getSession().createQuery("from "+clazz.getSimpleName()).list();
	}

}
