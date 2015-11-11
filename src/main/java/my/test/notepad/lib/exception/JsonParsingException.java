package my.test.notepad.lib.exception;

import my.test.notepad.lib.ErrorCode;

public class JsonParsingException extends NoteException{

	public JsonParsingException() {
		super(ErrorCode.JSON_PARSING_EXCEPTION, "Error parsing json");
	}

}
