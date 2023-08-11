package com.projectmanagementsystem.security.services;


import com.projectmanagementsystem.models.ThemeModel;

import java.util.List;
import java.util.Optional;

public interface ThemeService {
    public ThemeModel saveProject(ThemeModel theme);
    public List<ThemeModel> getAllThemes();
    public Optional<ThemeModel> getThemeById(int themeID);
}
