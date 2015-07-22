package com.newsx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newsx.dao.NewsDao;
import com.newsx.domain.News;
import com.newsx.domain.NewsMetric;

@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsDao newsDao;

	@Override
	public List<News> getEveryNewsFromMyDB() {
		// TODO Auto-generated method stub
		return newsDao.getAllNews();
	}

	@Override
	public News getNewsByNewsId(Long id) {
		// TODO Auto-generated method stub
		return newsDao.getNewsById(id);
	}

	@Override
	public void saveLatestNews(News news) {
		// TODO Auto-generated method stub
		newsDao.persistNews(news);
	}

	@Override
	public List<News> searchNews(String str) {
		// TODO Auto-generated method stub
		return newsDao.searchNewsByQuery(str);
	}

	@Override
	public List<News> getAllNewsByNewsType(String str) {
		// TODO Auto-generated method stub
		return newsDao.getNewsByType(str);
	}

	@Override
	public List<News> getNewsForCarouselbyNewsType(String str) {
		// TODO Auto-generated method stub
		return newsDao.getNewsForCarouselbyNewsType(str);
	}

	@Override
	public List<News> getRecommendedNewsByNewsType(String str) {
		// TODO Auto-generated method stub
		return newsDao.getRecommendedNewsByNewsType(str);
	}

	@Override
	public List<NewsMetric> getNewsMetric() {
		// TODO Auto-generated method stub
		return newsDao.getNewsMetric();

	}

	@Override
	public List<News> getRecommendedNewsByNewsType(String str, Long count) {
		// TODO Auto-generated method stub
		return newsDao.getRecommendedNewsByNewsType(str, count);
	}

	@Override
	public String getChartData() {
		// TODO Auto-generated method stub
		// List<NewsMetric> news=getNewsMetric();
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (NewsMetric nm : getNewsMetric()) {
			sb.append("{ y:" + nm.getCount() + ", label: \"" + nm.getNewsType()
					+ "\" },");
		}
		sb.append("]");
		return sb.toString();
	}

}
