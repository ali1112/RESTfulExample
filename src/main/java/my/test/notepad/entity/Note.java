package my.test.notepad.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Note {

	private String note;
	@Id
	private int noteId;
	private int noteUserId;	
	private Date createDate;
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
	@Override
	public String toString() {
		return "Note [note=" + note + ", noteId=" + noteId + ", noteUserId=" + noteUserId + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + "]";
	}

}
