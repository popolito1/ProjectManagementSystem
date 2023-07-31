package com.projectmanagementsystem.controllers;

import com.projectmanagementsystem.models.ProjectHasThemeModel;
import com.projectmanagementsystem.models.ProjectModel;
import com.projectmanagementsystem.services.ProjectHasThemeService;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/project-has-theme")
public class ProjectHasThemeController {
    private final ProjectHasThemeService projectHasThemeService;

    public ProjectHasThemeController( ProjectHasThemeService projectHasThemeService) {
        this.projectHasThemeService = projectHasThemeService;
    }

    @GetMapping("/{themeId}")
    public List<ProjectModel> getThemeById(@PathVariable int themeId) {
        return projectHasThemeService.getProjectsByTheme(themeId);
    }


}
