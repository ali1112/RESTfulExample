package my.test.notepad.lib;

public enum ErrorCode {

    DATABASE_ERROR(1000, "DataBase Error"),
    NOTE_NOT_FOUND(2001, "Note Not Found"),
    NOTE_EXISTS(2002, "Note Already Exists"),
    JSON_PARSING_EXCEPTION(3001, "Json Parsing Eception"),
    NOTE_DELETE_EROOR(2003, "Error Deleting Note"),
    UNKNOWN_EROOR(2003, "Unknown Error");



    
    private int code;
    private String description;


    ErrorCode(int code, String desc) {
        this.code = code;
        this.description = desc;
    }


	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

    
}
