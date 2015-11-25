package my.test.notepad.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {

	@Id
	private long userId;
	
	private String userName;
	
	public long getId() {
		return userId;
	}
	public void setId(long id) {
		this.userId = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String name) {
		this.userName = name;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + "]";
	}

	
	
}
