package com.projectmanagementsystem.security.services;

import com.projectmanagementsystem.models.ThemeModel;
import com.projectmanagementsystem.repositories.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ThemeServiceImpl implements ThemeService {

    private final ThemeRepository themeRepository;

    @Autowired
    public ThemeServiceImpl(ThemeRepository themeRepository) {
        this.themeRepository = themeRepository;
    }


    @Override
    public ThemeModel saveProject(ThemeModel theme) {
        return themeRepository.save(theme);
    }

    @Override
    public List<ThemeModel> getAllThemes() {
        return themeRepository.findAll();
    }

    @Override
    public Optional<ThemeModel> getThemeById(int themeID) {
        return themeRepository.findById(themeID);
    }
}
