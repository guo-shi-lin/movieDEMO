package com.movie.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "RECORD")
public class Record {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(length = 32)
	private String id;

	@Column(length = 32)
	private String userId;//用户id

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(length = 32)
	private String moviesId;//电影id

	public String getMoviesId() {
		return moviesId;
	}

	public void setMoviesId(String moviesId) {
		this.moviesId = moviesId;
	}

	@Column(length = 11)
	private String directs;// 导演
	@Column(length = 11)
	private String mLanguages;// 语言
	@Column(length = 32)
	private String movieNames;// 电影名
	@Column(length = 32)
	private String movieTypes;// 类型
	@Column(length = 50)
	private String playActors;// 演员
	@Column(length = 50)
	private String moviePhotos;// 电影图片
	@Column(length = 11)
	private String year;// 年代

	@Column(length = 32)
	private String movieAreas;// 地区
	@Column(length = 225)
	private String mIntroduces;// 影视介绍

	private String movies;// 电影

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDirects() {
		return directs;
	}

	public void setDirects(String directs) {
		this.directs = directs;
	}

	public String getmLanguages() {
		return mLanguages;
	}

	public void setmLanguages(String mLanguages) {
		this.mLanguages = mLanguages;
	}

	public String getMovieNames() {
		return movieNames;
	}

	public void setMovieNames(String movieNames) {
		this.movieNames = movieNames;
	}

	public String getMovieTypes() {
		return movieTypes;
	}

	public void setMovieTypes(String movieTypes) {
		this.movieTypes = movieTypes;
	}

	public String getPlayActors() {
		return playActors;
	}

	public void setPlayActors(String playActors) {
		this.playActors = playActors;
	}

	public String getMoviePhotos() {
		return moviePhotos;
	}

	public void setMoviePhotos(String moviePhotos) {
		this.moviePhotos = moviePhotos;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMovieAreas() {
		return movieAreas;
	}

	public void setMovieAreas(String movieAreas) {
		this.movieAreas = movieAreas;
	}

	public String getmIntroduces() {
		return mIntroduces;
	}

	public void setmIntroduces(String mIntroduces) {
		this.mIntroduces = mIntroduces;
	}

	public String getMovies() {
		return movies;
	}

	public void setMovies(String movies) {
		this.movies = movies;
	}

	@Override
	public String toString() {
		return "Record [id=" + id + ", userId=" + userId + ", moviesId=" + moviesId + ", directs=" + directs
				+ ", mLanguages=" + mLanguages + ", movieNames=" + movieNames + ", movieTypes=" + movieTypes
				+ ", playActors=" + playActors + ", moviePhotos=" + moviePhotos + ", year=" + year + ", movieAreas="
				+ movieAreas + ", mIntroduces=" + mIntroduces + ", movies=" + movies + "]";
	}

	
}
