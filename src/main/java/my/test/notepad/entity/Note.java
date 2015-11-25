package my.test.notepad.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Note {

	private String note;
	@Id
	private long noteId;
	private long noteBookId;
	private int noteUserId;	
	private Date createDate;
	private Date updateDate;
	
	
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

	public void setNoteId(long noteId) {
		this.noteId = noteId;
	}
	public int getNoteUserId() {
		return noteUserId;
	}
	public void setNoteUserId(int noteUserId) {
		this.noteUserId = noteUserId;
	}
	public long getNoteId() {
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
	
	public long getNoteBookId() {
		return noteBookId;
	}
	public void setNoteBookId(long noteBookId) {
		this.noteBookId = noteBookId;
	}
	
	@Override
	public String toString() {
		return "Note [note=" + note + ", noteId=" + noteId + ", noteBookId=" + noteBookId + ", noteUserId=" + noteUserId
				+ ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}
	

}
