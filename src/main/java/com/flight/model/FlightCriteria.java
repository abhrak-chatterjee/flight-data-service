package com.flight.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@NoArgsConstructor
@ToString
@JsonInclude(value = Include.NON_NULL)
public class FlightCriteria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private String flightId;

	@Getter
	@Setter
	private String flightName;

	@Getter
	@Setter
	private Double flightAmount;

	@Getter
	@Setter
	private String flightClass;

}
