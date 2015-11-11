package my.test.notepad.service;

import java.util.List;

import my.test.notepad.entity.Note;
import my.test.notepad.entity.User;
import my.test.notepad.lib.exception.NoteException;
import my.test.notepad.resourceEntity.NoteEntity;
import my.test.notepad.resourceEntity.UserEntity;

public interface INotesService {

	public boolean saveUpdateNote(int noteId, int userId, String content);
	
	public Note getNote(int noteId);
	
	public User getUser(Integer userId);

	public List<Integer> getUserNoteIds(int userId);
	
	public boolean deleteNote(int noteId);
	
	public Note getNote(NoteEntity noteEntity);
	
	public User getUser(UserEntity userEntity);
	
	public void saveOrUpdateNote(Note note);
	
	public void createNote(Note note) throws NoteException;
	
	public void updateNote(Integer noteId, String note) throws NoteException;
	
	void createOrUpdateUser(User user);

}
