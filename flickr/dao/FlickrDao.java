package com.flickr.dao;

import com.flickr.hibernate.entities.FlickrUser;
import com.flickr.modelattribute.beans.User;

public interface FlickrDao {

	public void persistNewUser(FlickrUser fuser);
	
}
