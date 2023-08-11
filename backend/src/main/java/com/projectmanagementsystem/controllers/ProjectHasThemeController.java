package com.projectmanagementsystem.controllers;

import com.projectmanagementsystem.models.ProjectModel;
import com.projectmanagementsystem.security.services.ProjectHasThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("api/project-has-theme")
public class ProjectHasThemeController {
    private final ProjectHasThemeService projectHasThemeService;
    @Autowired
    public ProjectHasThemeController( ProjectHasThemeService projectHasThemeService) {
        this.projectHasThemeService = projectHasThemeService;
    }

    @GetMapping("/{themeId}")
    public List<ProjectModel> getThemeById(@PathVariable int theme) {
        return projectHasThemeService.getProjectsByTheme(theme);
    }


}
