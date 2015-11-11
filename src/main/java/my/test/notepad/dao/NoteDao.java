package my.test.notepad.dao;

import java.util.Date;

import org.springframework.stereotype.Component;

import my.test.notepad.entity.Note;
import my.test.notepad.utils.Constants;

@Component
public class NoteDao extends MongoDBGenericDao<Note, Integer> implements INoteDao {

	/*@Override
	public void createNote(Note note) throws Exception {
		Note note1 = this.getByID(note.getId(), Constants.NOTE_COLLECTION);
		if(note1 !=null){
			note.setCreateDate(new Date());
			this.saveOrUpdate(note, Constants.NOTE_COLLECTION);
		}
		
		else{
			throw new Exception("Note with ID already exist");
		}
		
	}

	@Override
	public void updateNote(Note note) throws Exception {
		Note note1 = this.getByID(note.getId(), Constants.NOTE_COLLECTION);
		if(note1 == null){
			throw new Exception("Note with ID doesn't exist");
			
		}
		else{
			note1.setNote(note.getNote());
			note1.setUpdatedby(note.getUpdatedby());
			note1.setUpdateDate(new Date());
			this.saveOrUpdate(note1, Constants.NOTE_COLLECTION);
		}
		
	}

*/
}
