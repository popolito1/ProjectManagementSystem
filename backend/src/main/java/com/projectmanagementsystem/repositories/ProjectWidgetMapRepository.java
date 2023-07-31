package com.projectmanagementsystem.repositories;

import com.projectmanagementsystem.models.ProjectWidgetMapModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectWidgetMapRepository extends JpaRepository<ProjectWidgetMapModel, Integer> {
}
