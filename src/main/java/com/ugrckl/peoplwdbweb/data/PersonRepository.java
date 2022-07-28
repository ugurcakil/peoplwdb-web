package com.ugrckl.peoplwdbweb.data;

import com.ugrckl.peoplwdbweb.biz.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
}