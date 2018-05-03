package com.movie.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.movie.dao.IRecordDAO;
import com.movie.pojo.Movies;
import com.movie.pojo.QueryMovie;
import com.movie.pojo.Record;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.QEncoderStream;

public class RecordDAOImpl extends BaseDAOImpl<Record> implements IRecordDAO {

	@Override
	public List<Record> list(QueryMovie queryMovie) throws Exception {
	Criteria criteria = getSession().createCriteria(Record.class);
	if(!queryMovie.getUserId().equals(""))
		criteria.add(Restrictions.like("userId", "%"+queryMovie.getUserId()+"%"));
	criteria.setMaxResults(10);//每页10条
	criteria.setFirstResult((queryMovie.getPageNo()-1)*10);//从第几条开始读取数据
		return criteria.list();
	}
	public int getCount(QueryMovie queryMovie) throws Exception{
		Criteria criteria = getSession().createCriteria(Movies.class);
		if(!queryMovie.getUserId().equals(""))
			criteria.add(Restrictions.like("userId", "%"+queryMovie.getUserId()+"%"));
		criteria.setProjection(Projections.rowCount());//映射总行数
		return Integer.parseInt(criteria.uniqueResult().toString()) ;
	}
	@Override
	public List<Record> GET(String moviesId) {
		String hql = "from Record where moviesId= '"+moviesId+"' "; 
	 Query query = getSession().createQuery(hql);
	 List<Record> record = query.list();
		return record;
	}

}
