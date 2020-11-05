package com.example.myapp.services;

import com.example.myapp.models.Widget;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


public class WidgetService {
  List<Widget> widgets = new ArrayList<Widget>();

  {
    widgets.add(new Widget("123", "HTML", "Widget 1", "topic123"));
    widgets.add(new Widget("234", "YOU_TUBE", "Widget 2", "topic123"));
    widgets.add(new Widget("345", "SLIDE", "Widget 3", "topic123"));
    widgets.add(new Widget("456", "HEADER", "Widget 4", "topic123"));
    widgets.add(new Widget("567", "HEADING", "Widget A", "topic234"));
    widgets.add(new Widget("678", "PARAGRAPH", "Widget B", "topic234"));
  }

  public List<Widget> findWidgetsForTopic(String tid) {
    List<Widget> widgetsForTopic = new ArrayList<Widget>();

    for (Widget w : widgets) {
      if (w.getTopicId().equals(tid)) {
        widgetsForTopic.add(w);

      }
    }
    return widgetsForTopic;
  }

  public List<Widget> findAllWidgets() {
    return widgets;
  }

  public Widget findWidgetById(String widgetId) {
    for (Widget w : widgets) {
      if (w.getId().equals(widgetId)) {
        return w;
      }
    }
    return null;
  }

  public Widget createWidget(Widget widget) {
    String newId = UUID.randomUUID().toString();
    widget.setId(newId);
    widgets.add(widget);
    return widget;
  }

  public Integer deleteWidget(String widgetId) {
    widgets.removeIf(widget -> (widget.getId().equals(widgetId)));

    return 1;
  }


  public Integer updateWidget(String widgetId, Widget newWidget) {
    int foundIndex = -1;

    for (int i = 0; i < widgets.size(); i++) {
      if (widgets.get(i).getId().equals(widgetId)) {
        foundIndex = i;
      }
    }

    if (foundIndex != -1) {
      widgets.set(foundIndex, newWidget);
    }
    return foundIndex;
  }
}
