package com.github.baas.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.baas.application.TestCaseService;
import com.github.baas.models.TestCase;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


@RestController
@RequestMapping("/testCases")
public class TestCaseController {

    @Autowired
    private TestCaseService testCaseService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<TestCase> getAllTestCases() {
        return testCaseService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public TestCase getTestCaseById(@PathVariable("id") ObjectId id) {
        return testCaseService.findBy_id(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void ModifyTestCaseById(@PathVariable("id") ObjectId id, @Valid @RequestBody TestCase testCase) {
		testCase.set_id(id);
		testCaseService.save(testCase);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public TestCase createProject(@Valid @RequestBody TestCase testCase) {
		testCase.set_id(ObjectId.get());
		testCaseService.save(testCase);
        return testCase;
    }

    @GetMapping("/{projectName}/{testSuite}")
    public TestCase getTestCaseByProjectName(@PathVariable("projectName") String projectName, @PathVariable("testSuite") String testSuiteName){
        return  testCaseService.findByProjectAndTestSuiteName(projectName, testSuiteName);
    }

    @PostMapping("/upload/{projectName}/{testSuite}")
    public TestCase uploadTestResult(@RequestParam("file") MultipartFile file, @PathVariable("projectName") String projectName,
            @PathVariable("testSuite") String testSuiteName) throws IOException {
		InputStream inputStream =  file.getInputStream();
		ObjectMapper mapper = new ObjectMapper();
		TestCase testCase = mapper.readValue(inputStream, TestCase.class);

		testCase.setProjectName(projectName);
		testCase.setTestSuiteName(testSuiteName);
        return testCaseService.save(testCase);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteTestCase(@PathVariable ObjectId id) {
		testCaseService.delete(id);
    }

}
