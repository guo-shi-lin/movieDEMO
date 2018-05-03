package com.movie.service;

import java.util.List;
import com.movie.pojo.QueryMovie;
import com.movie.pojo.Record;

public interface IRecordService {
	
	public void addRecord(Record record);
	
	public boolean delRecord(String id);
	
	public Record getRecord(String id);
	
	public List<Record> getAllRecord(QueryMovie queryMovie) throws Exception;
	
	public int getCount(QueryMovie queryMovie) throws Exception;
	
	public List<Record> GET(String moviesId) throws Exception;
}
