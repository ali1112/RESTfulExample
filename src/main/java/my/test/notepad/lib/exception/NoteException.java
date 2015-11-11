package my.test.notepad.lib.exception;

import my.test.notepad.lib.ErrorCode;

public class NoteException extends Exception {

	ErrorCode errorCode;
	String errorDescription;
	public ErrorCode getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorDescription() {
		return errorDescription;
	}
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	
	public NoteException(ErrorCode errorCode, String errorDescription) {
		super();
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
	}
	
	
}
