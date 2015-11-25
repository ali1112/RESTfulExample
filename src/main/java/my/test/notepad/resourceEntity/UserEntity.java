package my.test.notepad.resourceEntity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserEntity {
	
	@JsonProperty("userId")
	private long userId;
	
	@JsonProperty("userName")
	private String userName;
		

	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String name) {
		this.userName = name;
	}
	
	
}
