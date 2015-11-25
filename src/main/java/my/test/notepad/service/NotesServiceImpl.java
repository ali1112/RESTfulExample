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

import my.test.notepad.dao.INoteBookDao;
import my.test.notepad.dao.INoteDao;
import my.test.notepad.dao.ISequenceDao;
import my.test.notepad.dao.IUserDao;
import my.test.notepad.dao.NoteDao;
import my.test.notepad.dao.UserDao;
import my.test.notepad.entity.Note;
import my.test.notepad.entity.NoteBook;
import my.test.notepad.entity.User;
import my.test.notepad.lib.ErrorCode;
import my.test.notepad.lib.exception.JsonParsingException;
import my.test.notepad.lib.exception.NoteException;
import my.test.notepad.resourceEntity.NoteBookEntity;
import my.test.notepad.resourceEntity.NoteEntity;
import my.test.notepad.resourceEntity.UserEntity;
import my.test.notepad.utils.Constants;

@Component
public class NotesServiceImpl implements INotesService {

	@Autowired
	INoteDao noteDao;
	
	@Autowired
	INoteBookDao noteBookDao;
	
	@Autowired
	IUserDao userDao;
	
	@Autowired
	ISequenceDao sequenceDao;
	
	private static final String NOTE_SEQ_KEY = "note";
	private static final String NOTEBOOK_SEQ_KEY = "noteBook";


	@Override
	public boolean saveUpdateNote(int noteId, int userId, String content) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Note getNote(Long noteId) {
		
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
		note.setNoteId(noteEntity.getNoteId());
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
	public User getUser(Long userId) {
		User user = userDao.getByID(userId, Constants.USER_COLLECTION);
		return user;
	}

	@Override
	public Note createNote(Note note) throws NoteException {
			note.setNoteId(sequenceDao.getNextSequenceId(NOTE_SEQ_KEY));
			note.setCreateDate(new Date());
			noteDao.saveOrUpdate(note, Constants.NOTE_COLLECTION);
			return note;
	}

	@Override
	public void updateNote(Long noteId, String note) throws NoteException {
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

	@Override
	public NoteBook createNoteBook(NoteBook noteBook) throws NoteException {
		noteBook.setNoteBookId(sequenceDao.getNextSequenceId(NOTEBOOK_SEQ_KEY));
		noteBook.setCreateDate(new Date());
			noteBookDao.saveOrUpdate(noteBook, Constants.NOTEBOOK_COLLECTION);
			return noteBook;
	}

	
	@Override
	public NoteEntity getNoteEntity(Note note) {
		NoteEntity noteEntity = new NoteEntity();
		noteEntity.setNoteId(note.getNoteId());
		noteEntity.setNote(note.getNote());
		noteEntity.setNoteUserId(note.getNoteUserId());
		noteEntity.setCreateDate(note.getCreateDate());
		noteEntity.setUpdateDate(note.getUpdateDate());
		noteEntity.setNoteBookId(note.getNoteBookId());

		return noteEntity;
	}

	@Override
	public NoteBook getNoteBook(NoteBookEntity noteBookEntity) {
		NoteBook noteBook = new NoteBook();
		noteBook.setNoteBookId(noteBookEntity.getNoteBookId());
		noteBook.setNoteIds(noteBookEntity.getNoteIds());
		noteBook.setNoteBookUserId(noteBookEntity.getNoteBookUserId());
		return noteBook;
	}

	@Override
	public NoteBookEntity getNoteBookEntity(NoteBook noteBook) {
		NoteBookEntity noteBookEntity = new NoteBookEntity();
		noteBookEntity.setNoteBookId(noteBook.getNoteBookId());
		noteBookEntity.setNoteIds(noteBook.getNoteIds());
		noteBookEntity.setNoteBookUserId(noteBook.getNoteBookUserId());
		noteBookEntity.setCreateDate(noteBook.getCreateDate());
		noteBookEntity.setUpdateDate(noteBook.getUpdateDate());
		
		return noteBookEntity;
	}

	@Override
	public void deleteNote(Long noteId) throws NoteException {
		try {
			noteDao.delete(noteId, Constants.NOTE_COLLECTION);
		} 
		catch (NoteException e) {
			throw new NoteException(ErrorCode.NOTE_DELETE_EROOR, "Error while deleting Note");
		}
		catch (Exception e) {
			throw new NoteException(ErrorCode.UNKNOWN_EROOR, "Unknown Error");
		}	
	}

	@Override
	public void deleteNoteBook(Long noteBookId) throws NoteException {
		try {
			List<Long> noteIds = noteBookDao.getByID(noteBookId,Constants.NOTEBOOK_COLLECTION).getNoteIds();
			noteBookDao.deleteAll("id", noteIds, Constants.NOTE_COLLECTION);
			noteBookDao.delete(noteBookId, Constants.NOTEBOOK_COLLECTION);
		} 
		catch (NoteException e) {
			throw new NoteException(ErrorCode.NOTE_DELETE_EROOR, "Error while deleting Note");
		}
		catch (Exception e) {
			throw new NoteException(ErrorCode.UNKNOWN_EROOR, "Unknown Error");
		}	
	}
	
	@Override
	public void deleteNotes(List<Long> noteIds) {
		noteDao.deleteAll("id", noteIds, Constants.NOTE_COLLECTION);			
	}	
}
