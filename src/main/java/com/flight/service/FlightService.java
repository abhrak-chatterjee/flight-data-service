package com.flight.service;

import java.util.List;

import com.flight.model.FlightCriteria;
import com.flight.model.FlightModel;

public interface FlightService {

	public FlightModel saveFlight(FlightModel model) throws Exception;
	public List<FlightModel> getFlightByCriteria(FlightCriteria criteria) throws Exception;
}
