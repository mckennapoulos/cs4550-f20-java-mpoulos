package com.example.myapp.controllers;

import com.example.myapp.models.Widget;
import com.example.myapp.services.WidgetService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class WidgetController {
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
          @PathVariable("wid") String widgetId) {
    return service.findWidgetById(widgetId);
  }
  @PostMapping("/api/topics/{topicId}/widgets")
  public Widget createWidgetForTopic(
          @PathVariable("topicId") String topicId,
          @RequestBody Widget widget) {
    widget.setTopicId(topicId);
    return service.createWidget(widget);
  }
  @PostMapping("/api/widgets")
  public Widget createWidget(
          @RequestBody Widget widget) {
    return service.createWidget(widget);
  }
  @DeleteMapping("/api/widgets/{wid}")
  public Integer deleteWidget(
          @PathVariable("wid") String widgetId) {
    return service.deleteWidget(widgetId);
  }
  @PutMapping("/api/widgets/{wid}")
  public Integer updateWidget(
          @PathVariable("wid") String widgetId, @RequestBody Widget newWidget) {
    return service.updateWidget(widgetId, newWidget);
  }
}
