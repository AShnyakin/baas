package com.github.baas.controllers;

import com.github.baas.application.TestCaseService;
import com.github.baas.models.Project;
import com.github.baas.models.TestCase;
import com.github.baas.repositories.ProjectRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectRepository repository;

    @Autowired
    private TestCaseService testCaseService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Project> getAllProjects() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Project getProjectById(@PathVariable("id") ObjectId id) {
        return repository.findBy_id(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void ModifyProjectById(@PathVariable("id") ObjectId id, @Valid @RequestBody Project project) {
        project.set_id(id);
        repository.save(project);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Project createProject(@Valid @RequestBody Project project) {
        project.set_id(ObjectId.get());
        repository.save(project);
        return project;
    }

    @PostMapping("/{projectName}")
    public String sendTestResult(@Valid @RequestBody TestCase testCase, @PathVariable("projectName") String projectName) {
        return  "Test case saved successfully :" + testCase.getFullName();
    }

    @PostMapping("/upload/{projectName}/{testSuite}")
    public Project uploadTestResult(@RequestParam("file") MultipartFile file, @PathVariable("projectName") String projectName,
            @PathVariable("testSuite") String testSuite) throws IOException {
        Project project = new Project();
        project.setProjectName(projectName);
        project.setTestSuiteName(testSuite);
        project.setTestCase(testCaseService.upload(file));
        repository.save(project);
        return  project;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteProject(@PathVariable ObjectId id) {
        repository.delete(repository.findBy_id(id));
    }

}
