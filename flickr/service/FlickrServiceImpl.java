package com.flickr.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flickr.dao.FlickrDao;
import com.flickr.hibernate.entities.FlickrUser;
import com.flickr.hibernate.entities.FlickrUserProfile;
import com.flickr.hibernate.entities.FlickrUserRole;
import com.flickr.modelattribute.beans.User;
import com.flickr.utils.SecurityUtils;

@Service
@Transactional
public class FlickrServiceImpl implements FlickrService {

	@Autowired
	private FlickrDao flickrDao;
	
	@Override
	public void saveNewUser(User user) {
		// TODO Auto-generated method stub
	System.out.println(user);
		FlickrUser fuser= new FlickrUser();
		fuser.setEnabled(true);
		fuser.setUserCreatedDate(new Date());
		fuser.setUserUsername(user.getUsername());
		fuser.setUserUpdatedDate(new Date());
		fuser.setUserPassword(SecurityUtils.setEncryptPassword(user.getPassword()));
		
		FlickrUserRole frole=new FlickrUserRole();
		frole.setUserRoleCreatedDate(new Date());
		frole.setUserRoleRole("ROLE_USER");
		frole.setUserRoleUpdatedDate(new Date());
		frole.setUserRoleUsername(user.getUsername());
		frole.setFlickrUser(fuser);
		fuser.setFlickrUserRoles(frole);
		
		FlickrUserProfile fprofile = new FlickrUserProfile();
		fprofile.setFlickrUser(fuser);
		
		try{			
		fprofile.setProfileImageType(user.getPicture().getContentType());
		fprofile.setUserProfilePicture(user.getPicture().getBytes());		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		fprofile.setUserProfileCreatedDate(new Date());
		fprofile.setUserProfileEmail(user.getEmail());
		fprofile.setUserProfileFirstName(user.getFirstname());
		fprofile.setUserProfileLastName(user.getLastname());
		fprofile.setUserProfilePhoneNumber(user.getPhonenumber());
		fprofile.setUserProfileUpdatedDate(new Date());
		fuser.setFlickrUserProfiles(fprofile);
		
		flickrDao.persistNewUser(fuser);
		
	}

	
}
