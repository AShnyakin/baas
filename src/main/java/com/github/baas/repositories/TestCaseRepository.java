package com.github.baas.repositories;

import com.github.baas.models.TestCase;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestCaseRepository extends MongoRepository<TestCase, ObjectId> {

    TestCase findBy_id(ObjectId _id);
    TestCase findTestCaseByProjectNameAndTestSuiteName(String projectName, String testSuiteName);
}
