package com.github.baas.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

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

	public  String get_id() { return _id.toHexString(); }
	public void set_id(ObjectId _id) { this._id = _id; }

	public String getProjectName() {
		return projectName;
	}

	public String getTestSuiteName() {
		return testSuiteName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public void setTestSuiteName(String testSuiteName) {
		this.testSuiteName = testSuiteName;
	}

	public void setUid(String uid) {
        this.uid = uid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setHistoryId(String historyId) {
        this.historyId = historyId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public Map<String, Long> getTime() {
        return time;
    }

    public void setTime(Map<String, Long> time) {
        this.time = time;
    }

    public String getFullName() {
        return fullName;
    }

    public String getHistoryId() {
        return historyId;
    }

    public String getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public List<Object> getLabels() {
        return labels;
    }

    public void setLabels(List<Object> labels) {
        this.labels = labels;
    }

    public List<Object> getLinks() {
        return links;
    }

    public void setLinks(List<Object> links) {
        this.links = links;
    }
}
