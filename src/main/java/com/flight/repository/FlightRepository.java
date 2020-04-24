package com.flight.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.flight.model.FlightModel;

@Repository
public interface FlightRepository extends MongoRepository<FlightModel, String>,FlightRepositoryCriteria {

}
