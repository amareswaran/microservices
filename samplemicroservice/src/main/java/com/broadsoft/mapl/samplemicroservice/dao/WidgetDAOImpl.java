package com.broadsoft.mapl.samplemicroservice.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.broadsoft.mapl.samplemicroservice.log.MaplLoggerFactory;
import com.broadsoft.mapl.samplemicroservice.model.WidgetModel;
import com.broadsoft.mapl.samplemicroservice.service.WidgetDAOService;

@Repository
public class WidgetDAOImpl implements WidgetDAOService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private Logger logger = MaplLoggerFactory.getLogger(WidgetDAOImpl.class);
	
	@Override
	public List<WidgetModel> getWidgets() {
		logger.info("Get widgets request in DAO..!!");
		Collection<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT ID,NAME,TYPE FROM WIDGET");
		List<WidgetModel> widgetList = new ArrayList<>();
		rows.stream().map((row) -> {
			WidgetModel widgetModel = new WidgetModel();
			widgetModel.setId(Integer.parseInt(String.valueOf(row.get("ID"))));
			widgetModel.setName((String) row.get("NAME"));
			widgetModel.setType((String) row.get("TYPE"));
			return widgetModel;
		}).forEach((ss) -> {
			widgetList.add(ss);
		});
		logger.info("Get widgets are added in list and returned");
		return widgetList;
	}
}