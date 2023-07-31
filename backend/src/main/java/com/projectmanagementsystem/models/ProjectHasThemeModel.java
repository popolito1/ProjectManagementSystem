package com.projectmanagementsystem.models;

import jakarta.persistence.*;

@Entity
@Table(name = "projectHasThemes")
public class ProjectHasThemeModel {
    @Id
    @ManyToOne
    @JoinColumn(name = "projectID")
    private ProjectModel project;

    @Id
    @ManyToOne
    @JoinColumn(name = "themeID")
    private ThemeModel theme;
}
