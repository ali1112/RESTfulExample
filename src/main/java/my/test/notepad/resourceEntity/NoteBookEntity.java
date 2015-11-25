package my.test.notepad.resourceEntity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;


public class NoteBookEntity {

	@JsonProperty("noteBookId")
	private long noteBookId;	
	
	@JsonProperty("noteIds")
	List<Long> noteIds;
	
	@JsonProperty("noteBookUserId")
	private long noteBookUserId;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ssz")
	@JsonProperty("createDate")
	private Date createDate;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ssz")
	@JsonProperty("updateDate")
	private Date updateDate;
	
	public long getNoteBookId() {
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
	@Override
	public String toString() {
		return "NoteBookEntity [noteBookId=" + noteBookId + ", noteIds=" + noteIds + ", noteBookUserId="
				+ noteBookUserId + ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}
	
	
}
