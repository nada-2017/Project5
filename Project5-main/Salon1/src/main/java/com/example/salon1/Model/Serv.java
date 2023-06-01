package com.example.salon1.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
public class Serv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @Column(columnDefinition = "varchar(20) not null check (category='makeup' or category='hairStyle' or category='bodyCare' or category='spa')")
    private String category;

    @Column(columnDefinition = "int not null")
    private Integer price;

    @ManyToMany(mappedBy = "servSet",cascade = CascadeType.REMOVE)
    private Set<Staff> staff; // ghadeer with staff

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serv")
    private Set<Appointment> appointments; // Amwaj with opp


}
