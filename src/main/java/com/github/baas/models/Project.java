package com.github.baas.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "projects")
public class Project {

    @Id
    private ObjectId _id;

    private String projectName;
    private String testSuiteName;
    private TestCase testCase;

    public Project() {}

    public Project(ObjectId _id, String projectName, String testSuiteName, TestCase testCase) {
        this._id = _id;
        this.projectName = projectName;
        this.testSuiteName = testSuiteName;
        this.testCase = testCase;
    }

    public  String get_id() { return _id.toHexString(); }
    public void set_id(ObjectId _id) { this._id = _id; }

    public String getProjectName() {
        return projectName;
    }

    public String getTestSuiteName() {
        return testSuiteName;
    }

    public TestCase getTestCase() {
        return testCase;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setTestSuiteName(String testSuiteName) {
        this.testSuiteName = testSuiteName;
    }

    public void setTestCase(TestCase testCase) {
        this.testCase = testCase;
    }
}
