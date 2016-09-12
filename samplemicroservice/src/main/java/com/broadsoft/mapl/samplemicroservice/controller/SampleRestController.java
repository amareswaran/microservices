package com.broadsoft.mapl.samplemicroservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.broadsoft.mapl.samplemicroservice.log.MaplLoggerFactory;
import com.broadsoft.mapl.samplemicroservice.model.WidgetModel;
import com.broadsoft.mapl.samplemicroservice.service.WidgetDAOService;

@RestController
public class SampleRestController {
	
	@Autowired
	private WidgetDAOService widgetDAOService;
	private Logger logger = MaplLoggerFactory.getLogger(SampleRestController.class);
	
	@RequestMapping(value = "/widgets", method = RequestMethod.GET)
	public List<WidgetModel> getWidgets() {
		logger.info("Get widgets is calling..!!");
		return widgetDAOService.getWidgets();
	}
}