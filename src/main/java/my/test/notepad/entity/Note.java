package my.test.notepad.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Note {

	private String note;
	@Id
	private int id;
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
	@Override
	public String toString() {
		return "Note [note=" + note + ", id=" + id + ", noteUserId=" + noteUserId + "]";
	}
	
}
