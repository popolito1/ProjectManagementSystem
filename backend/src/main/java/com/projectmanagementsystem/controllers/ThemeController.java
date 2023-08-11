package com.projectmanagementsystem.controllers;

import com.projectmanagementsystem.models.ThemeModel;
import com.projectmanagementsystem.security.services.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/themes")
public class ThemeController {
    private final ThemeService themeService;
    @Autowired
    public ThemeController( ThemeService themeService) {
        this.themeService = themeService;
    }

    @PostMapping("/add")
    public String createUser(@RequestBody ThemeModel theme){
        themeService.saveProject(theme);
        return "New theme is added";
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
