package com.flight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flight.constants.Constants;
import com.flight.model.FlightCriteria;
import com.flight.model.FlightModel;
import com.flight.service.FlightService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@Api(value = "This API is created for User API Specs!")
@CrossOrigin
public class FlightController {

	@Autowired
	private FlightService service;

	/**
	 * This method is used for getting the Flight details by Criteria!
	 * 
	 * @param criteria
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/api-service/flight/v1/criteria", produces = "application/json")
	@ApiOperation(httpMethod = "POST", value = "This method is used for getting the Users by Specified Criteria! ", produces = "application/json", response = FlightModel.class)
	public ResponseEntity getUsersByCriteria(@RequestBody(required = true) FlightCriteria criteria) throws Exception {
		ResponseEntity response = null;
		try {
			response = new ResponseEntity(service.getFlightByCriteria(criteria), HttpStatus.OK);

		} catch (Exception e) {
			log.info(Constants.EXCEPTION_OCCURED_WHILE_PROCESSING, e.getMessage());
			response = new ResponseEntity(Constants.EXCEPTION_OCCURED_WHILE_PROCESSING, HttpStatus.BAD_REQUEST);
			throw e;
		}
		return response;
	}

	/**
	 * This method is used for saving the Flight details!
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/api-service/flight/v1/saveProfile", produces = "application/json")
	@ApiOperation(httpMethod = "POST", value = "This method is used for persisting the Reason Code!.", produces = "application/json", response = FlightModel.class)
	public ResponseEntity saveUser(@RequestBody(required = true) FlightModel model) throws Exception {
		ResponseEntity response = null;
		try {
			response = new ResponseEntity(service.saveFlight(model), HttpStatus.OK);

		} catch (Exception e) {
			log.info(Constants.EXCEPTION_OCCURED_WHILE_PROCESSING, e.getMessage());
			response = new ResponseEntity(Constants.EXCEPTION_OCCURED_WHILE_PROCESSING, HttpStatus.BAD_REQUEST);
			throw e;
		}
		return response;
	}

}
