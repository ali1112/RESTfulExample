package my.test.notepad.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {

	@Id
	private int Id;
	
	private String userName;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String name) {
		this.userName = name;
	}
	
	
}
