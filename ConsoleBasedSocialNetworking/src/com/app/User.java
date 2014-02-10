package com.app;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author sojewale
 *
 *class implements application User
 */
public class User {
	
	private String username;
	private List<String> usersFollowed = new ArrayList<String>();
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public void addFollowing(String otherUser ) {
		usersFollowed.add(otherUser);
	}
	
	public List<String> getFollowing() {
		return usersFollowed;
	}

}
