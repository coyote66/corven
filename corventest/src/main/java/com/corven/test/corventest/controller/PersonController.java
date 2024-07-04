package com.corven.test.corventest.controller;

import com.corven.test.corventest.model.Person;
import com.corven.test.corventest.service.PersonService;
import com.corven.test.corventest.utils.ServiceResponse;
import com.corven.test.corventest.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    private static Logger logger = LoggerFactory.getLogger(PersonController.class);

    @GetMapping("all")
    public List<Person> getPerson(){
        return personService.get();
    }

    @PostMapping("save")
    public ServiceResponse savePerson(@RequestBody Person _person){

        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.setOperationType("save");
        Person person = null;
        try {

            if(isValidAge(_person)) {
                person = personService.save(_person);
            }else{
                serviceResponse.setErrorDescription("Age not compliant");
            }

        }catch (Exception e){
            serviceResponse.setErrorDescription(e.getMessage());
        }
        serviceResponse.setPerson(person);

        return serviceResponse;
    }

    @PostMapping("delete")
    public ServiceResponse deletePerson(@RequestBody Person _person){

        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.setOperationType("delete");
        Person person = null;
        try {
          personService.delete(_person);
        }catch (Exception e){
            serviceResponse.setErrorDescription(e.getMessage());
        }
        serviceResponse.setPerson(person);

        return serviceResponse;
    }


    private boolean isValidAge(Person _person){
        boolean valid=false;
        try {
            valid =  Utils.getAge(_person.getBornDate());
        }catch (Exception e){
            e.printStackTrace();
        }
        return  valid;
    }

}
