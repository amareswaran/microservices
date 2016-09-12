package com.broadsoft.mapl.samplemicroservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.broadsoft.mapl.samplemicroservice.model.WidgetModel;

@RestController
public class MAPLRestController {

	@RequestMapping(value = "/widgets", method = RequestMethod.GET)
	public List<WidgetModel> getWidgets() {
		List<WidgetModel> widgetList = new ArrayList<>();
		WidgetModel w = new WidgetModel();
		w.setId(1);
		w.setName("Widget");
		w.setType("google");
		widgetList.add(w);
		return widgetList;
	}
}