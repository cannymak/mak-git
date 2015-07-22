package com.newsx.dao;

import java.util.List;

import com.newsx.domain.News;
import com.newsx.domain.NewsMetric;

public interface NewsDao {

	public List<News> getAllNews();

	public void persistNews(News news);
	
	public News getNewsById(Long newsId);
	
	public List<News> searchNewsByQuery(String query);
	
	public List<News> getNewsByType(String newsType);
	
	public List<News> getNewsForCarouselbyNewsType(String str);
	
	public List<News> getRecommendedNewsByNewsType(String str);
	
	public List<NewsMetric> getNewsMetric();
	
	public List<News> getRecommendedNewsByNewsType(String str, Long count);

}
