package com.movie.dao;

import java.util.List;

public interface IBaseDAO<T> {
	public void add(T entity);

	public void delete(String id);

	public void update(T entity);

	public T ger(String id);

	public List<T> list();
}
