package com.example.myapp.services;

import com.example.myapp.models.Widget;
import com.example.myapp.repositories.WidgetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class WidgetService {

  @Autowired
  WidgetRepository widgetRepository;

  List<Widget> widgets = new ArrayList<Widget>();
  {
    widgets.add(new Widget(123, "HTML", "Widget 1", "topic123"));
    widgets.add(new Widget(234, "YOU_TUBE", "Widget 2", "topic123"));
    widgets.add(new Widget(345, "SLIDE", "Widget 3", "topic123"));
    widgets.add(new Widget(456, "HEADER", "Widget 4", "topic123"));
    widgets.add(new Widget(567, "HEADING", "Widget A", "topic234"));
    widgets.add(new Widget(678, "PARAGRAPH", "Widget B", "topic234"));
  }

  public List<Widget> findWidgetsForTopic(String tid) {
    return widgetRepository.findWidgetByTopicId(tid);
  }

  public List<Widget> findAllWidgets() {
    return (List<Widget>) widgetRepository.findAll();
  }

  public Widget findWidgetById(Integer widgetId) {
    return widgetRepository.findById(widgetId).get();
  }

  public Widget createWidget(Widget widget) {
    return widgetRepository.save(widget);
}

  public void deleteWidget(Integer widgetId) {
    widgetRepository.deleteById(widgetId);
  }


  public Widget updateWidget(Integer widgetId, Widget newWidget) {
    Widget widget = widgetRepository.findById(widgetId).get();
    widget = newWidget;
    return widgetRepository.save(widget);
  }
}
