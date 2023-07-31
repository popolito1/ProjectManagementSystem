package com.projectmanagementsystem.controllers;

import com.projectmanagementsystem.models.ProjectModel;
import com.projectmanagementsystem.services.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/projects")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController( ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/add")
    public String createUser(@RequestBody ProjectModel project){
        projectService.saveProject(project);
        return "New project is added";
    }

    @GetMapping
    public List<ProjectModel> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/{projectId}")
    public Optional<ProjectModel> getProjectById(@PathVariable int projectId) {
        return projectService.getProjectById(projectId);
    }
}





