package my.test.notepad.lib;

public class ErrorResponseMessage {
	ErrorCode erroCode;
	String description;
	public ErrorCode getErroCode() {
		return erroCode;
	}
	public void setErroCode(ErrorCode erroCode) {
		this.erroCode = erroCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
