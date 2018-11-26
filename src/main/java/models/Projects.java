package main.java.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Projects {

    @Id
    private ObjectId _id;

    private String name;
    private String testSuite;
    private String testCase;

    public Projects() {}

    public Projects(ObjectId _id, String name, String testSuite, String testCase) {
        this._id = _id;
        this.name = name;
        this.testSuite = testSuite;
        this.testCase = testCase;
    }

    public  String get_id() { return _id.toHexString(); }
    public void set_id(ObjectId _id) { this._id = _id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getTestSuite() { return name; }
    public void setTestSuite(String testSuite) { this.name = name; }

    public String getTestCase() { return name; }
    public void setTestCase(String testCase) { this.name = name; }

}
