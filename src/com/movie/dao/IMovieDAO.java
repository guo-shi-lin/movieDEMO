package com.movie.dao;

import java.util.List;

import com.movie.pojo.Movies;
import com.movie.pojo.QueryMovie;

public interface IMovieDAO extends IBaseDAO<Movies> {
	public List<Movies> list(QueryMovie queryMovie) throws Exception;

	public int getCount(QueryMovie queryMovie) throws Exception;

	public List<Movies> play();

	public List<Movies> terror();

	public List<Movies> comedy();

	public List<Movies> love();

	public List<Movies> science();

	public List<Movies> explore();

	public List<Movies> times();
}
