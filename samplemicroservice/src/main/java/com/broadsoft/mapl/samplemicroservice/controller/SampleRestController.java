package com.broadsoft.mapl.samplemicroservice.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.broadsoft.mapl.MaplLoggerFactory;
import com.broadsoft.mapl.samplemicroservice.service.WidgetDAOService;

@RestController
public class SampleRestController {

	@Autowired
	private WidgetDAOService widgetDAOService;
	private Logger logger = MaplLoggerFactory.getLogger(SampleRestController.class);

	@RequestMapping(value = "/widgets", method = RequestMethod.GET)
	public ResponseEntity<Object> getWidgets() {
		try {
			logger.info("Get widgets is calling..!!");
			return new ResponseEntity<>(widgetDAOService.getWidgets(), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Exception occurred in getWidgets():", e);
			return new ResponseEntity<>("Error occured in request", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}