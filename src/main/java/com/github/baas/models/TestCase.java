package com.github.baas.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TestCase {

    private String uid;
    private String name;
    private String fullName;
    private String historyId;
    private Map<String, Long> time;
    private String status;
    private String description;
    private List<Map<String, String>> labels;
    private List<Map<String, String>> links;

    public  TestCase(){}

    public TestCase(String uid, String name, String fullName, String historyId, String status, String description) {
        this.uid = uid;
        this.name = name;
        this.fullName = fullName;
        this.historyId = historyId;
        this.status = status;
        this.description = description;
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

    public List<Map<String, String>> getLabels() {
        return labels;
    }

    public void setLabels(List<Map<String, String>> labels) {
        this.labels = labels;
    }

    public List<Map<String, String>> getLinks() {
        return links;
    }

    public void setLinks(List<Map<String, String>> links) {
        this.links = links;
    }
}
