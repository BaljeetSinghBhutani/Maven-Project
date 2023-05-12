package com.example.startProject.Service.ServiceImp;

import com.example.startProject.dtos.CreatePersonRequest;
import com.example.startProject.exceptions.BadPersonRequestException;
import com.example.startProject.model.Person;

import java.sql.SQLException;
import java.util.List;


public interface PersonServiceInterf  {
     Person deletePerson(int id) throws BadPersonRequestException;


    void createPersonStatic(CreatePersonRequest createPersonRequest) throws SQLException;


    Person getPersonById(int id);


    List<Person> getAllPersons();
}
