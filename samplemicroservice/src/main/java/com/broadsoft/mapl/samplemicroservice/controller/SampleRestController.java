package com.broadsoft.mapl.samplemicroservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.broadsoft.mapl.samplemicroservice.log.MaplLoggerFactory;
import com.broadsoft.mapl.samplemicroservice.model.WidgetModel;

@RestController
public class SampleRestController {
	private Logger logger = MaplLoggerFactory.getLogger(SampleRestController.class);
	@RequestMapping(value = "/widgets", method = RequestMethod.GET)
	public List<WidgetModel> getWidgets() {
		logger.info("Get widgets is calling..!!");
		List<WidgetModel> widgetList = new ArrayList<>();
		WidgetModel w = new WidgetModel();
		w.setId(1);
		w.setName("Widget");
		w.setType("google");
		widgetList.add(w);
		logger.info("Get widgets are added in list..!!");
		logger.info("Get widgets are returned..!!");
		return widgetList;
	}
}