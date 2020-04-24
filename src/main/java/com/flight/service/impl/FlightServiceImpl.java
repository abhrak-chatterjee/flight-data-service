package com.flight.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.flight.constants.Constants;
import com.flight.model.FlightCriteria;
import com.flight.model.FlightModel;
import com.flight.repository.FlightRepository;
import com.flight.service.FlightService;
import com.flight.util.CommonUtil;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightRepository repository;

	/**
	 * Method used for Saving the Service Configuration Document!.
	 */
	@Override
	public FlightModel saveFlight(FlightModel model) throws Exception {
		try {
			model = repository.save(prepareObject(model));
		} catch (Exception e) {
			log.info(Constants.EXCEPTION_OCCURED_WHILE_PROCESSING, e.getMessage());
			throw e;
		}
		return model;
	}

	/**
	 * Method used for searching the profile by criteria!.
	 */
	@Override
	public List<FlightModel> getFlightByCriteria(FlightCriteria criteria) throws Exception {
		List<FlightModel> list = null;
		try {
			list = repository.findByCriteria(criteria);
		} catch (Exception e) {
			log.info(Constants.EXCEPTION_OCCURED_WHILE_PROCESSING, e.getMessage());
			throw e;
		}
		return list;
	}

	/**
	 * Method used for preparing the Object!.
	 * 
	 * @param model
	 * @return
	 */
	private FlightModel prepareObject(FlightModel model) {
		if (!StringUtils.isEmpty(model.getFlightId())) {
			model.setUpdatedDate(CommonUtil.getCurrentDateInString());
			model.setUpdatedBy(Constants.FLIGHT_SERVICE);
		} else {
			model.setCreatedDate(CommonUtil.getCurrentDateInString());
			model.setCreatedBy(Constants.FLIGHT_SERVICE);
		}
		return model;
	}

}
