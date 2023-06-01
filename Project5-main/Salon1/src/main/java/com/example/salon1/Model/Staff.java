package com.example.salon1.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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


    @Min(value = 1)
    @Max(value = 5)
    private Double rating;

    @NotEmpty(message = "role can't be empty")
    @Column(columnDefinition = "varchar(20) not null check(role ='supervisor' or role='beautician')")
    private String role;

    @NotEmpty(message = "email can't be empty")
    @Email
    private String email;

    @NotNull(message = "salary can't be empty")
    private Integer salary;



    @OneToMany(cascade = CascadeType.ALL, mappedBy = "staff")
    @JsonIgnore
    private Set<Appointment> appointmentSet;


    @ManyToMany
    @JsonIgnore
    private Set<Serv> servSet;
}
