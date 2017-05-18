package org.educama.services.flightinformation.repository;

import org.educama.services.flightinformation.model.Airline;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by GMA on 15.05.2017.
 */
public interface AirlineRepository extends MongoRepository<Airline, String> {
    public Airline findByName(String name);

    public List<Airline> findByIataCode(String iataCode);

    public List<Airline> findByNameLike(String name);

    public List<Airline> findByIataCodeLike(String iataCode);

    public List<Airline> findByCallSignLike(String callSign);
}
