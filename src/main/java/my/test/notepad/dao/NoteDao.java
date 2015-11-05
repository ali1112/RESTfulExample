package my.test.notepad.dao;

import org.springframework.stereotype.Component;

import my.test.notepad.entity.Note;

@Component
public class NoteDao extends MongoDBGenericDao<Note, Integer> implements INoteDao {

}
