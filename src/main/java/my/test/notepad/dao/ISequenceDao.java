package my.test.notepad.dao;

import my.test.notepad.entity.Sequence;

public interface ISequenceDao extends IDao<Sequence, String> {

	public long getNextSequenceId(String key);
}
