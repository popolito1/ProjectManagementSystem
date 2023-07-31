package com.projectmanagementsystem.services;

import com.projectmanagementsystem.models.WidgetModel;
import com.projectmanagementsystem.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WidgetServiceImpl implements WidgetService{

    private final WidgetRepository widgetRepository;

    @Autowired
    public WidgetServiceImpl( WidgetRepository widgetRepository) {
        this.widgetRepository = widgetRepository;
    }


    @Override
    public WidgetModel saveWidget(WidgetModel widget) {
        return widgetRepository.save(widget);
    }

    @Override
    public List<WidgetModel> getAllWidgets() {
        return widgetRepository.findAll();
    }

    @Override
    public Optional<WidgetModel> getWidgetById(int widgetID) {
        return widgetRepository.findById(widgetID);
    }
}
