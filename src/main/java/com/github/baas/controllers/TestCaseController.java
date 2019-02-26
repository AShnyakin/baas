package com.github.baas.controllers;

import com.github.baas.application.TestCaseService;
import com.github.baas.infrstructure.json.Mapper;
import com.github.baas.models.TestCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


@RestController
@RequestMapping("/testCases")
@Profile("production")
public class TestCaseController {

    @Autowired
    private TestCaseService testCaseService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<TestCase> getAllTestCases() {
        return testCaseService.findAll();
    }

    @GetMapping("/{projectName}/{testSuite}")
    public TestCase getTestCaseByProjectName(@PathVariable("projectName") String projectName, @PathVariable("testSuite") String testSuiteName){
        return  testCaseService.findByProjectAndTestSuiteName(projectName, testSuiteName);
    }

    @PostMapping("/upload/{projectName}/{testSuite}")
    public TestCase uploadTestResult(@RequestParam("file") MultipartFile file, @PathVariable("projectName") String projectName,
            @PathVariable("testSuite") String testSuiteName) throws IOException {
		InputStream inputStream =  file.getInputStream();
		TestCase testCase = Mapper.objectMapper.readValue(inputStream, TestCase.class);

		testCase.setProjectName(projectName);
		testCase.setTestSuiteName(testSuiteName);
        return testCaseService.save(testCase);
    }
}
