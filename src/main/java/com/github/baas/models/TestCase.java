package com.github.baas.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@Document(value = "testCases")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestCase {

	@Id
	private ObjectId _id;

	private String projectName;
	private String testSuiteName;

    private String uid;
    private String name;
    private String fullName;
    private String historyId;
    private Map<String, Long> time;
    private String status;
    private String description;
    private List<Object> labels;
    private List<Object> links;

    public  TestCase(){}

    public TestCase(ObjectId _id, String projectName, String testSuiteName,
					String uid, String name, String fullName, String historyId, String status, String description) {
		this._id = _id;
		this.projectName = projectName;
		this.testSuiteName = testSuiteName;
        this.uid = uid;
        this.name = name;
        this.fullName = fullName;
        this.historyId = historyId;
        this.status = status;
        this.description = description;
    }
}
