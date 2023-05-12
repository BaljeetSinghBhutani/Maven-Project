package com.example.startProject.Repository;

import com.example.startProject.model.Person;

import java.sql.SQLException;
import java.util.List;


public interface PersonRepositoryInterf {
      boolean deletePerson(int id);

      Person getPersonById(int id);



    void createPersonStatic(Person person);

    void createPerson(Person person) throws SQLException;

    List<Person> getAllPersons();
}
