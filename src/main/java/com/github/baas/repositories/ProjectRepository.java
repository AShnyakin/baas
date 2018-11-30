package com.github.baas.repositories;

import com.github.baas.models.Project;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProjectRepository extends MongoRepository<Project, String> {

    Project findBy_id(ObjectId _id);

}
