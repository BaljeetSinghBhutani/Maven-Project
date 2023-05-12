package com.example.startProject.dtos;

import com.example.startProject.model.Person;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreatePersonRequest {

    @NotBlank(message = "First Name Should not be empty")
    private String firstName;
    private String LastName;

    @NotBlank(message = "DOB Should not be empty")
    private String dob;


       public Person to(){
           return Person.builder()
                   .firstName(firstName)
                   .LastName(LastName)
                   .dob(dob).build();
       }


}
