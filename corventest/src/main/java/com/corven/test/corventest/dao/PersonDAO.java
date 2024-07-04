package com.corven.test.corventest.dao;

import com.corven.test.corventest.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDAO extends JpaRepository<Person,Long> {

}
