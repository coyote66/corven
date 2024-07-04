package com.corven.test.corventest.service;

import com.corven.test.corventest.dao.PersonDAO;
import com.corven.test.corventest.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonDAO personDAO;

    public List<Person> get(){
        return personDAO.findAll();
    }

    public Person save(Person person){

        return personDAO.save(person);
    }

    public void delete(Person person){
       personDAO.delete(person);
    }


}
