package com.Mafunzo.Mafunzo.Model;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DayRepo extends MongoRepository<Day, String> {
}
