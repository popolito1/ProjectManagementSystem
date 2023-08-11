package com.projectmanagementsystem.security.services;


import com.projectmanagementsystem.models.WidgetModel;

import java.util.List;
import java.util.Optional;

public interface WidgetService {
    public WidgetModel saveWidget(WidgetModel widget);
    public List<WidgetModel> getAllWidgets();
    public Optional<WidgetModel> getWidgetById(int widgetID);
}
