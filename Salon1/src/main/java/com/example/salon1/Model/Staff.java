package com.example.salon1.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name can't be empty")
    private String name;

    @NotNull(message = "age can't be empty")
    private Integer age;

    @NotEmpty(message = "gender can't be empty")
    @Pattern(regexp = "\\b(?:Female|Male)\\b",message = "Gender Not Valid")
    @Column(columnDefinition = "varchar(10) not null check(gender='Female' or gender='Male')")
    private String gender;

    @NotEmpty(message = "role can't be empty")
    @Column(columnDefinition = "varchar(20) not null check(role ='supervisor' or role='user')")
    private String role;

    @NotEmpty(message = "email can't be empty")
    @Email(message = "Invalid Email",regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    @Column(columnDefinition = "varchar(40) unique")
    private String email;

    @NotNull(message = "salary can't be empty")
    private double salary;

    @NotEmpty(message = "status can't be empty")
    @Pattern(regexp = "\\b(?:available|busy)\\b",message = "status Not Valid")
    @Column(columnDefinition = "varchar(10) not null check(status='available' or status='busy')")
    private String status;


    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "staffSet")
    private Set<Appointment> appointmentSet;


    @ManyToMany(mappedBy = "staff")
    private Set<Serv> servSet;
}
