package com.github.baas.repositories.migrations;

import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;

@ChangeLog
public class MongoMigrations {

    @ChangeSet(order = "001", id = "createTestCollection", author = "Alexey")
    public void createTestCollection(DB db){
        db.createCollection("testCases", new BasicDBObject());
    }

}
