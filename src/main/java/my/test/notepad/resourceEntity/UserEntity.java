package my.test.notepad.resourceEntity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserEntity {
	
	@JsonProperty("userId")
	private int userId;
	
	@JsonProperty("userName")
	private String userName;
		

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String name) {
		this.userName = name;
	}
	
	
}
