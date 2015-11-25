package my.test.notepad.entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class NoteBook {
	
	@Id
	private Long noteBookId;
	List<Long> noteIds;
	private long noteBookUserId;	
	private Date createDate;
	private Date updateDate;
	
	public Long getNoteBookId() {
		return noteBookId;
	}
	public void setNoteBookId(Long noteBookId) {
		this.noteBookId = noteBookId;
	}
	public List<Long> getNoteIds() {
		return noteIds;
	}
	public void setNoteIds(List<Long> noteIds) {
		this.noteIds = noteIds;
	}
	public long getNoteBookUserId() {
		return noteBookUserId;
	}
	public void setNoteBookUserId(long noteBookUserId) {
		this.noteBookUserId = noteBookUserId;
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
