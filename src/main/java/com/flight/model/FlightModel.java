package com.flight.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@Document(value = "flight_info")
@JsonInclude(value = Include.NON_NULL)
@ToString
@NoArgsConstructor
public class FlightModel implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@Id
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
	
	@Getter
	@Setter
	private String createdBy;
	
	@Getter
	@Setter
	private String createdDate;
	
	@Getter
	@Setter
	private String updatedDate;
	
	@Getter
	@Setter
	private String updatedBy;

}
