package com.flight.repository;

import java.util.List;

import com.flight.model.FlightCriteria;
import com.flight.model.FlightModel;

@FunctionalInterface
public interface FlightRepositoryCriteria {

	public List<FlightModel> findByCriteria(FlightCriteria criteria)
			throws Exception;
}
