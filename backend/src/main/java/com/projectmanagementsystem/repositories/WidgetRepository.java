package com.projectmanagementsystem.repositories;

import com.projectmanagementsystem.models.WidgetModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WidgetRepository extends JpaRepository<WidgetModel, Integer> {
}
