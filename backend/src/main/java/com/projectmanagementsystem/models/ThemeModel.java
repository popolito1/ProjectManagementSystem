package com.projectmanagementsystem.models;

import jakarta.persistence.*;

@Entity
@Table(name = "theme")
public class ThemeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "themeID")
    private int theme;

    @Column(name = "name")
    private String name;

}
