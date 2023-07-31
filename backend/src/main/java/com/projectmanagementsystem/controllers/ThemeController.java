package com.projectmanagementsystem.controllers;

import com.projectmanagementsystem.models.ProjectModel;
import com.projectmanagementsystem.models.ThemeModel;
import com.projectmanagementsystem.services.ProjectService;
import com.projectmanagementsystem.services.ThemeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/themes")
public class ThemeController {
    private final ThemeService themeService;

    public ThemeController( ThemeService themeService) {
        this.themeService = themeService;
    }

    @PostMapping("/add")
    public String createUser(@RequestBody ThemeModel theme){
        themeService.saveProject(theme);
        return "New project is added";
    }

    @GetMapping
    public List<ThemeModel> getAllProjects() {
        return themeService.getAllThemes();
    }

    @GetMapping("/{themeId}")
    public Optional<ThemeModel> getThemeById(@PathVariable int themeId) {
        return themeService.getThemeById(themeId);
    }

}
