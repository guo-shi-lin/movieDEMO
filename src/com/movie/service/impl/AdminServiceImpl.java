package com.movie.service.impl;

import com.movie.dao.AdminDAO;
import com.movie.pojo.Adminse;
import com.movie.service.IAdminService;

public class AdminServiceImpl implements IAdminService {
public AdminDAO adminDao;
	public void setAdminDao(AdminDAO adminDao) {
	this.adminDao = adminDao;
}
	@Override
	public Adminse login(String account, String adminPassword) {
		Adminse adminse = new Adminse();
		try {
			adminse=adminDao.login(account, adminPassword);
				
			}
		 catch (Exception e) {
			e.printStackTrace();
		}
		
		return adminse;
	}

}
