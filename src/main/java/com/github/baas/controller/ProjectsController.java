package com.github.baas.controller;

import com.github.baas.models.Project;
import com.github.baas.repositories.ProjectRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectsController {

    @Autowired
    private ProjectRepository repository;

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

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteProject(@PathVariable ObjectId id) {
        repository.delete(repository.findBy_id(id));
    }

}
