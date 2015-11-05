package my.test.notepad.resourceEntity;

import org.codehaus.jackson.annotate.JsonProperty;

public class UserEntity {
	
	@JsonProperty("id")
	private int Id;
	
	@JsonProperty("userName")
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
