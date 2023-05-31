package com.example.salon1.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Name is required")
    @Size(min = 2)
    @Column(columnDefinition = "varchar(20)")
    private String name;

    @NotEmpty(message = "Gender is required")
    @Pattern(regexp = "\\b(?:Female|Male)\\b",message = "Gender Not Valid")
    @Column(columnDefinition = "varchar(10) not null check(gender='Female' or gender='Male')")
    private String gender;

    @NotNull(message = "Age is required")
    @Positive
    @Column(columnDefinition ="int not null")
    private Integer age;

    @NotNull(message = "Phone Number is required")
    @Positive
    @Column(columnDefinition ="int not null")
    private Integer phoneNumber;

    @NotEmpty(message = "Email is required")
    @Email(message = "Invalid Email",regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")

    @NotEmpty(message = "Email is required")
    @Email(message = "Invalid Email",regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    @Column(columnDefinition = "varchar(40) unique")
    private String email;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "customer")
    @PrimaryKeyJoinColumn
    private Appointment appointment;
}
