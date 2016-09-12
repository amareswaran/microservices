package com.broadsoft.mapl.samplemicroservice.service;

import java.util.List;

import com.broadsoft.mapl.samplemicroservice.model.WidgetModel;

public interface WidgetDAOService {
	public abstract List<WidgetModel> getWidgets();
}