package com.flickr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.flickr.modelattribute.beans.User;
import com.flickr.service.FlickrService;

@Controller
public class WebController {

	@Autowired
	private FlickrService flickrService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView getHomePage(){
		
		return new ModelAndView("home");
	}
	
	@RequestMapping(value="/signin", method=RequestMethod.GET)
	public ModelAndView getSignIn(){
		
		return new ModelAndView("signin");
	}

/*	@RequestMapping(value="/signout", method=RequestMethod.GET)
	public ModelAndView getSignOut(){
		
		return new ModelAndView("signout");
	}
*/
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public ModelAndView getSignUp(){		
		return new ModelAndView("signup").addObject("user", new User());
	}


	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public ModelAndView postSignUp(@ModelAttribute("user")User user){
	
		System.out.println(user);
		flickrService.saveNewUser(user);
		return new ModelAndView("home");
	}

	@RequestMapping(value="/albums", method=RequestMethod.GET)
	public ModelAndView getAlbumPage(){
		
		return new ModelAndView("albums");
	}

	@RequestMapping(value="/favourites", method=RequestMethod.GET)
	public ModelAndView getFavouritePage(){
		
		return new ModelAndView("favourites");
	}
	
	@RequestMapping(value="/groups", method=RequestMethod.GET)
	public ModelAndView getGroupPage(){
		
		return new ModelAndView("groups");
	}
	
	@RequestMapping(value="/creations", method=RequestMethod.GET)
	public ModelAndView getCreationPage(){
		
		return new ModelAndView("creations");
	}
	
	@RequestMapping(value="/cameraroll", method=RequestMethod.GET)
	public ModelAndView getCameraRollPage(){
		
		return new ModelAndView("cameraroll");
	}

	@RequestMapping(value="/photostream", method=RequestMethod.GET)
	public ModelAndView getPhotoStreamPage(){
		
		return new ModelAndView("photostream");
	}

	@RequestMapping(value="/explore", method=RequestMethod.GET)
	public ModelAndView getExplorePage(){
		
		return new ModelAndView("explore");
	}

	@RequestMapping(value="/denied", method=RequestMethod.GET)
	public ModelAndView getDeniedPage(){
		
		return new ModelAndView("denied");
	}

	@RequestMapping(value="/upload", method=RequestMethod.GET)
	public ModelAndView getUploadPage(){
		
		return new ModelAndView("upload");
	}

}
