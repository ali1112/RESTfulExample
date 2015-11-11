package my.test.notepad.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.spring.Autowire;

import my.test.notepad.dao.INoteDao;
import my.test.notepad.dao.IUserDao;
import my.test.notepad.dao.NoteDao;
import my.test.notepad.dao.UserDao;
import my.test.notepad.entity.Note;
import my.test.notepad.entity.User;
import my.test.notepad.lib.ErrorCode;
import my.test.notepad.lib.exception.JsonParsingException;
import my.test.notepad.lib.exception.NoteException;
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
		note.setCreateDate(noteEntity.getCreateDate());
		note.setUpdateDate(noteEntity.getUpdateDate());
		return note;
	}

	@Override
	public User getUser(UserEntity userEntity) {
		User user = new User();
		user.setId(userEntity.getUserId());
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

	@Override
	public void createNote(Note note) throws NoteException {
		Note note1 = noteDao.getByID(note.getId(), Constants.NOTE_COLLECTION);
		if(note1 ==null){
			note.setCreateDate(new Date());
			noteDao.saveOrUpdate(note, Constants.NOTE_COLLECTION);
		}
		
		else{
			throw new NoteException(ErrorCode.NOTE_EXISTS, "Note with ID already exist");
		}
		
	}

	@Override
	public void updateNote(Integer noteId, String note) throws NoteException {
		Note note1 = noteDao.getByID(noteId, Constants.NOTE_COLLECTION);
		if(note1 == null){
			
			throw new NoteException(ErrorCode.NOTE_NOT_FOUND, "Note with ID "+noteId+" doesn't exist");
			
		}
		else{
			
			ObjectMapper mapper = new ObjectMapper();
			NoteEntity noteEntity;
			try {
				noteEntity = mapper.readValue(note, NoteEntity.class);
			} catch (JsonParseException e) {
				e.printStackTrace();
				throw new JsonParsingException();
			} catch (JsonMappingException e) {
				e.printStackTrace();
				throw new JsonParsingException();

			} catch (IOException e) {
				e.printStackTrace();
				throw new JsonParsingException();

			}
			note1.setNote(noteEntity.getNote());
			note1.setUpdateDate(new Date());
			noteDao.saveOrUpdate(note1, Constants.NOTE_COLLECTION);
		}
				
	}	
}
