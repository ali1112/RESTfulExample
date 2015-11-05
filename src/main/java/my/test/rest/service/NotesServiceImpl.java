package my.test.rest.service;

import java.util.List;

import my.test.notepad.dao.NoteDao;
import my.test.notepad.dao.UserDao;
import my.test.notepad.entity.Note;
import my.test.notepad.entity.User;
import my.test.notepad.resourceEntity.NoteEntity;
import my.test.notepad.resourceEntity.UserEntity;
import my.test.notepad.utils.Constants;

public class NotesServiceImpl implements INotesService {

	private NoteDao noteDao;
	private UserDao userDao;
	
	
	
	public NotesServiceImpl() {
		super();
		this.noteDao = new NoteDao();
		this.userDao = new UserDao();
	}

	@Override
	public boolean saveUpdateNote(int noteId, int userId, String content) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Note getNote(int noteId) {
		Note note = new Note();
		note.setId(123);
		note.setNote("text note");
		note.setNoteUserId(1);
		Note note1 = noteDao.getByID((String.valueOf(noteId)), Constants.NOTE_COLLECTION);
		return note1;
		//return "{\"id\":\"123\",\"note\":\"text note\", \"noteUserId\":\"1\"}";
	}

	@Override
	public List<Integer> getUserNoteIds(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteNote(int noteId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Note getNote(NoteEntity noteEntity) {
		Note note = new Note();
		note.setId(noteEntity.getId());
		note.setNote(noteEntity.getNote());
		note.setNoteUserId(noteEntity.getNoteUserId());
		return note;
	}

	@Override
	public User getUser(UserEntity userEntity) {
		User user = new User();
		user.setId(userEntity.getId());
		user.setName(userEntity.getName());
		
		return user;	
	}

	@Override
	public void saveOrUpdateNote(Note note) {	
		noteDao.saveOrUpdate(note, Constants.NOTE_COLLECTION);		
	}

	@Override
	public void createOrUpdateUser(User user) {	
		userDao.saveOrUpdate(user, Constants.USER_COLLECTION);		
	}
	
}
