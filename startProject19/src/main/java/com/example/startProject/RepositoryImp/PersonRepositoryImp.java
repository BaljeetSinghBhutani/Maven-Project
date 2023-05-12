package com.example.startProject.RepositoryImp;

import com.example.startProject.Repository.PersonRepositoryInterf;
import com.example.startProject.model.Person;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepositoryImp implements PersonRepositoryInterf {

    private Connection connection;


    private PreparedStatement preparedStatement;
    private static Logger Logger = LoggerFactory.getLogger(PersonRepositoryImp.class);

    public PersonRepositoryImp(Connection connection) throws SQLException {
        this.connection = connection;
        createTable();
    }




    @Override
    public void createPersonStatic(Person person) {
        try {
            Statement statement = connection.createStatement();
           int result =   statement.executeUpdate("insert into person(id, first_name, last_name, age, dob )" +
                    "VALUES(1, 'Peter', 'Parkar', 25, '1996-10-19')" );
            Logger.info("Insert Statement Result -{}", result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private void createTable() throws SQLException {
Statement statement =  connection.createStatement();
statement.execute("create table if not exists person(id int primary key auto_increment, first_name varchar(30)," +
        " last_name varchar(30), age int , dob varchar(12)) ");
    }


    public void createPerson(Person person) throws SQLException {
        this.preparedStatement = connection.prepareStatement(("insert into person( first_name, last_name, age, dob )" +
                "VALUES(?, ?, ?, ?)" ));
//        preparedStatement.setInt(0, person.getId());
        preparedStatement.setString(1, person.getFirstName() );
        preparedStatement.setString(2, person.getLastName());
        preparedStatement.setInt(3, person.getAge());
        preparedStatement.setString(4, person.getDob());

        int result  = preparedStatement.executeUpdate();

        Logger.info("Insert Statement result - {}", result);


    }



    public Person getPersonById(int id)
    {
        try {
            this.preparedStatement = connection.prepareStatement("select * from person where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
            {
         return getPersonFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    private Person getPersonFromResultSet(ResultSet resultSet) throws SQLException {
                 resultSet.getInt("id");
               resultSet.getString("first_name");
               resultSet.getString("last_name");
                 resultSet.getInt(4);
               resultSet.getString(5);

               return Person.builder()
                       .firstName(resultSet.getString("first_name"))
                       .LastName( resultSet.getString("last_name"))
                       .id(resultSet.getInt("id"))
                       .age( resultSet.getInt(4))
                       .dob(resultSet.getString(5)).build();




    }


    @Override
    public boolean deletePerson(int id) {
        try {
            this.preparedStatement = connection.prepareStatement("delete from person where id = ?");
            preparedStatement.setInt(1, id);
      int result = preparedStatement.executeUpdate();
      Logger.info("Delete statement result {}", result);
      return result >=1 ? true:  false;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }



    @Override
    public List<Person> getAllPersons() {

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet =   statement.executeQuery("select * from person");

            List<Person>  personList = new ArrayList<>();

            while (resultSet.next())
            {
                Person person = getPersonFromResultSet(resultSet);
                personList.add(person);
            }

            return personList;
//            Logger.info("Insert Statement Result -{}", resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


//        return null;
    }
}
