package com.movie.pojo;
/*
 * 查询电影的分装类
 */
public class QueryMovie {
private String movieName = "";
private String userId = "";
private int pageNo;
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}

public String getMovieName() {
	return movieName;
}
public void setMovieName(String movieName) {
	this.movieName = movieName;
}
public int getPageNo() {
	return pageNo;
}
public void setPageNo(int pageNo) {
	this.pageNo = pageNo;
}
}
