package com.projectmanagementsystem.models;

import jakarta.persistence.*;

@Entity
@Table(name = "widget")

public class WidgetModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "widgetID")
    private int widgetId;

    @ManyToOne
    @JoinColumn(name = "themeID")
    private ThemeModel themeID;

    @Column(name = "name")
    private String name;
}
