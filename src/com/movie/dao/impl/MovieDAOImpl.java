package com.movie.dao.impl;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import com.movie.dao.IMovieDAO;
import com.movie.pojo.Movies;
import com.movie.pojo.QueryMovie;

public class MovieDAOImpl extends BaseDAOImpl<Movies> implements IMovieDAO {
	public List<Movies>list(QueryMovie queryMovie)throws Exception{
		Criteria criteria = getSession().createCriteria(Movies.class);
		if(!queryMovie.getMovieName().equals(""))
		criteria.add(Restrictions.like("movieName", "%"+queryMovie.getMovieName()+"%"));
		criteria.setMaxResults(4);//每页3条
		criteria.setFirstResult((queryMovie.getPageNo()-1)*4);//从第几条开始读取数据
		return criteria.list();
	}
	public int getCount(QueryMovie queryMovie) throws Exception{
		Criteria criteria = getSession().createCriteria(Movies.class);
		if(!queryMovie.getMovieName().equals(""))
		criteria.add(Restrictions.like("movieName", "%"+queryMovie.getMovieName()+"%"));
		criteria.setProjection(Projections.rowCount());//映射总行数
		return Integer.parseInt(criteria.uniqueResult().toString()) ;
	}
@Override
public List<Movies> terror() {
	 String hql = "from Movies where movieType='恐怖'";  
     Query query = getSession().createQuery(hql);  
     List<Movies> movie = query.list();
		return movie;
}
@Override
public List<Movies> comedy() {
	 String hql = "from Movies where movieType='喜剧'";  
     Query query = getSession().createQuery(hql);  
     List<Movies> movie = query.list();
		return movie;
}
@Override
public List<Movies> love() {
	 String hql = "from Movies where movieType='爱情'";  
     Query query = getSession().createQuery(hql);  
     List<Movies> movie = query.list();
		return movie;
}
@Override
public List<Movies> science() {
	 String hql = "from Movies where movieType='科幻'";  
     Query query = getSession().createQuery(hql);  
     List<Movies> movie = query.list();
		return movie;
}
@Override
public List<Movies> explore() {
	 String hql = "from Movies where movieType='探险'";  
     Query query = getSession().createQuery(hql);  
     List<Movies> movie = query.list();
		return movie;
}
@Override
public List<Movies> play(){
	 String hql = "from Movies where movieType='动作'";  
     Query query = getSession().createQuery(hql);  
     List<Movies> movie = query.list();
		return movie;
}
@Override
public List<Movies> times() {
	String hql = "from Movies order by movieTime desc";
	Query query = getSession().createQuery(hql);
	 List<Movies> movie = query.list();
	return movie;
}
}
