package com.projectmanagementsystem.repositories;

import com.projectmanagementsystem.models.ThemeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThemeRepository extends JpaRepository<ThemeModel, Integer> {
}
