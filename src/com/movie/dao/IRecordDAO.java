package com.movie.dao;

import java.util.List;
import com.movie.pojo.QueryMovie;
import com.movie.pojo.Record;

public interface IRecordDAO extends IBaseDAO<Record> {
	public List<Record> list(QueryMovie queryMovie)throws Exception;
	public int getCount(QueryMovie queryMovie) throws Exception;
	
	 public List<Record> GET(String moviesId);
}
