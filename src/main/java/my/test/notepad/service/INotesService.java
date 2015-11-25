package my.test.notepad.service;

import java.util.List;

import my.test.notepad.entity.Note;
import my.test.notepad.entity.NoteBook;
import my.test.notepad.entity.User;
import my.test.notepad.lib.exception.NoteException;
import my.test.notepad.resourceEntity.NoteBookEntity;
import my.test.notepad.resourceEntity.NoteEntity;
import my.test.notepad.resourceEntity.UserEntity;

public interface INotesService {

	public boolean saveUpdateNote(int noteId, int userId, String content);
	
	public Note getNote(Long noteId);
	
	public User getUser(Long userId);

	public List<Integer> getUserNoteIds(int userId);
	
	public boolean deleteNote(int noteId);
	
	public Note getNote(NoteEntity noteEntity);
	
	public NoteBook getNoteBook(NoteBookEntity noteBookEntity);
	
	public NoteEntity getNoteEntity(Note note);
	
	public User getUser(UserEntity userEntity);
	
	public void saveOrUpdateNote(Note note);
	
	public Note createNote(Note note) throws NoteException;
	
	public void updateNote(Long noteId, String note) throws NoteException;
	
	void createOrUpdateUser(User user);

	NoteBook createNoteBook(NoteBook noteBook) throws NoteException;

	public NoteBookEntity getNoteBookEntity(NoteBook noteBook);
	
	public void deleteNote(Long noteId) throws NoteException;
	
	public void deleteNotes(List<Long> noteId);
	
	public void deleteNoteBook(Long noteBookId) throws NoteException;

}
