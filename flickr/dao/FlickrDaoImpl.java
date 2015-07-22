package com.flickr.dao;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.flickr.hibernate.entities.FlickrUser;

@Repository
@Transactional
public class FlickrDaoImpl implements FlickrDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void persistNewUser(FlickrUser fuser) {
		// TODO Auto-generated method stub
		
		
		System.out.println(fuser);
		sessionFactory.getCurrentSession().save(fuser);
		
	}
	
	
	

}
