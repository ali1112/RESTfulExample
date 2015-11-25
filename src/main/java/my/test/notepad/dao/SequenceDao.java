package my.test.notepad.dao;

import java.util.List;

import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import my.test.notepad.entity.Sequence;

@Component
public class SequenceDao extends MongoDBGenericDao<Sequence, String> implements ISequenceDao {

	public long getNextSequenceId(String key) {
		
		  //get sequence id
		  Query query = new Query(Criteria.where("_id").is(key));

		  //increase sequence id by 1
		  Update update = new Update();
		  update.inc("seq", 1);

		  //return new increased id
		  FindAndModifyOptions options = new FindAndModifyOptions();
		  options.returnNew(true);

		  //this is the magic happened.
		  Sequence seqId = 
	            mongoOperations.findAndModify(query, update, options, Sequence.class);

		  return seqId.getSeq();

		}

	
}
