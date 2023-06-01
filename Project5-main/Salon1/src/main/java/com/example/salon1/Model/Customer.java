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

    @NotNull(message = "Name is required")
    @Size(min = 2)
    @Column(columnDefinition = "varchar(20)")
    private String name;

//    @NotNull(message = "Age is required")
//    @Positive
//    @Column(columnDefinition ="int not null")
//    private Integer age;

    @NotEmpty(message = "Phone Number is required")
    @Column(columnDefinition ="varchar(10)")
    private String phoneNumber;

    @NotEmpty(message = "Email is required")
    @Email(message = "Invalid Email",regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    @Column(columnDefinition = "varchar(40) unique")
    private String email;

    private boolean loyalty = false;

    private Integer numberOfVisit=0;

    @OneToOne(cascade = CascadeType.REMOVE,mappedBy = "customer")
    @PrimaryKeyJoinColumn
    private Appointment appointment;
}
