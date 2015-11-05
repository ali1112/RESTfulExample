package my.test.rest.service;

import java.util.List;

import my.test.notepad.entity.Note;
import my.test.notepad.entity.User;
import my.test.notepad.resourceEntity.NoteEntity;
import my.test.notepad.resourceEntity.UserEntity;

public interface INotesService {

	public boolean saveUpdateNote(int noteId, int userId, String content);
	
	public Note getNote(int noteId);
	
	public List<Integer> getUserNoteIds(int userId);
	
	public boolean deleteNote(int noteId);
	
	public Note getNote(NoteEntity noteEntity);
	
	public User getUser(UserEntity userEntity);
	
	public void saveOrUpdateNote(Note note);

	void createOrUpdateUser(User user);
}
