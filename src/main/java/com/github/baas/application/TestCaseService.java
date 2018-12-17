package com.github.baas.application;

import com.github.baas.models.TestCase;
import com.github.baas.repositories.TestCaseRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestCaseService {

	private final TestCaseRepository testCaseRepository;

	@Autowired
	public TestCaseService(TestCaseRepository testCaseRepository) {
		this.testCaseRepository = testCaseRepository;
	}

	public List<TestCase> findAll() {
		return testCaseRepository.findAll();
	}

	public TestCase findBy_id(ObjectId id) {
		return testCaseRepository.findBy_id(id);
	}

	public TestCase save(TestCase testCase) {
		return testCaseRepository.save(testCase);
	}

	public TestCase findByProjectAndTestSuiteName(String projectName, String testSuiteName) {
		return testCaseRepository.findTestCaseByProjectNameAndTestSuiteName(projectName, testSuiteName);
	}

	public void delete(ObjectId _id) {
		testCaseRepository.deleteById(_id);
	}
}
