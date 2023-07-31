package com.projectmanagementsystem.services;

import com.projectmanagementsystem.repositories.ProjectWidgetMapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectWidgetMapServiceImpl implements ProjectWidgetMapService{
    private final ProjectWidgetMapRepository projectWidgetMapRepository;

    @Autowired
    public ProjectWidgetMapServiceImpl(  ProjectWidgetMapRepository projectWidgetMapRepository) {
        this.projectWidgetMapRepository = projectWidgetMapRepository;
    }
}
