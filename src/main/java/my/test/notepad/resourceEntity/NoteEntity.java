package my.test.notepad.resourceEntity;

import org.codehaus.jackson.annotate.JsonProperty;

public class NoteEntity {

	@JsonProperty("note")
	private String note;
	
	@JsonProperty("id")
	private int id;
	
	@JsonProperty("note_user_id")
	private int noteUserId;

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNoteUserId() {
		return noteUserId;
	}

	public void setNoteUserId(int noteUserId) {
		this.noteUserId = noteUserId;
	}
	
	
}
