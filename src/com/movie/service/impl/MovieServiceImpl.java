package com.movie.service.impl;

import java.util.List;

import com.movie.dao.IMovieDAO;
import com.movie.pojo.Movies;
import com.movie.pojo.QueryMovie;
import com.movie.service.IMovieService;

public class MovieServiceImpl implements IMovieService {
	private IMovieDAO movieDAO;

	public void setMovieDAO(IMovieDAO movieDAO) {
		this.movieDAO = movieDAO;
	}

	@Override
	public List<Movies> getAllMovies() {
		// TODO Auto-generated method stub
		return movieDAO.list();
	}

	@Override
	public void addMovies(Movies movies) {
		// TODO Auto-generated method stub
		movieDAO.add(movies);
	}
	@Override
	public Movies getMovies(String id) {
		// TODO Auto-generated method stub
		return movieDAO.ger(id);
	}
	@Override
	public boolean delMovies(String id) {
		// TODO Auto-generated method stub
		movieDAO.delete(id);
			return true;
	}
	public List<Movies> getAllMovies(QueryMovie queryMovie) throws Exception{
		return movieDAO.list(queryMovie);
	}
	public int getCount(QueryMovie queryMovie) throws Exception{
		return movieDAO.getCount(queryMovie);
	}

	@Override
	public List<Movies> playMovies() {
		// TODO Auto-generated method stub
		return movieDAO.play();
	}

	@Override
	public List<Movies> terrorMovies() {
		// TODO Auto-generated method stub
		return movieDAO.terror() ;
	}

	@Override
	public List<Movies> comedyMovies() {
		// TODO Auto-generated method stub
		return movieDAO.comedy();
	}

	@Override
	public List<Movies> loveMovies() {
		// TODO Auto-generated method stub
		return movieDAO.love();
	}

	@Override
	public List<Movies> scienceMovies() {
		// TODO Auto-generated method stub
		return movieDAO.science();
	}

	@Override
	public List<Movies> exploreMovies() {
		// TODO Auto-generated method stub
		return movieDAO.explore();
	}

	@Override
	public List<Movies> timesMovies() {
		// TODO Auto-generated method stub
		return movieDAO.times();
	}
}
