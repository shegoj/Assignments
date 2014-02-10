package com.app;

import java.util.ArrayList;
import java.util.List;

public class T_App {
	
	// this stores User Object
	List<User> userList = new ArrayList<User>();
	
	//this stores message Object
	List<Message> messageListing = new ArrayList<Message>();

	/**
	 * Method add message to  messageList
	 * @param user
	 * @param message
	 */
	public void writePosting (String user, String message) {
		
		Message writePosting = new Message();
		writePosting.setMessageData(message);
		writePosting.setMessageSource(user);
		writePosting.setMessageTime();
		messageListing.add(writePosting);
		
		// add user in case not added
		getUser(user);
	}
	
	/**
	 * Method adds a user to another user's 'followers' list
	 * @param follower:  
	 * @param following: 
	 */
	public void followSomeone (String follower, String following) {
		
		User userFollower = getUser (follower);
		userFollower.addFollowing (following);		
	}
	
	/**
	 * The method displays user postings including postings of those he follows
	 * This is read in LIFO manner
	 * @param username
	 */
	
	public void userWall (String username) {
		
		User user = getUser (username);
		List<String> usersFollowed = user.getFollowing();

		for (int i = messageListing.size() -1; i > -1 ; --i) {
			Message message = messageListing.get(i);
			
			String personalMessage = getUserMessage(username,message);
			if (personalMessage.length() > 0) {
					System.out.println(personalMessage);
			}
			else{
				for (int j = 0 ; j < usersFollowed.size() ; ++j) {
					String following_ = usersFollowed.get(j);
					
					if (following_.equals(message.getMessageSource())) {
						String messageInformation = getUserMessage(following_,message);
						if (messageInformation.length() > 0) {
							System.out.println(messageInformation);
							break;
						}
					}
				}
			}
		}
	}
	
	/**
	 * Method reads  user specific posting
	 * @param username
	 */
	public void reading (String username) {

		for (int i = 0 ; i < messageListing.size() ; ++i) {
			Message message = messageListing.get(i);
				if (username.equals(message.getMessageSource())) {
					String messageInformation = getUserMessage(username,message);
					if (messageInformation.length() > 0) {
						System.out.println(messageInformation);
					}
				}
		}
	}
	
	/**This breaks commands down into individual constituents; - main command and argument.
	 * It then calls appropriate method to execute the command.
	 * 
	 * @param command
	 */
	public void commandAnaylzer (String command) {
		
		String [] commandToken =  command.split(" ");
		
		if (command.startsWith("reading:")) {
			//its 'reading' command
			reading(commandToken[1]);	
		}
		if (command.startsWith("following:")) {
			 followSomeone(commandToken[1], commandToken[3]);
		}
		if (command.startsWith("wall:")) {
			userWall(commandToken[1]);
		}
		
		if (command.startsWith("posting:")) {
			
			StringBuilder buffer = new StringBuilder();
			for(int i = 3; i < commandToken.length ; ++i){
				buffer = buffer.append(commandToken[i]).append(" ");
			}
			
			writePosting(commandToken[1], buffer.toString());
		}	
	}
	
	/**Retrieve message data and time of message for specific user from Message Object
	 * 
	 * @param userName
	 * @param message
	 * @return
	 */
	private String getUserMessage (String userName, Message message) {
		StringBuilder outputMessage = new StringBuilder();
		
		if (userName.equals(message.getMessageSource())) {
			outputMessage = new StringBuilder();
			outputMessage.append(userName).append(" - ").append(message.getMessageData()).append( "(").append(message.getMessageTime() + ")");
		}
		return outputMessage.toString();
	}
	
	/**
	 * Fetch user object from User list. If User does not exist in the list, add one. This is only for the sake of this exercise
	 * @param user
	 * @return
	 */
	
	private User getUser(String user) {
		
		for (int i = 0 ; i < userList.size(); ++i) {
			if (user.equals(userList.get(i).getUsername()))
				return userList.get(i);
			}
		
		// user not found, add
		User newUser = new User();
		newUser.setUsername(user);
		userList.add(newUser);
		
		return newUser;
	}
	
	public List<User> getUserList() {
		
		return userList;
	}
	
	public List<Message> getMessageList() {	
		return messageListing;
	}
}
