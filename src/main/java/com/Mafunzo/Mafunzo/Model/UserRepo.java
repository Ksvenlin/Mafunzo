
package com.Mafunzo.Mafunzo.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * UserRepo is an interface that extends MongoRepository and is used to interact with the database.
 *
 * @author Kevin Nordkvist & Adam Mheisen
 */

@Repository
public interface UserRepo extends MongoRepository<User, String> {
    /**
     * Method that finds a user by email in the DB.
     *
     * @param email the email of the user as a String.
     * @return an Optional of a User.
     */
    Optional<User> findByEmail(String email);
}