package main.java.controller;


import main.java.models.Projects;
import main.java.repositories.ProjectsRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectsController {

    @Autowired
    private ProjectsRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Projects> getAllProjects() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Projects getProjectById(@PathVariable("id") ObjectId id) {
        return repository.findBy_id(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void ModifyProjectById(@PathVariable("id") ObjectId id, @Valid @RequestBody Projects projects) {
        projects.set_id(id);
        repository.save(projects);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Projects createProject(@Valid @RequestBody Projects projects) {
        projects.set_id(ObjectId.get());
        repository.save(projects);
        return projects;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteProject(@PathVariable ObjectId id) {
        repository.delete(repository.findBy_id(id));
    }

}
