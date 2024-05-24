package com.Mafunzo.Mafunzo.Model;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * DayRepo is an interface that extends MongoRepository and is used to interact with the database.
 *
 * @Author William Starå
 */

@Repository
public interface DayRepo extends MongoRepository<Day, String> {
}
