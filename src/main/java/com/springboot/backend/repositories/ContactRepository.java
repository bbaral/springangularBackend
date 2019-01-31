package com.springboot.backend.repositories;

import com.springboot.backend.models.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Bikram Baral
 * Date: 1/30/2019
 */
@Repository
public interface ContactRepository extends MongoRepository<Contact, String> {

}
