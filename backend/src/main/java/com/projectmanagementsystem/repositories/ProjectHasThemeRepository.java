package com.projectmanagementsystem.repositories;

import com.projectmanagementsystem.models.ProjectHasThemeModel;
import com.projectmanagementsystem.models.ProjectModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectHasThemeRepository extends JpaRepository<ProjectHasThemeModel, Integer> {
    @Query("SELECT pt.project FROM ProjectHasThemeModel pt WHERE pt.theme.theme = :themeID")
    List<ProjectModel> findProjectsByThemeId(@Param("themeId") int themeID);
}
