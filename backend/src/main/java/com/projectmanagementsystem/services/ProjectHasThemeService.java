package com.projectmanagementsystem.services;

import com.projectmanagementsystem.models.ProjectModel;

import java.util.List;

public interface ProjectHasThemeService {
    public List<ProjectModel> getProjectsByTheme(int theme);
}