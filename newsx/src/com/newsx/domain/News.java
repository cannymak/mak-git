package com.newsx.domain;

import java.io.Serializable;

public class News implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2318155903587336355L;
	private Long news_id;
	private String headlines;
	private String mainStory;
	private String videourl;
	private String imageurl;
	private String newstype;

	public Long getNews_id() {
		return news_id;
	}

	public void setNews_id(Long news_id) {
		this.news_id = news_id;
	}

	public String getHeadlines() {
		return headlines;
	}

	public void setHeadlines(String headlines) {
		this.headlines = headlines;
	}

	public String getMainStory() {
		return mainStory;
	}

	public void setMainStory(String mainStory) {
		this.mainStory = mainStory;
	}

	public String getVideourl() {
		return videourl;
	}

	public void setVideourl(String videourl) {
		this.videourl = videourl;
	}

	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	public String getNewstype() {
		return newstype;
	}

	public void setNewstype(String newstype) {
		this.newstype = newstype;
	}

	@Override
	public String toString() {
		return "News [news_id=" + news_id + ", headlines=" + headlines
				+ ", mainStory=" + mainStory + ", videourl=" + videourl
				+ ", imageurl=" + imageurl + ", newstype=" + newstype + "]";
	}

}
