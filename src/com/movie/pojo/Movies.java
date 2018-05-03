package com.movie.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "MOVIE")
public class Movies {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(length = 32)
	private String id;
	@Column(length = 11)
	private String direct;// 导演
	@Column(length = 11)
	private String mLanguage;// 语言
	@Column(length = 32)
	private String movieName;// 电影名
	@Column(length = 32)
	private String movieType;// 类型
	@Column(length = 50)
	private String playActor;// 演员
	
	private Date movieTime;// 更新时间
	@Column(length = 50)
	private String moviePhoto;//电影图片
	
	@Column(length = 11)
	private String years;// 年代
	@Column(length = 32)
	private String movieArea;// 地区
	@Column(length = 225)
	private String mIntroduce;// 影视介绍
	private String movie;// 电影

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDirect() {
		return direct;
	}

	public void setDirect(String direct) {
		this.direct = direct;
	}

	public String getmLanguage() {
		return mLanguage;
	}

	public void setmLanguage(String mLanguage) {
		this.mLanguage = mLanguage;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieType() {
		return movieType;
	}

	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}

	public String getPlayActor() {
		return playActor;
	}

	public void setPlayActor(String playActor) {
		this.playActor = playActor;
	}

	

	public String getMoviePhoto() {
		return moviePhoto;
	}

	public void setMoviePhoto(String moviePhoto) {
		this.moviePhoto = moviePhoto;
	}

	public Date getMovieTime() {
		return movieTime;
	}

	public void setMovieTime(Date movieTime) {
		this.movieTime = movieTime;
	}

	public String getYears() {
		return years;
	}

	public void setYears(String years) {
		this.years = years;
	}

	public String getMovieArea() {
		return movieArea;
	}

	public void setMovieArea(String movieArea) {
		this.movieArea = movieArea;
	}

	public String getmIntroduce() {
		return mIntroduce;
	}

	public void setmIntroduce(String mIntroduce) {
		this.mIntroduce = mIntroduce;
	}

	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}

	@Override
	public String toString() {
		return "Movies [id=" + id + ", direct=" + direct + ", mLanguage=" + mLanguage + ", movieName=" + movieName
				+ ", movieType=" + movieType + ", playActor=" + playActor + ", movieTime=" + movieTime + ", moviePhoto="
				+ moviePhoto + ", years=" + years + ", movieArea=" + movieArea + ", mIntroduce=" + mIntroduce
				+ ", movie=" + movie + "]";
	}



	
	
}
