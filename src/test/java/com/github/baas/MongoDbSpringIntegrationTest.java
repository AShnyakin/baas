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
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

import static org.hamcrest.core.Is.is;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MongoDbSpringIntegrationTest {

	@Autowired
	private TestCaseService testCaseService;

	private TestCase testCase;
	private JsonDataLoader jsonDataLoader = new JsonDataLoader();

	@BeforeEach
	public void initPage() throws IOException {
		testCase = jsonDataLoader.loadEntity("/com/github/baas/testdata/test-case-example", TestCase.class);
		testCase.setProjectName("Test-Project");
		testCase.setTestSuiteName("Test-Suite");
	}

	@DisplayName("MongoDb integration test")
	@Test
	public void checkSavedTestCase(@Autowired MongoTemplate mongoTemplate) {
		testCaseService.save(testCase);

		Assert.assertThat("Test case was saved",
				mongoTemplate.findAll(TestCase.class, "testCases").get(0).getProjectName(), is("Test-Project"));
	}
}