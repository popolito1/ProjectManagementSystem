package com.projectmanagementsystem.security.services;

import com.projectmanagementsystem.models.ProjectModel;
import com.projectmanagementsystem.repositories.ProjectHasThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectHasThemeServiceImpl implements ProjectHasThemeService{

    private final ProjectHasThemeRepository projectHasThemeRepository;

    @Autowired
    public ProjectHasThemeServiceImpl( ProjectHasThemeRepository projectHasThemeRepository) {
        this.projectHasThemeRepository = projectHasThemeRepository;
    }

    @Override
    public List<ProjectModel> getProjectsByTheme(int theme) {
        return projectHasThemeRepository.findProjectsByThemeId(theme);
    }
}
