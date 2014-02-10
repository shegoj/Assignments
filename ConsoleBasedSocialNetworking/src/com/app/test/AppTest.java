package com.app.test;

import com.app.T_App;
import com.app.User;

/**
 * 
 * @author sojewale
 *
 */

public class AppTest{
	
	/**
	 * Test writePost
	 */
	public static void postTest() {
		
		T_App app = new T_App(); 
		app.writePosting("Mark", "Hello world");
		assert (app.getMessageList().get(0).getMessageData().equals("Hello world"));
		assert (app.getMessageList().get(0).getMessageSource().equals("Mark"));
		
		System.out.println("'Post' test succeeds");
	}
	
	/**
	 * Test 'Follow' method
	 */
	public static void followsTest() {
		
		T_App app = new T_App(); 
		
		User mark = new User();
		mark.setUsername("Mark");
		
		User james = new User();
		mark.setUsername("James");
		
		app.followSomeone("Mark", "James");
		assert (mark.getFollowing().get(0).equals("James"));
		
		System.out.println("'Follow' test succeeds");
	}
	
	public static void main (String args[]) {
		
		AppTest test = new AppTest();
		test.postTest();
		test.followsTest();
	}

}
