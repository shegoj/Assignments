package com.app;

/**
 * 
 * @author sojewale
 *
 */
public class Message {
	
private String	messageData  = null;
private String	messageTime = null;
private String 	messageSource = null;

  public String getMessageData() {
		return messageData;
	}
  
	public void setMessageData(String messageData) {
		this.messageData = messageData;
	}
	
	public String getMessageTime() {
		return  HelperUtil.formatMessageTime(messageTime);
	}
	
	public void setMessageTime() {
		this.messageTime = HelperUtil.getCurrentTime();
	}
	
	public String getMessageSource() {
		return messageSource;
	}
	public void setMessageSource(String username) {
		this.messageSource = username;
	}


}
