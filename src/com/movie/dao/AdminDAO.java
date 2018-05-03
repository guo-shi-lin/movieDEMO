package com.movie.dao;

import com.movie.pojo.Adminse;

public interface AdminDAO extends IBaseDAO<Adminse> {
public Adminse login(String account,String adminPassword);
}
