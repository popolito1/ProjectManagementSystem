package com.projectmanagementsystem.models;

import jakarta.persistence.*;

@Entity
@Table(name = "project")
public class ProjectModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projectID")
    private int projectId;

    @Column(name = "name")
    private String name;

    @Column(name = "date")
    private String date;

    @ManyToOne
    @JoinColumn(name = "userID")
    private UserModel user;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private ProjectState state;

}
