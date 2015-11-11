package my.test.notepad.resourceEntity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;


public class NoteEntity {

	@JsonProperty("note")
	private String note;
	
	@JsonProperty("noteId")
	private int noteId;
	
	@JsonProperty("note_user_id")
	private int noteUserId;

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	@JsonProperty("createDate")
	private Date createDate;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	@JsonProperty("updateDate")
	private Date updateDate;
	
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getId() {
		return noteId;
	}

	public void setId(int id) {
		this.noteId = id;
	}

	public int getNoteUserId() {
		return noteUserId;
	}

	public void setNoteUserId(int noteUserId) {
		this.noteUserId = noteUserId;
	}

	public int getNoteId() {
		return noteId;
	}

	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	
}
