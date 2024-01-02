package com.orkut.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue

    private int userId;

    @Size(min = 4,message = "User Name Must Be Four Character")
    private String userName;

    private String userAddress;


    private long userContactNumber;

  @JsonFormat(timezone = "dd-MM-yyyy")
    private Date userDob;

    @Email(message = "Email Id Must Be Valid")
    private String userEmailId;

    @Size(min = 4,message = "Password Should be atleast 4 char")
    private String userPassword;
}
