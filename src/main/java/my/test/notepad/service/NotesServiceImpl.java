package my.test.notepad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sun.jersey.api.spring.Autowire;

import my.test.notepad.dao.INoteDao;
import my.test.notepad.dao.IUserDao;
import my.test.notepad.dao.NoteDao;
import my.test.notepad.dao.UserDao;
import my.test.notepad.entity.Note;
import my.test.notepad.entity.User;
import my.test.notepad.resourceEntity.NoteEntity;
import my.test.notepad.resourceEntity.UserEntity;
import my.test.notepad.utils.Constants;

@Component
public class NotesServiceImpl implements INotesService {

	@Autowired
	INoteDao noteDao;
	
	@Autowired
	IUserDao userDao;
	
	

	@Override
	public boolean saveUpdateNote(int noteId, int userId, String content) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Note getNote(int noteId) {
		
		Note note1 = noteDao.getByID((noteId), Constants.NOTE_COLLECTION);
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
		user.setUserName(userEntity.getUserName());
		
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

	public INoteDao getNoteDao() {
		return noteDao;
	}

	public void setNoteDao(NoteDao noteDao) {
		this.noteDao = noteDao;
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User getUser(Integer userId) {
		User user = userDao.getByID(userId, Constants.USER_COLLECTION);
		return user;
	}
	
	
}
