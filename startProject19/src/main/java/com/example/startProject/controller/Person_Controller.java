package com.example.startProject.controller;

import com.example.startProject.Service.ServiceImp.PersonServiceInterf;
import com.example.startProject.dtos.CreatePersonRequest;
import com.example.startProject.exceptions.BadPersonRequestException;
import com.example.startProject.model.Person;
import jakarta.validation.Valid;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class Person_Controller {

private static Logger Logger  = LoggerFactory.getLogger(Person_Controller.class);

@Autowired
    PersonServiceInterf personServiceInterf;

@PostMapping("/addPerson")
    public ResponseEntity createPerson(@RequestBody @Valid CreatePersonRequest  createPersonRequest) throws SQLException {
      Logger.info("createPersonRequest- {} ", createPersonRequest);


//      if(createPersonRequest.getFirstName()==null || createPersonRequest.getFirstName().isEmpty())
//      {
//          Logger.info("Person first name is empty!!");
//          return;
//      }
//
       Logger.info("Going to save to db ");
       personServiceInterf.createPersonStatic( createPersonRequest);
//

    MultiValueMap<String, String> headers  = new HttpHeaders();
    headers.add("Sample_Header", "New Person type Object");

    return new ResponseEntity(new Person(), headers, HttpStatus.CREATED);

}


@GetMapping("getPerson")
    public Person getPersonById(@RequestParam("id") int id ){
    return personServiceInterf.getPersonById(id);

    }

    @DeleteMapping("/deletePerson/{id}")
        public void DeletePerson(@PathVariable("id") int id) throws BadPersonRequestException {
    Person person  = personServiceInterf.getPersonById(id);
             personServiceInterf.deletePerson(id);


    }


    @GetMapping("getAllPersons")
    public List<Person> getAllPerson(){
return personServiceInterf.getAllPersons();
    }


}



















