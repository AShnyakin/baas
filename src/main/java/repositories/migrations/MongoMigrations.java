package main.java.repositories.migrations;

import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.client.model.CreateCollectionOptions;

@ChangeLog
public class MongoMigrations {

    @ChangeSet(order = "001", id = "createTestCollection", author = "Alexey")
    public void createTestCollection(DB db){
        db.createCollection("projects", new BasicDBObject());
    }

}
