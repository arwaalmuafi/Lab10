package com.example.lab10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Cannot be null")
    @Size(min = 5,message = "Length must be more than 4 characters.")
    @Column(columnDefinition = "varchar (10) not null")
    private String name;

    @Email(message = "Must be a valid email format")
    @NotEmpty(message = "not empty")
    @Column(columnDefinition = "varchar(20) unique not null")
    private String email;

    @NotEmpty(message = "Cannot be null.")
    @Column(columnDefinition = "varchar (10) not null")
    private String password;

    @NotNull(message = "cannot be null")
    @Positive(message = "Must be a number.")
    @Min(value = 21 ,message = "Must be more than 21")
    @Column(columnDefinition = "int not null")
    private Integer age;

    @NotEmpty(message = "connote be null")
    @Pattern(regexp = "^(JOB_SEEKER|EMPLOYER)$", message = "Role must be either 'JOB_SEEKER' or 'EMPLOYER'.")
    @Column(columnDefinition = "varchar (10) not null")
    private String role;

}
