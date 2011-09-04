package no.rih.mongodb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import no.rih.dao.DynamicModelDao;

import org.apache.log4j.Logger;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

public class MongoCollectionDao implements DynamicModelDao {
	
	private final static Logger log = Logger.getLogger(MongoCollectionDao.class);	
	
	private DB db;
	private String collectionName;
	private DBCollection dbCollection;

	public void setDb(DB db) {
		this.db = db;
	}

	public void setCollectionName(String collectionName) {
		log.debug("Setting collection name: " + collectionName);
		this.collectionName = collectionName;
	}

	@PostConstruct
	public void init() {
		log.debug("Initializing collection: " + collectionName);
		dbCollection = db.getCollection(collectionName);
	}

	@Override
	public void create(String entity) {
		DBObject dbObject = getDbObject(entity);
		dbCollection.insert(dbObject);
	}

	private DBObject getDbObject(String entity) {
		DBObject dbObject = (DBObject) JSON.parse(entity);
		return dbObject;
	}

	@Override
	public void create(String entity, Serializable id) {
		DBObject dbObject = getDbObject(entity);
		dbObject.put("_id", id);
		dbCollection.insert(dbObject);
	}

	@Override
	public void update(String entity) {
		DBObject dbObject = getDbObject(entity);
		dbCollection.save(dbObject);
	}

	@Override
	public String findById(Serializable id) {
		DBObject dbObject = dbCollection.findOne(id);
		return JSON.serialize(dbObject);
	}
	
	@Override
	public String findAll() {
		List<DBObject> dbObjects = new ArrayList<DBObject>();
		DBCursor dbCursor = dbCollection.find();

        while(dbCursor.hasNext()) {
            dbObjects.add(dbCursor.next());
        }
		
		return JSON.serialize(dbObjects);
	}
	
	@Override
	public void delete(String entity) {
		DBObject dbObject = getDbObject(entity);
		dbCollection.remove(dbObject);
	}

}