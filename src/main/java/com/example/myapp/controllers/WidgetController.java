package com.example.myapp.controllers;

import com.example.myapp.models.Widget;
import com.example.myapp.services.WidgetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class WidgetController {


  @Autowired
  WidgetService service = new WidgetService();

  @GetMapping("/api/topics/{tid}/widgets")
  public List<Widget> findWidgetsForTopic(
          @PathVariable("tid") String topicId) {
    return service.findWidgetsForTopic(topicId);
  }

  @GetMapping("/api/widgets")
  public List<Widget> findAllWidgets() {
    return service.findAllWidgets();
  }
  @GetMapping("/api/widgets/{wid}")
  public Widget findWidgetById(
          @PathVariable("wid") Integer widgetId) {
    return service.findWidgetById(widgetId);
  }

  @PostMapping("/api/topics/{topicId}/widgets")
  public Widget createWidgetForTopic(
          @PathVariable("topicId") String topicId,
          @RequestBody Widget widget) {
    widget.setTopicId(topicId);
    return service.createWidget(widget);
  }

  @DeleteMapping("/api/widgets/{wid}")
  public void deleteWidget(
          @PathVariable("wid") Integer widgetId) {
    service.deleteWidget(widgetId);
  }
  @PutMapping("/api/widgets/{wid}")
  public Widget updateWidget(
          @PathVariable("wid") Integer widgetId, @RequestBody Widget newWidget) {
    return service.updateWidget(widgetId, newWidget);
  }
}
