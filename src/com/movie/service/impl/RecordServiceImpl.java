package com.movie.service.impl;

import java.util.List;

import com.movie.dao.IRecordDAO;
import com.movie.pojo.QueryMovie;
import com.movie.pojo.Record;
import com.movie.service.IRecordService;

public class RecordServiceImpl implements IRecordService {
	private IRecordDAO recordDAO;

	public void setRecordDAO(IRecordDAO recordDAO) {
		this.recordDAO = recordDAO;
	}

	@Override
	public void addRecord(Record record) {
	     recordDAO.add(record);

	}

	@Override
	public boolean delRecord(String id) {
		recordDAO.delete(id);
		return true;
	}

	@Override
	public List<Record> getAllRecord(QueryMovie queryMovie) throws Exception {
		return recordDAO.list(queryMovie);
	}
	@Override
	public Record getRecord(String id){
		return recordDAO.ger(id);
	}
	@Override
	public int getCount(QueryMovie queryMovie) throws Exception{
		return recordDAO.getCount(queryMovie);
	}

	@Override
	public List<Record> GET(String moviesId) throws Exception {
		// TODO Auto-generated method stub
		return recordDAO.GET(moviesId);
	}
}
