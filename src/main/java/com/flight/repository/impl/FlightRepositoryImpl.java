package com.flight.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.flight.constants.Constants;
import com.flight.model.FlightCriteria;
import com.flight.model.FlightModel;
import com.flight.repository.FlightRepositoryCriteria;

import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
public class FlightRepositoryImpl implements FlightRepositoryCriteria {

	@Autowired
	private MongoTemplate repository;

	@Override
	public List<FlightModel> findByCriteria(FlightCriteria criteria) throws Exception {
		List<FlightModel> list = null;
		try {
			list = repository.find(getWhereClause(criteria), FlightModel.class);
		} catch (Exception e) {
			log.info(Constants.EXCEPTION_OCCURED_WHILE_PROCESSING, e.getMessage());
			throw e;
		}
		return list;
	}

	/**
	 * Method used for Preparing the Where Clause
	 * 
	 * @param criteria
	 * @param builder
	 * @param model
	 * @return
	 */
	private Query getWhereClause(FlightCriteria criteria) {
		Query whereClause = new Query();
		if (!StringUtils.isEmpty(criteria.getFlightId())) {
			whereClause.addCriteria(Criteria.where(Constants.FLIGHT_ID).is(criteria.getFlightId()));
		}
		if (!StringUtils.isEmpty(criteria.getFlightName())) {
			whereClause.addCriteria(Criteria.where(Constants.FLIGHT_NAME).is(criteria.getFlightName()));
		}
		if (!StringUtils.isEmpty(criteria.getFlightClass())) {
			whereClause.addCriteria(Criteria.where(Constants.FLIGHT_CLASS).is(criteria.getFlightClass()));
		}
		if (!StringUtils.isEmpty(criteria.getFlightAmount())) {
			whereClause.addCriteria(Criteria.where(Constants.FLIGHT_AMOUNT).is(criteria.getFlightAmount()));
		}
		return whereClause;
	}

}
