package com.movie.service;

import java.util.List;

import com.movie.pojo.Movies;
import com.movie.pojo.QueryMovie;

public interface IMovieService {
	public List<Movies> getAllMovies();

	public void addMovies(Movies movies);

	public Movies getMovies(String id);

	public boolean delMovies(String id);

	public List<Movies> getAllMovies(QueryMovie queryMovie) throws Exception;

	public int getCount(QueryMovie queryMovie) throws Exception;
	
	 public List<Movies> playMovies();
	 public List<Movies> terrorMovies();
	 public List<Movies> comedyMovies();
	 public List<Movies> loveMovies();
	 public List<Movies> scienceMovies();
	 public List<Movies> exploreMovies();
	 
	 public List<Movies> timesMovies();
}
