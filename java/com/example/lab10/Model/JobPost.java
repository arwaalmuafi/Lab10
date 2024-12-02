package com.example.lab10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class JobPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Cannot be null")
    @Size(min = 4,message = "Length must be more than 4 characters.")
    @Column(columnDefinition = "varchar (10) not null")
    private String title;

    @NotEmpty(message = "Cannot be null")
    @Size(min = 4,message = "Length must be more than 4 characters.")
    @Column(columnDefinition = "varchar (20) not null")
    private String description;

    @NotEmpty(message = "Cannot be null.")
    @Column(columnDefinition = "varchar (10) not null")
    private String location;

    @NotNull(message = "Cannot be null.")
    @Positive(message = "Must be a non-negative number.")
    @Column(columnDefinition = "int not null")
    private Integer salary;


    private LocalDate postingDate;
}
