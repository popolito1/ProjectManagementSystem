package com.projectmanagementsystem.controllers;

import com.projectmanagementsystem.models.WidgetModel;
import com.projectmanagementsystem.security.services.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/widgets")
public class WidgetController {
    private final WidgetService widgetService;
    @Autowired
    public WidgetController( WidgetService userService) {
        this.widgetService = userService;
    }

    @PostMapping("/add")
    public String createUser(@RequestBody WidgetModel widget){
        widgetService.saveWidget(widget);
        return "New widget is added";
    }

    @GetMapping
    public List<WidgetModel> getAllUsers() {
        return widgetService.getAllWidgets();
    }

    @GetMapping("/{widgetId}")
    public Optional<WidgetModel> getUserById(@PathVariable int widgetId) {
        return widgetService.getWidgetById(widgetId);
    }
}
