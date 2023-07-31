package com.projectmanagementsystem.services;

import com.projectmanagementsystem.models.ProjectModel;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    public ProjectModel saveProject(ProjectModel project);
    public List<ProjectModel> getAllProjects();
    public Optional<ProjectModel> getProjectById(int projectID);
}

