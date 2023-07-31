package com.projectmanagementsystem.models;

import jakarta.persistence.*;

@Entity
@Table(name = "projectWidgetMap")
public class ProjectWidgetMapModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projectWidgetMapID")
    private int projectWidgetMapId;

    @ManyToOne
    @JoinColumn(name = "themeID")
    private ThemeModel theme;

    @ManyToOne
    @JoinColumn(name = "projectID")
    private ProjectModel project;

    @ManyToOne
    @JoinColumn(name = "widgetID")
    private WidgetModel widget;

    @Column(name = "numWidgetsUsed")
    private int numWidgetsUsed;

}
