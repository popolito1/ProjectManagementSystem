package com.projectmanagementsystem.services;

import com.projectmanagementsystem.models.ProjectModel;
import com.projectmanagementsystem.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl( ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public ProjectModel saveProject(ProjectModel project){
        return projectRepository.save(project);
    }

    @Override
    public List<ProjectModel> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Optional<ProjectModel> getProjectById(int projectID){
        return projectRepository.findById(projectID);
    }

}




