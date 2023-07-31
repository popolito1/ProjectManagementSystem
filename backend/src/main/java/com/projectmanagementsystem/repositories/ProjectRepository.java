package com.projectmanagementsystem.repositories;

import com.projectmanagementsystem.models.ProjectModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectModel, Integer> {
}




