package com.github.baas;

import com.github.baas.application.TestCaseService;
import com.github.baas.models.TestCase;
import com.github.baas.utils.JsonDataLoader;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.hamcrest.core.Is.is;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MongoDbSpringIntegrationTest {

	@Autowired
	private TestCaseService testCaseService;

	private TestCase testCase;
	private JsonDataLoader jsonDataLoader = new JsonDataLoader();

	@BeforeEach
	public void initPage() {
		Optional<TestCase> testCaseOptional = jsonDataLoader.loadEntity("/com/github/baas/testdata/test-case-example", TestCase.class);
		testCase = testCaseOptional.get();
		testCase.setProjectName("Test-Project");
		testCase.setTestSuiteName("Test-Suite");
	}

	@DisplayName("MongoDb integration test")
	@Test
	public void checkSavedTestCase(@Autowired MongoTemplate mongoTemplate) {
		testCaseService.save(testCase);
		BasicQuery query = new BasicQuery("{ projectName : 'Test-Project' }");

		Assert.assertThat("Test case was saved",
				mongoTemplate.findOne(query, TestCase.class).getProjectName(), is("Test-Project"));
	}
}