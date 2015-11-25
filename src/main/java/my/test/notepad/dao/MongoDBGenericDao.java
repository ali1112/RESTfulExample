package my.test.notepad.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.mongodb.MongoException;
import com.sun.jersey.api.core.InjectParam;

import my.test.notepad.lib.ErrorCode;
import my.test.notepad.lib.exception.NoteException;

@Component
public abstract class MongoDBGenericDao<T, ID extends Serializable> implements
	IDao<T, ID>
{
	@Autowired
    @Qualifier("mongoTemplate")
    MongoOperations mongoOperations;

    @SuppressWarnings("unchecked")
    Class<T> type = (Class<T>) ((ParameterizedType) getClass()
            .getGenericSuperclass()).getActualTypeArguments()[0];

    
    public T saveOrUpdate(T pobject, String collection) {
        // TODO do we really need to check this before every save?
        // one more call to Mongo DB
        createCollection(collection);

        /*
         * If the document does not contain an _id field, then the save() method
         * performs an insert. During the operation, mongod will add to the
         * document the _id field and assign it a unique ObjectId.
         * 
         * If the document contains an _id field, then the save() method
         * performs an upsert, querying the collection on the _id field. If a
         * document does not exist with the specified _id value, the save()
         * method performs an insert. If a document exists with the specified
         * _id value, the save() method performs an update that replaces all
         * fields in the existing document with the fields from the document.
         */
        try {
            mongoOperations.save(pobject, collection);
        } catch (DataAccessResourceFailureException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        /*
         * pobject is already populated with id (in case of insert)
         */
        return pobject;
    }

    
    public T getByID(String id, String collection) {
        return mongoOperations.findById(id, type, collection);
    }
    
    public T getByID(Long id, String collection) {
        return mongoOperations.findById(id, type, collection);
    }

    
    public List<T> getAll(String collection) {
        return mongoOperations.findAll(type, collection);
    }

    
    public boolean delete(String id, String collection) {
        T obj = mongoOperations.findById(id, type, collection);
        if (obj != null) {
            mongoOperations.remove(obj);
            return true;
        }
        return false;
    }
    
    public boolean delete(Long id, String collection) {
      /*  T obj = mongoOperations.findById(id, type, collection);
        if (obj != null) {
            mongoOperations.remove(obj);
            return true;
        }
        return false;*/

		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));
		mongoOperations.remove(query, collection);
		
	    
	    return true;
    	
    }
    
    public boolean deleteAll(String field, List<Long> ids, String collection) {
    	Query query = new Query();
		query.addCriteria(Criteria.where(field).in(ids));
	    mongoOperations.remove(query, collection);
        return false;
    }
    
    public void createCollection(String collection) {
        if (!mongoOperations.collectionExists(collection)) {
            mongoOperations.createCollection(collection);
           // createIndex(collection);
        }

    }
    
    
    public T insert(T pobject, String collection) {
    	createCollection(collection);
    	try {
    	    mongoOperations.insert(pobject, collection);
    	} catch(MongoException.DuplicateKey e) {
    		
    	}
		return pobject;
    	
    }

    public <K> void removeOne( String field, K value, String collection) {
    	try {
    		Query query = new Query();
    		query.addCriteria(Criteria.where(field).is(value));
    	    mongoOperations.remove(query, collection);
    	} catch(MongoException.DuplicateKey e) {
    		
    	}
    	
    }

    
    public <K> void removeAll( String field, List<K> value, String collection) {
    	createCollection(collection);
    	try {
    		Query query = new Query();
    		query.addCriteria(Criteria.where(field).all(value));
    	    mongoOperations.remove(query, collection);
    	} catch(MongoException.DuplicateKey e) {
    		
    	}
    	
    }

    protected void createIndex(String collection) {
        mongoOperations.indexOps(collection).ensureIndex(new Index());
//            mongoOperations.indexOps(collection).ensureIndex(new Index("couponId", Sort.Direction.DESC));
        mongoOperations.indexOps(collection).ensureIndex(new Index());
        mongoOperations.indexOps(collection).ensureIndex(new Index());
    }
}
