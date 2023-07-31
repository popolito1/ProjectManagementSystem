package com.projectmanagementsystem.models;

import java.io.Serializable;

public class ProjectHasThemeIdClass implements Serializable {
    private ThemeModel theme;

    private ProjectModel project;

    // default constructor

    public ProjectHasThemeIdClass(ThemeModel theme, ProjectModel project) {
        this.project = project;
        this.theme = theme;
    }

}
