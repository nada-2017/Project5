package com.example.salon1.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    @Id
    private Integer id;

    private Integer day;

    private Integer month;

    private Integer year;

    private Integer hour;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Customer customer;



    @ManyToOne
    @JoinColumn(name = "staff_id",referencedColumnName = "id")
    @JsonIgnore
    private Staff staff;

    @ManyToOne
    @JoinColumn(name = "serv_id",referencedColumnName = "id")
    @JsonIgnore
    private Serv serv;

}
